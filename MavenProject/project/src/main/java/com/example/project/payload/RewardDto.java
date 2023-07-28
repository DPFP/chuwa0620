package com.example.project.payload;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class RewardDto {
    private LocalDate endDate;
    private int period;
    private Long totalRewards;
    private Map<String, Long> monthlyReport = new LinkedHashMap<>();

    public RewardDto() {}

    public RewardDto(LocalDate endDate, int period) {
        this.endDate = endDate;
        this.period = period;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Long getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(Long totalRewards) {
        this.totalRewards = totalRewards;
    }

    public Map<String, Long> getMonthlyReport() {
        return monthlyReport;
    }

    public void setMonthlyReport(Map<String, Long> monthlyReport) {
        this.monthlyReport = monthlyReport;
    }
}
