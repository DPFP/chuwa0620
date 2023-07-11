package hw24;

import java.util.concurrent.ThreadLocalRandom;

public class Coding2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            printNumbersInRange(1, 10);
        });

        Thread thread2 = new Thread(() -> {
            printNumbersInRange(11, 20);
        });

        Thread thread3 = new Thread(() -> {
            printNumbersInRange(21, 30);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void printNumbersInRange(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000)); // Random sleep for simulating random order
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

