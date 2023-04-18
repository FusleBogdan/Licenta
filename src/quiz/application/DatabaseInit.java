package quiz.application;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInit {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseHelper.getConnection();
            Statement statement = connection.createStatement();

            // Create the scores table if it doesn't exist
            String createTableSql = "CREATE TABLE IF NOT EXISTS scores (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, score INTEGER)";
            statement.executeUpdate(createTableSql);

            // Insert a sample row
            String insertSampleRowSql = "INSERT INTO scores (name, score) VALUES ('John Doe', 5)";
            statement.executeUpdate(insertSampleRowSql);

            connection.close();

            System.out.println("Database and table created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
