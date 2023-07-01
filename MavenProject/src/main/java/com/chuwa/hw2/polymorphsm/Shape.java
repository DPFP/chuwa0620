package com.chuwa.hw2.polymorphsm;

public class Shape {
    public double getArea() {
        return 1.0;
    }
}
class Rectangle extends  Shape{
        double width;
        double height;

        @Override
        public double getArea() {
            return width * height;
        }
    }

    class Round extends Shape {
        double radius;
        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

    }

