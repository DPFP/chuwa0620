package t06_java8.feature.default_interface_method;

public class Client {
    public static void main(String[] args) {
        DLMLimpl dim = new DLMLimpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        System.out.println("static method: " + DIML.blogName());
    }
}
