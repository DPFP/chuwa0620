package notification;

import user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmailNotification implements NotificationInterface {
    private Set<User> userList;

    public EmailNotification(){
        userList = new HashSet<>();
    }

    @Override
    public void notifyUser(User user, String msg) {
        System.out.println("Hi, "+user.getName()+". The email info is: "+msg);
    }

    @Override
    public void broadCast(String msg) {
        for(User user:userList){
            System.out.println("Hi, "+user.getName()+". The email broadcast info is: "+msg);
        }
    }

    @Override
    public void registerUser(User user) {
        userList.add(user);
    }
}
