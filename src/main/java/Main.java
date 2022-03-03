import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/coaster_database";
        String user = "root";
        String pass = "root";
        String query = "SELECT * FROM coasters";
        try (Connection conn = DriverManager.getConnection(URL, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("Name: " + rs.getString("name"));
                System.out.print(", Park: " + rs.getString("park"));
                System.out.print(", Max Height: " + rs.getString("height"));
                System.out.print(", Max Speed: " + rs.getString("maxSpeed"));
                System.out.print(", Length: " + rs.getInt("length"));
                System.out.print(", Duration: " + rs.getTime("duration"));
                System.out.print(", Inversions: " + rs.getInt("inversions"));
                System.out.print(", Material: " + rs.getString("material"));
                System.out.print(", Opened: " + rs.getInt("opened"));
                System.out.println(", Manufacturer: " + rs.getString("manufacturer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

