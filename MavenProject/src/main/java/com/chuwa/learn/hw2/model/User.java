package com.chuwa.learn.hw2.model;

import com.chuwa.learn.hw2.enums.NotificationType;
import com.chuwa.learn.hw2.utils.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {

    private String userId;

    private String firstName;

    private String lastName;

    private NotificationType preferType;

    public User(String firstName, String lastName) {
        this.userId = CommonUtil.generateUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.preferType = NotificationType.Email; // default to email
    }

    public User(String firstName, String lastName, NotificationType preferType) {
        this(firstName, lastName);
        this.preferType = preferType;
    }
}
