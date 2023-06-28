import java.util.ArrayList;
import java.util.List;

// 订阅者接口
interface Subscriber {
    void update(String message);
}

// 具体订阅者类
class ConcreteSubscriber implements Subscriber {
    private String name;

    public ConcreteSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// 发布者类
class Publisher {
    private List<Subscriber> subscribers;

    public Publisher() {
        this.subscribers = new ArrayList<>();
    }

    // 添加订阅者
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    // 删除订阅者
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    // 发布消息
    public void publishMessage(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        // 创建发布者和订阅者
        Publisher publisher = new Publisher();
        Subscriber subscriber1 = new ConcreteSubscriber("Subscriber 1");
        Subscriber subscriber2 = new ConcreteSubscriber("Subscriber 2");
        Subscriber subscriber3 = new ConcreteSubscriber("Subscriber 3");

        // 添加订阅者
        publisher.addSubscriber(subscriber1);
        publisher.addSubscriber(subscriber2);
        publisher.addSubscriber(subscriber3);

        // 发布消息
        publisher.publishMessage("Hello, subscribers!");

        // 移除订阅者
        publisher.removeSubscriber(subscriber2);

        // 再次发布消息
        publisher.publishMessage("Goodbye, subscribers!");
    }
}
