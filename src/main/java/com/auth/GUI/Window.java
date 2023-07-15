package com.auth.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

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
        frame.setLocation(200,200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,0));

        panel.add(textField,Component.CENTER_ALIGNMENT);
        panel.add(passwordField,Component.CENTER_ALIGNMENT);
        panel.add(btn,Component.CENTER_ALIGNMENT);

        panel.setBackground(bgColor);

        JLabel topLabel = new JLabel();
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(4,0));

        JButton signUpButton = new JButton("Create an account");
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return ;
    }

}
