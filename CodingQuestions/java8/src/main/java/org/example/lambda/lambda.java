package org.example.lambda;

import org.junit.Test;

public class lambda {
    @Test
    public void overrideFoo() {
        // 匿名类+override
        Foo fooByIC = new Foo() {
            @Override
            public String aMethod(String string) {
                return string + " from Foo";
            }
        };

        String hello = fooByIC.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo() {
        Foo fooByLambda = param -> param + " from Foo";
        String hello = fooByLambda.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo2() {
        Foo fooByLambda = param -> param.toUpperCase() + " from Foo";
        String hello = fooByLambda.aMethod("hello");
        System.out.println(hello);
    }
}
