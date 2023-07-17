
import com.mongodb.MongoClient;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MongoDBTest {

    public static void main(String[] args) {
        createCollection();
        insert();
        findOne();
        findAll();
        update();
        remove();
    }

    public static void createCollection() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // Access or create the database
        MongoDatabase database = mongoClient.getDatabase("test");

        // Create the collection
        MongoCollection<Document> collection = database.getCollection("oms_company_address");

        // Create a document with field values
        Document document = new Document();
        document.append("id", 123)
                .append("address_name", "Sample Address")
                .append("send_status", 1)
                .append("receive_status", 1)
                .append("name", "John Doe")
                .append("phone", "1234567890")
                .append("province", "Sample Province")
                .append("city", "Sample City")
                .append("region", "Sample Region")
                .append("detail_address", "Sample Detail Address");

        // Insert the document into the collection
        collection.insertOne(document);

        // Close the MongoDB client
        mongoClient.close();
    }

    public static void insert() {
        // Connect to MongoDB server
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // Access or create the database
        MongoDatabase database = mongoClient.getDatabase("test");

        // Access or create the collection
        MongoCollection<Document> collection = database.getCollection("oms_company_address");

        // Generate random entries and insert them into the collection
        int numEntries = 5; // Number of random entries to generate
        List<Document> entries = generateRandomEntries(numEntries);
        collection.insertMany(entries);

        // Close the MongoDB client
        mongoClient.close();

    }

    private static List<Document> generateRandomEntries(int numEntries) {
        List<Document> entries = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < numEntries; i++) {
            Document entry = new Document();
            entry.append("id", random.nextLong())
                    .append("address_name", generateRandomString(10))
                    .append("send_status", random.nextInt(2))
                    .append("receive_status", random.nextInt(2))
                    .append("name", generateRandomString(5))
                    .append("phone", generateRandomString(10))
                    .append("province", generateRandomString(8))
                    .append("city", generateRandomString(7))
                    .append("region", generateRandomString(6))
                    .append("detail_address", generateRandomString(15));

            entries.add(entry);
        }
        return entries;
    }

    private static String generateRandomString(int length) {
        final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    private static void findOne() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // Access or create the database
        MongoDatabase database = mongoClient.getDatabase("test");

        // Access the collection
        MongoCollection<Document> collection = database.getCollection("oms_company_address");

        // Find one entry from the collection
        FindIterable<Document> result = collection.find().limit(1);

        // Retrieve the first document from the result
        Document entry = result.first();

        // Print the document
        if (entry != null) {
            System.out.println(entry.toJson());
        } else {
            System.out.println("No entry found in the collection.");
        }

        // Close the MongoDB client
        mongoClient.close();
    }

    private static void findAll() {
        // Connect to MongoDB server
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // Access or create the database
        MongoDatabase database = mongoClient.getDatabase("test");

        // Access the collection
        MongoCollection<Document> collection = database.getCollection("oms_company_address");

        // Find all entries from the collection
        FindIterable<Document> result = collection.find();

        // Retrieve all documents from the result
        MongoCursor<Document> cursor = result.iterator();

        // Iterate over the documents and print them
        while (cursor.hasNext()) {
            Document entry = cursor.next();
            System.out.println(entry.toJson());
        }

        // Close the MongoDB client
        mongoClient.close();
    }

    public static void update() {
        // Connect to MongoDB server
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // Access or create the database
        MongoDatabase database = mongoClient.getDatabase("test");

        // Access the collection
        MongoCollection<Document> collection = database.getCollection("oms_company_address");

        // Define the filter for the entry to update (e.g., based on id)
        Document filter = new Document("id", 123); // Replace "id" with the appropriate field name and value

        // Define the update operation
        Document update = new Document("$set", new Document("name", "New Name")); // Replace "name" with the field to update and the new value

        // Update the entry
        collection.updateOne(filter, update);

        // Close the MongoDB client
        mongoClient.close();
    }

    public static void remove() {
        // Connect to MongoDB server
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // Access or create the database
        MongoDatabase database = mongoClient.getDatabase("test");

        // Access the collection
        MongoCollection<Document> collection = database.getCollection("oms_company_address");

        // Define the filter for the entry to remove (e.g., based on id)
        Document filter = new Document("id", 123); // Replace "id" with the appropriate field name and value

        // Remove the entry
        collection.deleteOne(filter);

        // Close the MongoDB client
        mongoClient.close();
    }
}
