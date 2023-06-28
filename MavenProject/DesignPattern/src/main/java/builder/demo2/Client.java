package builder.demo2;

public class Client {
    public static void main(String[] args) {
        // create phone object
        Phone phone = new Phone.Builder().
                cpu("intel").
                screen("samsumg").
                memory("kingston").
                mainboard("huashuo").
                build();
        System.out.println(phone);
    }
}
