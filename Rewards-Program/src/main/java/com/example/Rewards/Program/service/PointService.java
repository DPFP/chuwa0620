package com.example.Rewards.Program.service;

import com.example.Rewards.Program.payload.PointDto;
import com.example.Rewards.Program.payload.TransactionDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PointService {
    PointDto createPoint(long customerId, TransactionDto transactionDto);
    PointDto findPointById(long id);
    double findTotalPoint(long customerId);
    double findAveragePoint(long customerId, LocalDate startMonth, LocalDate endMonth);
    PointDto updatePoint(long id, TransactionDto transactionDto);
    void deletePointById(long id);
}
