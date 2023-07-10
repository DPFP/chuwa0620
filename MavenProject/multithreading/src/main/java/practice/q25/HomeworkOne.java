package practice.q25;

import java.util.concurrent.CompletableFuture;

public class HomeworkOne {
    public static void main(String[] args) {
        int a = 10, b = 20;
        CompletableFuture<Integer> futureSum = CompletableFuture.supplyAsync(()->a+b);
        CompletableFuture<Integer> futureProduct = CompletableFuture.supplyAsync(()->a*b);
        CompletableFuture<Void> futureResult = futureSum.thenAcceptBoth(futureProduct, (sum, product) -> {
            System.out.println("The sum is "+sum);
            System.out.println("The product is "+product);
        });
        futureResult.join();
    }
}
