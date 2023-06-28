package chuwa.learn.observer;

public class WeixinUser implements Observer{

    private String name;

    WeixinUser(String name){
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name+message);
    }
}
