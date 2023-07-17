package com.chuwa.learn.general.thread.c01_create;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("my thread extends thread");
    }
}
