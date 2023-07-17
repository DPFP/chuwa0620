import java.sql.*;

public class DBTest {

    static String jdbcURL = "jdbc:mysql://localhost:3306/test";
    static String username = "root";
    static String password = "ljb112233";

    public static void main(String[] args) {
//        createCollection();
//        insert();
//        findOne();
//        update();
//        findAll();
//        remove();
        findAll();
    }

    public static void createCollection() {
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "CREATE TABLE oms_company_address (" +
                    "id BIGINT PRIMARY KEY," +
                    "address_name VARCHAR(200)," +
                    "send_status INT(1)," +
                    "receive_status INT(1)," +
                    "name VARCHAR(64)," +
                    "phone VARCHAR(64)," +
                    "province VARCHAR(64)," +
                    "city VARCHAR(64)," +
                    "region VARCHAR(64)," +
                    "detail_address VARCHAR(200)" +
                    ")";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Table oms_company_address created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert() {
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            // Sample data
            long id1 = 1;
            String addressName1 = "Address 1";
            int sendStatus1 = 1;
            int receiveStatus1 = 0;
            String name1 = "John Doe";
            String phone1 = "1234567890";
            String province1 = "California";
            String city1 = "Los Angeles";
            String region1 = "Central";
            String detailAddress1 = "123 Main St";

            long id2 = 2;
            String addressName2 = "Address 2";
            int sendStatus2 = 0;
            int receiveStatus2 = 1;
            String name2 = "Jane Smith";
            String phone2 = "9876543210";
            String province2 = "New York";
            String city2 = "New York City";
            String region2 = "Manhattan";
            String detailAddress2 = "456 Broadway";

            // Set values for the first entry
            statement.setLong(1, id1);
            statement.setString(2, addressName1);
            statement.setInt(3, sendStatus1);
            statement.setInt(4, receiveStatus1);
            statement.setString(5, name1);
            statement.setString(6, phone1);
            statement.setString(7, province1);
            statement.setString(8, city1);
            statement.setString(9, region1);
            statement.setString(10, detailAddress1);
            statement.executeUpdate();

            // Set values for the second entry
            statement.setLong(1, id2);
            statement.setString(2, addressName2);
            statement.setInt(3, sendStatus2);
            statement.setInt(4, receiveStatus2);
            statement.setString(5, name2);
            statement.setString(6, phone2);
            statement.setString(7, province2);
            statement.setString(8, city2);
            statement.setString(9, region2);
            statement.setString(10, detailAddress2);
            statement.executeUpdate();

            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findOne() {
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM oms_company_address WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, 1); // Specify the ID of the entry you want to retrieve

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String addressName = resultSet.getString("address_name");
                int sendStatus = resultSet.getInt("send_status");
                int receiveStatus = resultSet.getInt("receive_status");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String province = resultSet.getString("province");
                String city = resultSet.getString("city");
                String region = resultSet.getString("region");
                String detailAddress = resultSet.getString("detail_address");

                System.out.println("ID: " + id);
                System.out.println("Address Name: " + addressName);
                System.out.println("Send Status: " + sendStatus);
                System.out.println("Receive Status: " + receiveStatus);
                System.out.println("Name: " + name);
                System.out.println("Phone: " + phone);
                System.out.println("Province: " + province);
                System.out.println("City: " + city);
                System.out.println("Region: " + region);
                System.out.println("Detail Address: " + detailAddress);
            } else {
                System.out.println("No entry found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findAll() {
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM oms_company_address";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String addressName = resultSet.getString("address_name");
                int sendStatus = resultSet.getInt("send_status");
                int receiveStatus = resultSet.getInt("receive_status");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String province = resultSet.getString("province");
                String city = resultSet.getString("city");
                String region = resultSet.getString("region");
                String detailAddress = resultSet.getString("detail_address");

                System.out.println("ID: " + id);
                System.out.println("Address Name: " + addressName);
                System.out.println("Send Status: " + sendStatus);
                System.out.println("Receive Status: " + receiveStatus);
                System.out.println("Name: " + name);
                System.out.println("Phone: " + phone);
                System.out.println("Province: " + province);
                System.out.println("City: " + city);
                System.out.println("Region: " + region);
                System.out.println("Detail Address: " + detailAddress);
                System.out.println("----------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "UPDATE oms_company_address " +
                    "SET address_name = ?, send_status = ?, receive_status = ?, name = ?, phone = ?, province = ?, city = ?, region = ?, detail_address = ? " +
                    "WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // New values for the entry
            String newAddressName = "New Address";
            int newSendStatus = 1;
            int newReceiveStatus = 1;
            String newName = "John Smith";
            String newPhone = "555-1234";
            String newProvince = "California";
            String newCity = "San Francisco";
            String newRegion = "Central";
            String newDetailAddress = "456 Oak St";
            long entryId = 1; // Specify the ID of the entry you want to update

            // Set the new values in the prepared statement
            statement.setString(1, newAddressName);
            statement.setInt(2, newSendStatus);
            statement.setInt(3, newReceiveStatus);
            statement.setString(4, newName);
            statement.setString(5, newPhone);
            statement.setString(6, newProvince);
            statement.setString(7, newCity);
            statement.setString(8, newRegion);
            statement.setString(9, newDetailAddress);
            statement.setLong(10, entryId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Entry updated successfully.");
            } else {
                System.out.println("No entry found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void remove() {
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "DELETE FROM oms_company_address WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            long entryId = 1; // Specify the ID of the entry you want to remove
            statement.setLong(1, entryId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Entry removed successfully.");
            } else {
                System.out.println("No entry found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
