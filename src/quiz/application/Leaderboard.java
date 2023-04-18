package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Leaderboard extends JFrame {
    // Add a constructor parameter for the username
    public Leaderboard(String username) {
        // ...
    }

    public Leaderboard() {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        String[] columnNames = {"Username", "Score"};
        Object[][] data;

        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:leaderboard.db");

            // Create the 'scores' table if it doesn't exist
            Statement createTableStmt = con.createStatement();
            Statement insertStmt = con.createStatement();

            createTableStmt.execute("CREATE TABLE IF NOT EXISTS scores (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT NOT NULL, score INTEGER NOT NULL)");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT username, score FROM scores ORDER BY score DESC");

            // Populate the 'data' array with the leaderboard data from the ResultSet
            ArrayList<Object[]> rowData = new ArrayList<>();
            while (rs.next()) {
                rowData.add(new Object[]{rs.getString("username"), rs.getInt("score")});
            }
            data = new Object[rowData.size()][];
            rowData.toArray(data);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            data = new Object[0][0];
        }

        // Create the JTable and add it to the JFrame
        JTable leaderboardTable = new JTable(data, columnNames);
        leaderboardTable.setBounds(30, 40, 700, 450);
        leaderboardTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        leaderboardTable.setRowHeight(30);
        leaderboardTable.setBackground(Color.WHITE);
        leaderboardTable.setEnabled(false);

        JScrollPane pane = new JScrollPane(leaderboardTable);
        pane.setBounds(30, 40, 700, 450);
        pane.getViewport().setBackground(Color.WHITE);
        add(pane);

        setVisible(true);
    }


       
    
    public static void main(String[] args) {
        new Leaderboard();
    }
}
