package com.example.project.service;

import java.time.LocalDate;

public interface GenerateFileService {
    public String generateCSVFile(Long customerId, LocalDate endDate, int period, String filePath);
}
