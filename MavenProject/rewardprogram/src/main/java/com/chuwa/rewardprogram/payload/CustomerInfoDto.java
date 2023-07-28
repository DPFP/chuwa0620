package com.chuwa.rewardprogram.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerInfoDto {
    private long id;
    private String userName;
    private int totalPoints;
    @JsonProperty("points_in_the_past_month")
    private int firstMonth;
    @JsonProperty("points_in_the_second_past_month")
    private int secondMonth;
    @JsonProperty("points_in_the_third_past_month")
    private int thirdMonth;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getFirstMonth() {
        return firstMonth;
    }

    public void setFirstMonth(int firstMonth) {
        this.firstMonth = firstMonth;
    }

    public int getSecondMonth() {
        return secondMonth;
    }

    public void setSecondMonth(int secondMonth) {
        this.secondMonth = secondMonth;
    }

    public int getThirdMonth() {
        return thirdMonth;
    }

    public void setThirdMonth(int thirdMonth) {
        this.thirdMonth = thirdMonth;
    }

    public CustomerInfoDto(long id, String userName, int totalPoints, int firstMonth, int secondMonth, int thirdMonth) {
        this.id = id;
        this.userName = userName;
        this.totalPoints = totalPoints;
        this.firstMonth = firstMonth;
        this.secondMonth = secondMonth;
        this.thirdMonth = thirdMonth;
    }

    public CustomerInfoDto() {

    }
}
