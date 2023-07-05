package org.example.default_interface_method;

import org.junit.Test;

public class DimImpl implements DIML {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Test
    public void test(){
        DimImpl dim = new DimImpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        System.out.println("static method: " + DIML.blogName());
    }
}


