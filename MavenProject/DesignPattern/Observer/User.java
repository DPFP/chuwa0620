package DesignPattern.Observer;
import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private Set<Channel> subscriptions = new HashSet<>();
    public void update(String channelName,String video){
        System.out.println("Hi "+ name+"! new video "+ video + " from channel " + channelName+" uploaded");
    }
    public User(String name) {
        this.name = name;
    }
    public void subscribe(Channel channel){
        subscriptions.add(channel);
        channel.subscribe(this);
        System.out.println("Thanks "+name+" for subscribing "+ channel.getChannelName());
    }
    public void unSubscribe(Channel channel){
        subscriptions.remove(channel);
        channel.unSubscribe(this);
    }
}
