package com.chuwa.learn.builder;

public class Phone {

    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    private Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainboard = builder.mainboard;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainboard + '\'' +
                '}';
    }

    private static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainboard;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }
        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }
        public Builder mainboard(String mainboard) {
            this.mainboard = mainboard;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }

    public static void main(String[] args) {
        //通过构建者对象获取手机对象
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("samsung")
                .memory("kingston")
                .mainboard("华硕主板")
                .build();

        System.out.println(phone);
    }
}
