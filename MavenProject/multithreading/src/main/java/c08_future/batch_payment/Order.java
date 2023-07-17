package c08_future.batch_payment;

public class Order {
    String id;
    double amount;

    Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }
}