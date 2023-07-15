package com.auth.GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class Window {
    private static final Color bgColor = new Color(238,238,238);
    public static JFrame frame = new JFrame("Login window");

    public static void openWindow(){
        frame.setLayout(new GridLayout(3,0));
        frame.setBounds(200,200,300,390);
        Window.loadFeatures();
    }

    private static void loadFeatures() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Username", TitledBorder.LEFT, TitledBorder.TOP));
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        textField.setBackground(bgColor);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Password", TitledBorder.LEFT, TitledBorder.TOP));
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        passwordField.setBackground(bgColor);

        JButton btn = new JButton();
        btn.setText("Login");

        frame.setBackground(bgColor);
        frame.setLocation(200,200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(textField);
        panel.add(passwordField);
        panel.add(btn);
        panel.setBackground(bgColor);

        JLabel topLabel = new JLabel();
        JLabel bottomLabel = new JLabel();

        topLabel.setBackground(bgColor);
        String url="E:\\icons\\Login label.jpg";
        topLabel.setIcon(new ImageIcon(url));
        bottomLabel.setBackground(bgColor);

        frame.add(topLabel,0);
        frame.add(panel,1);
        frame.add(bottomLabel,2);

        frame.setVisible(true);
        frame.setEnabled(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return ;
    }

}
