package org.example.default_interface_method;

public interface DIML {
    static final String BLOG = "is Chuwa a";
    int add(int a, int b);

    // default method
    default int substract(int a, int b) {
        return a - b;
    }

    // static method
    static String blogName() {
        return BLOG;
    }
}

