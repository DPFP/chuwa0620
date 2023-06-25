package com.chuwa.learn.hw2.enums;

public enum NotificationMsg {

    /**
     * send register msg to all User
     */
    RegisterMsg("Hey %s, you have successfully registered to add and here is your , " +
            "please use this for future references."),

    /**
     * sms
     */
    BroadcastMsg("40% off when you buy Popeyes between 06/13 - 06/19");

    private String msg;

    private NotificationMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
