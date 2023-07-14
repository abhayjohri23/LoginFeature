package com.auth.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static javax.swing.SwingConstants.*;

public class Window {
    public static JFrame frame = new JFrame("Login window");

    public static void openWindow(){
        frame.setLayout(new GridLayout(3,0));
        frame.setBounds(200,200,400,400);
        Window.loadFeatures();
    }

    private static void loadFeatures() {
        JTextField textfield = new JTextField();
        textfield.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Email/Username", TitledBorder.LEFT, TitledBorder.TOP));
        textfield.setPreferredSize(new Dimension(100,40));


        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Password", TitledBorder.LEFT, TitledBorder.TOP));
        passwordField.setPreferredSize(new Dimension(100,40));

        JButton btn = new JButton();
        btn.setText("Login");

        frame.setBackground(Color.WHITE);
        frame.setLocation(200,200);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
        panel.add(textfield);
        panel.add(passwordField);
        panel.add(btn);
        panel.setBackground(Color.PINK);

        frame.add(new JPanel(),0);
        frame.add(panel,1);


        frame.setVisible(true);
        frame.setEnabled(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return ;
    }

}
