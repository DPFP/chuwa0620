package com.example.project_1.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/utils")
public class UtilController {

    @PostMapping("/text-to-pdf")
    public byte[] convertTextToPdf(@RequestBody String text) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // 将文字添加到PDF页面
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.newLineAtOffset(50, 700); // 设置起始位置
            contentStream.showText(text);
            contentStream.endText();
            contentStream.close();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            document.save(outputStream);


            String filePath = "./file.pdf";
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                document.save(fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @GetMapping("/set-cookie")
    public String setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "cookie-value");
        cookie.setMaxAge(3600); // 设置过期时间（以秒为单位），此处设置为1小时
        cookie.setPath("/"); // 设置Cookie的作用路径，根路径下的所有URL都能访问该Cookie
        response.addCookie(cookie);
        return "Cookie has been set!";
    }

    @GetMapping("/get-cookie")
    public String getCookie(@CookieValue("myCookie") String cookieValue) {
        return "Cookie value: " + cookieValue;
    }
}