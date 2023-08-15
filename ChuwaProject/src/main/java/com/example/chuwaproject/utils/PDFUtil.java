package com.example.chuwaproject.utils;

import com.example.chuwaproject.dto.OrderDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.FontFormat;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PDFUtil {
    public static byte[] generatePdf(List<OrderDTO> orderDTOList) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            // Set font and font size for the table
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

            // Set the table headers
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Order ID");
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText("User ID");
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText("Total");
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText("Date");
            contentStream.endText();

            // Set font and font size for the table data
            contentStream.setFont(PDType1Font.HELVETICA, 12);

            // Display the data in the table
            int yPosition = 675; // Initial y-position for the table data
            for (OrderDTO orderDTO : orderDTOList) {
                contentStream.beginText();
                contentStream.newLineAtOffset(100, yPosition);
                contentStream.showText(String.valueOf(orderDTO.getId()));
                contentStream.newLineAtOffset(100, 0);
                contentStream.showText(String.valueOf(orderDTO.getUserId()));
                contentStream.newLineAtOffset(100, 0);
                contentStream.showText(String.valueOf(orderDTO.getTotal()));
                contentStream.newLineAtOffset(100, 0);
                contentStream.showText(orderDTO.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
                contentStream.endText();
                yPosition -= 20; // Move to the next row in the table
            }
        }

        document.save(outputStream);
        document.close();
        return outputStream.toByteArray();
    }
}
