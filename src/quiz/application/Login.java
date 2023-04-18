package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.NotBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame implements ActionListener{
    
    String username;
    JButton start, back;
    JTextField tfname;
    
    Login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
        add(image);
        
        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel username = new JLabel("Enter your name");
        username.setBounds(810, 150, 300, 20);
        username.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        username.setForeground(new Color(30, 144, 254));
        add(username);
        
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        
        start = new JButton("Start");
        start.setBounds(730, 270, 120, 25);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == start) {
        username = tfname.getText();
        setVisible(false);
        new TopicSelection(username);
    } else {
        setVisible(false);
        new Login();
    }
}



    
    public static void main(String[] args) {
        new Login();
    }
}
