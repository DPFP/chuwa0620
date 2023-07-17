import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.net.URL;
import java.util.logging.Logger;

public class Future2 {
    private static final Logger logger = Logger.getLogger(Future2.class.getName());

    public static void main(String[] args) {
        CompletableFuture<String> productFuture = CompletableFuture.supplyAsync(() -> fetchProduct());
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> fetchInventory());
        CompletableFuture<String> reviewFuture = CompletableFuture.supplyAsync(() -> fetchReview());

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productFuture, inventoryFuture, reviewFuture);

        combinedFuture.thenRun(() -> {
            try {
                String productData = productFuture.get();
                String inventoryData = inventoryFuture.get();
                String reviewData = reviewFuture.get();
                String finalData = combineData(productData, reviewData, inventoryData);
                System.out.println(finalData);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static String fetchProduct() {
        String res = "";
        try {
            String api = "https://jsonplaceholder.typicode.com/posts/1";
            URL url = new URL(api);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                res = response.toString();

            } else {
                logger.log(Level.INFO, "Fetch fail with status code:" + responseCode);
            }
            conn.disconnect();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred during API call", e);
            // Return a default value or handle the error condition
        }

        return res;

    }

    public static String fetchReview() {
        String res = "";
        try {
            String api = "https://jsonplaceholder.typicode.com/posts/1";
            URL url = new URL(api);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                res = response.toString();

            } else {
                logger.log(Level.INFO, "Fetch fail with status code:" + responseCode);
            }
            conn.disconnect();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred during API call", e);
            // Return a default value or handle the error condition
        }

        return res;

    }

    public static String fetchInventory() {
        String res = "";
        try {
            String api = "https://jsonplaceholder.typicode.com/posts/1";
            URL url = new URL(api);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                res = response.toString();

            } else {
                logger.log(Level.INFO, "Fetch fail with status code:" + responseCode);
            }
            conn.disconnect();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred during API call", e);
            // Return a default value or handle the error condition
        }

        return res;

    }

    public static String combineData(String productData, String reviewData, String InventoryData) {
        return new String("This is the final data combined from product, review and inventory");
    }
}
