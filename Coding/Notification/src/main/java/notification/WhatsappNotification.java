package notification;

import user.User;

import java.util.HashSet;
import java.util.Set;

public class WhatsappNotification implements NotificationInterface {
    private Set<User> userList;

    public WhatsappNotification(){
        userList = new HashSet<>();
    }

    @Override
    public void notifyUser(User user, String msg) {
        System.out.println("Hi, "+user.getName()+". The WhatsApp info is: "+msg);
    }

    @Override
    public void broadCast(String msg) {
        for(User user:userList){
            System.out.println("Hi, "+user.getName()+". The WhatsApp broadcast info is: "+msg);
        }
    }

    @Override
    public void registerUser(User user) {
        userList.add(user);
    }
}
