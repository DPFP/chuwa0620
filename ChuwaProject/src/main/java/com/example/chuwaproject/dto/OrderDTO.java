package com.example.chuwaproject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {
    private long id;
    private long userId; // Temporary field to hold the userId
    private int total;
    private LocalDate date;

}
