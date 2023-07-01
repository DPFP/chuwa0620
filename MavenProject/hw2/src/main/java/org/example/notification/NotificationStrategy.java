package org.example.notification;

public interface NotificationStrategy {
    /**
     * @param isGlobal: To see if this message sends to all users without username
     * @param userName: user name
     * @param prompt: some message
     * @return void
     * @description THis function is to notify subscriber by email
     * @author zhanghm
     * @date 6/23/23 2:39 PM
     */
    void notify(Boolean isGlobal, String userName, String prompt);
}
