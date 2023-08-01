package com.example.project.controller;

import com.example.project.payload.RewardDto;
import com.example.project.service.GenerateFileService;
import com.example.project.service.RewardService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1")
public class GenerateFileController {
    private GenerateFileService generateFileService;

    public GenerateFileController(GenerateFileService generateFileService) {
        this.generateFileService = generateFileService;
    }

    @GetMapping("/customers/{customerId}/files")
    ResponseEntity<String> GenerateFileByCustomerId(@PathVariable(name = "customerId") Long customerId,
                                                    @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name = "endDate", required = true) LocalDate endDate,
                                                    @RequestParam(name = "period", required = true) int period,
                                                    @RequestParam(name = "filePath", required = true) String filePath){
        return new ResponseEntity<>(generateFileService.generateCSVFile(customerId, endDate, period, filePath), HttpStatus.OK);
    }
}
