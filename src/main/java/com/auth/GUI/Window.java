package com.auth.GUI;

import com.auth.DataSet;
import com.auth.database.ConnectionProvider;
import com.auth.database.Database;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.BLUE;


public class Window {
    private static final Color bgColor = new Color(238,238,238);
    public static JFrame frame = new JFrame("Login window");

    public static void openWindow(){
        frame.setLayout(new GridLayout(3,0));
        frame.setBounds(200,200,320,450);
        Window.loadFeatures();
    }

    private static void loadFeatures() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Username", TitledBorder.LEFT, TitledBorder.TOP));
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        textField.setBackground(bgColor);

        JPasswordField passwordField = new JPasswordField();
        Border customBorder = BorderFactory.createEtchedBorder();

        passwordField.setBorder(BorderFactory.createTitledBorder(customBorder, "Password", TitledBorder.LEFT, TitledBorder.TOP));
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        passwordField.setBackground(bgColor);

        JButton btn = new JButton();
        btn.setText("Login");
        btn.setFocusPainted(false);
        btn.setBorderPainted(true);

        frame.setBackground(bgColor);
        frame.setLocation(550,100);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,0));

        panel.add(textField,Component.CENTER_ALIGNMENT);
        panel.add(passwordField,Component.CENTER_ALIGNMENT);
        panel.add(btn,Component.CENTER_ALIGNMENT);

        panel.setBackground(bgColor);

        JLabel topLabel = new JLabel();
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(4,0));

        JButton signUpButton = new JButton("Create a new account");
        signUpButton.setBorder(new EmptyBorder(0,0,0,0));
        signUpButton.setBackground(bgColor);
        signUpButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        signUpButton.setForeground(BLUE);
        signUpButton.setFocusPainted(false);
        signUpButton.setBorderPainted(false);
        signUpButton.setContentAreaFilled(false);

        bottomPanel.add(signUpButton);

        topLabel.setBackground(bgColor);
        String url="E:\\icons\\Login label.jpg";
        topLabel.setIcon(new ImageIcon(url));
        bottomPanel.setBackground(bgColor);

        frame.add(topLabel,0);
        frame.add(panel,1);
        frame.add(bottomPanel,2);

        frame.setVisible(true);
        frame.setEnabled(true);

        btn.addActionListener((actionEvent)->{
            String userName = textField.getText();
            if(userName == null || userName.length() == 0)          return ;

            if(passwordField.getPassword() == null)                 return ;
            String password = new String(passwordField.getPassword());

            if(password.length() == 0)                              return ;

            try {
                Connection con = ConnectionProvider.getConnection();

                if(!Database.isUserPresent(con,userName)){
                    showLog("username",'e');
                    System.out.println("Error");
                    return ;
                }
                if(!Database.isPasswordCorrect(con,userName,password)){
                    showLog("password",'e');
                    System.out.println("Error");
                    return ;
                }

                DataSet dataSet = Database.login(userName);                 //Use case: Will/Can be used for storage of data
                showLog("username",'s');


            } catch (SQLException e) {
                System.out.println("SQL Exception");
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return ;
    }

    private static void showLog(String queryParam,char messageType) {
        JOptionPane.showMessageDialog(new JFrame(),(messageType == 's') ? "Successfully Logged in" : "Username or password is incorrect");
    }

}
