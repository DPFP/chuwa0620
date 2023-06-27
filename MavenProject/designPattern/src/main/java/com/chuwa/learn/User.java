package com.chuwa.learn;

// This is builder example.

public class User {
    private final String username;
    private final String password;
    private final String email;
    private final int age;

    private User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.age = builder.age;
    }

    // Getters for the user attributes

    public static class Builder {
        private final String username;
        private final String password;
        private String email;
        private int age;

        public Builder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
