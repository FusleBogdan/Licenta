package quiz.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseHelper {
    private static final String SQLITE_CONNECTION_STRING = "jdbc:sqlite:leaderboard.db";

    
    public static void createTable() {
    try {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS scores(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL," +
                "score INTEGER NOT NULL" +
                ")";
        statement.executeUpdate(query);
        statement.close(); // Close the statement
        connection.close(); // Close the connection
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(SQLITE_CONNECTION_STRING);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<ScoreEntry> getLeaderboard() {
    ArrayList<ScoreEntry> leaderboard = new ArrayList<>();
    try {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ArrayList<ScoreEntry> leaderboardData = DatabaseHelper.getLeaderboard();

        // Populate the 'data' array with the leaderboard data
        ArrayList<Object[]> rowData = new ArrayList<>();
        for (ScoreEntry entry : leaderboardData) {
            rowData.add(new Object[]{entry.getName(), entry.getScore()});
    }


        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return leaderboard;
}


    public static void addScore(String username, int score) {
    try {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String query = "INSERT INTO scores(username, score) VALUES('" + username + "'," + score + ")";
        statement.executeUpdate(query);
        statement.close(); // Close the statement
        connection.close(); // Close the connection
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
