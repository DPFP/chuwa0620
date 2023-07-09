package Coding.multithreading;

import java.util.concurrent.CompletableFuture;

public class Future {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> num1 + num2);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> num1 * num2);

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(sumFuture, productFuture);

        combinedFuture.thenRun(() -> {
            try {
                int sumResult = sumFuture.get();
                int productResult = productFuture.get();

                System.out.println("Sum: " + sumResult);
                System.out.println("Product: " + productResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Do other tasks in the main thread

        // Ensure the program keeps running until the async tasks complete
        combinedFuture.join();
    }
}
