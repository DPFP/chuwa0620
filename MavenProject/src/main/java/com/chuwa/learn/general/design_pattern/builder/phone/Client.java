package com.chuwa.learn.general.design_pattern.builder.phone;

public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("three star")
                .memory("8G")
                .mainBoard("hua suo")
                .build();
        System.out.println(phone);
    }
}
