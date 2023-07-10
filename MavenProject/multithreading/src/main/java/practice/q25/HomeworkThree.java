package practice.q25;

import com.beust.ah.A;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeworkThree {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Logger logger = Logger.getLogger(HomeworkThree.class.getName());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> productFuture = getProductInformation();
        CompletableFuture<String> reviewFuture = getReviews();
        CompletableFuture<String> inventoryFuture = getInventory();
        // CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productFuture, reviewFuture, inventoryFuture);
        try{
            String combined = Stream.of(productFuture, reviewFuture, inventoryFuture)
                    .map(CompletableFuture::join)
                    .collect(Collectors.joining(" --- "));
            System.out.println(combined);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static final void getAllResult(List<String> list){
        for(String s:list){
            System.out.println(s);
        }
    }

    public static CompletableFuture<String> getProductInformation(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body).exceptionally(ex-> {
                    logger.severe("Failed to get product information: " + ex.getMessage());
                    return "Default product information";
                });
    }

    public static CompletableFuture<String> getReviews() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .header("Authorization", "Bearer YOUR_API_KEY")
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body).exceptionally(ex-> {
                    logger.severe("Failed to get review information: " + ex.getMessage());
                    return "Default review information";
                });
    }

    public static CompletableFuture<String> getInventory() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body).exceptionally(ex-> {
                    logger.severe("Failed to get inventory information: " + ex.getMessage());
                    return "Default inventory information";
                });
    }
}
