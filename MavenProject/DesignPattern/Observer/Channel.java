package DesignPattern.Observer;


import java.util.HashSet;
import java.util.Set;

public class Channel {
    private Set<User> subscribers = new HashSet<>();
    private String channelName;

    public String getChannelName() {
        return channelName;
    }

    public Channel(String channelName) {
        this.channelName = channelName;
    }

    public void subscribe(User user){
        subscribers.add(user);
    }

    public void unSubscribe(User user){
        subscribers.remove(user);
    }

    public void notify(String videoName){
        subscribers.forEach(s -> s.update(channelName,videoName));
    }
}
