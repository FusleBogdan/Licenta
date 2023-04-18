package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static quiz.application.Quiz.score;

public class Score extends JFrame implements ActionListener {
    
    JButton submit, leaderboardButton, playAgainButton, viewLeaderboardButton;
    private String username;
    Score(String username, int score) {
        this.username = username;
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);

        JLabel heading = new JLabel("Thank you " + username + " for playing Simple Minds");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);

        submit = new JButton("Play Again");
        submit.setBounds(380, 270, 120, 30);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
         playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(380, 270, 120, 30);
        playAgainButton.setBackground(new Color(30, 144, 255));
        playAgainButton.setForeground(Color.WHITE);
        playAgainButton.addActionListener(this);
        add(playAgainButton);

        viewLeaderboardButton = new JButton("Leaderboard");
        viewLeaderboardButton.setBounds(380, 310, 150, 30);
        viewLeaderboardButton.setBackground(new Color(30, 144, 255));
        viewLeaderboardButton.setForeground(Color.WHITE);
        viewLeaderboardButton.addActionListener(this);
        add(viewLeaderboardButton);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == playAgainButton) {
        System.out.println("Play Again button clicked");
        setVisible(false);
        new Login();
    } else if (ae.getSource() == viewLeaderboardButton) {
        System.out.println("View Leaderboard button clicked");
        setVisible(false);
        new Leaderboard();
    }
}




    public static void main(String[] args) {
        new Score("User", 0);
    }
}
