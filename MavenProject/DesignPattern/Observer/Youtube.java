package DesignPattern.Observer;

public class Youtube {
    public static void main(String[] args) {
        Channel yg = new Channel("YG's Channel");
        User jack = new User("Jack");
        User bob = new User("Bob");
        User alice = new User("Alice");
        jack.subscribe(yg);
        bob.subscribe(yg);
        alice.subscribe(yg);
        yg.notify("Pulp Fiction");
    }
}
