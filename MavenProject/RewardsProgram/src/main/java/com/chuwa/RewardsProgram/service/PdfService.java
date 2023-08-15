package com.chuwa.RewardsProgram.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface PdfService {
    ByteArrayInputStream generatePdf() throws IOException;;
}
