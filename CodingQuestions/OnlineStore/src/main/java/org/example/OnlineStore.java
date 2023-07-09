package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class OnlineStore {

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchJsonData("https://jsonplaceholder.typicode.com/todos/1");
        CompletableFuture<String> reviewsFuture = fetchJsonData("https://jsonplaceholder.typicode.com/todos/2");
        CompletableFuture<String> inventoryFuture = fetchJsonData("https://jsonplaceholder.typicode.com/todos/3");

        try {
            CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture).join();
            String productsJson = productsFuture.get();
            String reviewsJson = reviewsFuture.get();
            String inventoryJson = inventoryFuture.get();

            String productsData = JsonHelper(productsJson, "userId");
            String reviewsData = JsonHelper(reviewsJson, "id");
            String inventoryData = JsonHelper(inventoryJson, "title");

            // Merge and process the fetched data
            String mergedData = mergeData(productsData, reviewsData, inventoryData);
            processMergedData(mergedData);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String mergeData(String productsData, String reviewsData, String inventoryData) {
        // Merge the fetched data
        return String.join(" ", productsData, reviewsData, inventoryData);
    }

    private static void processMergedData(String mergedData) {
        // Process the merged data
        System.out.println("Merged data: " + mergedData);
    }

    public static CompletableFuture<String> fetchJsonData(String url) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                // Prepare the HTTP request
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                // Send the HTTP request and get the response
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Return the JSON response
                return response.body();
            } catch (Exception e) {
                // Handle any exceptions
                e.printStackTrace();
                return "Default Value";
            }
        });

        return completableFuture;
    }

    public static String JsonHelper(String json, String key){
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        return jsonObject.get(key).getAsString();
    }
}
