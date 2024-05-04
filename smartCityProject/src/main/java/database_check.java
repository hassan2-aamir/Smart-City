import java.sql.*;


public class database_check {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/smartcity";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Hassan200";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the database!");
                String query = "SELECT campus_code FROM campuses"; // Change this to your actual table name
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(query)) {
                    // Process the ResultSet
                    while (resultSet.next()) {
                        String campus_code = resultSet.getString("campus_code"); // Assuming there's an 'id' column
                        System.out.println("campus_code: " + campus_code);
                        // Add more columns as needed
                    }
                } catch (SQLException e) {
                    System.err.println("Error executing query: " + e.getMessage());
                }
                // Call other methods to perform database operations
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
