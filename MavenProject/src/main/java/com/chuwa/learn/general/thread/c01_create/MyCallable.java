package com.chuwa.learn.general.thread.c01_create;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "my callable implement callable";
    }
}
