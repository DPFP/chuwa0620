package com.chuwa.RewardsProgram.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.YearMonth;
import java.util.List;

public class RewardsDto {
    public static class MonthlyDto{
//        private String month;
//        private YearMonth yearMonth;
//        private Double monthlyPoints;

        @JsonProperty("year_month")
        private YearMonth yearMonth;

        @JsonProperty("monthly_points")
        private Double monthlyPoints;

        public MonthlyDto(YearMonth yearMonth, Double monthlyPoints) {
            this.yearMonth = yearMonth;
            this.monthlyPoints = monthlyPoints;
        }

        public MonthlyDto(){

        }

        public YearMonth getYearMonth() {
            return yearMonth;
        }

        public void setYearMonth(YearMonth yearMonth) {
            this.yearMonth = yearMonth;
        }

        public Double getMonthlyPoints() {
            return monthlyPoints;
        }

        public void setMonthlyPoints(Double monthlyPoints) {
            this.monthlyPoints = monthlyPoints;
        }


    }

    private long userId;
    private List<MonthlyDto> monthlyRewards;
    private Double totalRewards;


    public RewardsDto(long userId, List<MonthlyDto> monthlyRewards, Double totalRewards) {
        this.userId = userId;
        this.monthlyRewards = monthlyRewards;
        this.totalRewards = totalRewards;
    }

    public RewardsDto(){

    }

    public long getUserId() { return userId;}

    public void setUserId(long userId) { this.userId = userId;}

    public List<MonthlyDto> getMonthlyRewards() {
        return monthlyRewards;
    }

    public void setMonthlyRewards(List<MonthlyDto> monthlyRewards) {
        this.monthlyRewards = monthlyRewards;
    }

    public Double getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(Double totalRewards) {
        this.totalRewards = totalRewards;
    }
}
