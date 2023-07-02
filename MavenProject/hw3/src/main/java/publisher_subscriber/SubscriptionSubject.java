package publisher_subscriber;

import java.util.ArrayList;
import java.util.List;
public class SubscriptionSubject implements Subject{
    // 定义一个集合，用来存储多个观察者对象
    private List<Observer> wechatUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        wechatUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        wechatUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : wechatUserList) {
            // 调用观察这对象的update方法
            observer.update(message);
        }
    }
}
