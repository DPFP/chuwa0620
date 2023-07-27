package com.chuwa.rewardprogram.payload;

public class CustomerDto {
    private long id;
    private String userName;

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


    public CustomerDto(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public CustomerDto() {

    }
}
