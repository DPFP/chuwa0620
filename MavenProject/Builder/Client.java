package Builder;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("JBC")
                .memory("kingston")
                .mainBoard("asus")
                .battery("A121")
                .build();

        System.out.println(phone);
    }
}
