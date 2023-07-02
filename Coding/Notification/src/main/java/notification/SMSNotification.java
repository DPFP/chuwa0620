package notification;

import user.User;

import java.util.HashSet;
import java.util.Set;

public class SMSNotification implements NotificationInterface {
    private Set<User> userList;

    public SMSNotification(){
        userList = new HashSet<>();
    }

    @Override
    public void notifyUser(User user, String msg) {
        System.out.println("Hi, "+user.getName()+". The SMS info is: "+msg);
    }

    @Override
    public void broadCast(String msg) {
        for(User user:userList){
            System.out.println("Hi, "+user.getName()+". The SMS broadcast info is: "+msg);
        }
    }

    @Override
    public void registerUser(User user) {
        userList.add(user);
    }
}
