package Coding.multithreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.CompletableFuture;

public class FutureAPI {
    private static final Logger logger = Logger.getLogger(FutureAPI.class.getName());
    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> fetchProducts());
        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> fetchReviews());
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> fetchInventory());

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        combinedFuture.thenRun(() -> {
            try {
                String productsData = productsFuture.get();
                String reviewsData = reviewsFuture.get();
                String inventoryData = inventoryFuture.get();

                // Merge the fetched data for further processing
                String mergedData = mergeData(productsData, reviewsData, inventoryData);
                System.out.println("Merged Data: " + mergedData);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Do other tasks in the main thread

        // Ensure the program keeps running until the async tasks complete
        combinedFuture.join();
    }

    // Simulated API fetch methods
    public static String fetchProducts() {
        String res = "";
        try {
            String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                res = response.toString();
                
            } else {
                logger.log(Level.INFO,"HTTP request failed with response code: " + responseCode);
            }
            connection.disconnect();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred during API call", e);
            // Return a default value or handle the error condition

        }
    
        return res;
    }

    public static String fetchReviews() {
        // Simulate fetching reviews from an API
        // same as above, simplified
        return "Reviews Data";
    }

    public static String fetchInventory() {
        // Simulate fetching inventory from an API
        return "Inventory Data";
    }

    // Simulated method to merge the fetched data
    public static String mergeData(String productsData, String reviewsData, String inventoryData) {
        // Merge the fetched data into a single string
        return productsData + ", " + reviewsData + ", " + inventoryData;
    }
}
