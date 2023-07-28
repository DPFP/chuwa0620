package com.yuming.rewardsprogram.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerDto {
    private long id;
    private String name;
    private String email;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}