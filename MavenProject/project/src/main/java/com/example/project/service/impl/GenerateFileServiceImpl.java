package com.example.project.service.impl;

import com.example.project.service.GenerateFileService;
import com.example.project.service.RewardService;
import com.example.project.util.EncryptUtil;
import com.example.project.util.csvUtil;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

@Service
public class GenerateFileServiceImpl implements GenerateFileService {
    private RewardService rewardService;

    public GenerateFileServiceImpl(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @Override
    public String generateCSVFile(Long customerId, LocalDate endDate, int period){
        Map<String, Long> data = rewardService.getRewardsByCustomerIdAndPeriod(customerId, endDate, period).getMonthlyReport();
        return csvUtil.convertHashMapToCsv(data);
    }
}
