package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TopicSelection extends JFrame implements ActionListener {

    JButton mathButton, scienceButton, historyButton, backButton;
    String username;

    public TopicSelection(String username) {
        this.username = username;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        mathButton = new JButton("Mathematics");
        mathButton.setBounds(100, 100, 200, 50);
        mathButton.addActionListener(this);
        add(mathButton);

        scienceButton = new JButton("Science");
        scienceButton.setBounds(100, 200, 200, 50);
        scienceButton.addActionListener(this);
        add(scienceButton);

        historyButton = new JButton("History");
        historyButton.setBounds(100, 300, 200, 50);
        historyButton.addActionListener(this);
        add(historyButton);

        backButton = new JButton("Back");
        backButton.setBounds(100, 400, 200, 50);
        backButton.addActionListener(this);
        add(backButton);

        setSize(400, 600);
        setLocation(200, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            setVisible(false);
            new Login();
        } else {
            String topic = "";
            if (e.getSource() == mathButton) {
                topic = "math";
            } else if (e.getSource() == scienceButton) {
                topic = "science";
            } else if (e.getSource() == historyButton) {
                topic = "history";
            }

            setVisible(false);
            try {
                new Quiz(username, topic);
            } catch (java.rmi.NotBoundException ex) {
                Logger.getLogger(TopicSelection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
