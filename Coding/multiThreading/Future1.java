import java.util.concurrent.CompletableFuture;

public class Future1 {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 3;
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> num1 + num2);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> num1 * num2);

        CompletableFuture<Void> combinFuture = CompletableFuture.allOf(sumFuture, productFuture);

        combinFuture.thenRun(() -> {
            try {
                int sumRes = sumFuture.get();
                int productRes = productFuture.get();
                System.out.println(sumRes);
                System.out.println(productRes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
