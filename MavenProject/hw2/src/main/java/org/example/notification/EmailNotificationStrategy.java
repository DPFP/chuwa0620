package org.example.notification;

public class EmailNotificationStrategy implements NotificationStrategy {
    /**
     * @param isGlobal: To see if this message sends to all users without username
     * @param userName: user name
     * @param prompt: some message
     * @return void
     * @description THis function is to notify subscriber by email
     * @author zhanghm
     * @date 6/23/23 2:39 PM
     */
    @Override
    public void notify(Boolean isGlobal, String userName, String prompt) {
        if (isGlobal) {
            System.out.println("To " + userName + " by email: " + prompt);
        } else {
            System.out.println("To " + userName + " by email: Hey " + userName + ", " + prompt);
        }
    }
}
