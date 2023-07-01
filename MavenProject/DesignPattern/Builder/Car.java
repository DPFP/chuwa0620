package DesignPattern.Builder;

public class Car {
    int price;
    int year;
    String model;
    int mpg;

    public Car(int price, int year, String model, int mpg) {
        this.price = price;
        this.year = year;
        this.model = model;
        this.mpg = mpg;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", year=" + year +
                ", model='" + model + '\'' +
                ", mpg=" + mpg +
                '}';
    }

    public static CarBuilder builder(){return new CarBuilder();}

    public static class CarBuilder{
        private int price;
        private int year;
        private String model;
        private int mpg;

        public CarBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setMpg(int mpg) {
            this.mpg = mpg;
            return this;
        }

        public Car build(){return new Car(price,year,model,mpg);}
    }
}

class test{
    public static void main(String[] args) {
        Car crv = Car.builder()
                .setMpg(123)
                .setModel("crv")
                .build();
        System.out.println(crv);
    }
}


