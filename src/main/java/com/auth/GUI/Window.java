package com.auth.GUI;

import com.auth.DataSet;
import com.auth.database.ConnectionProvider;
import com.auth.database.Database;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

import java.sql.Connection;
import java.sql.SQLException;

import static java.awt.Color.BLUE;
import static java.awt.Color.WHITE;

public class Window {
    @Getter
    private static Color bgColor = new Color(238,238,238);
    public static JFrame frame = new JFrame("Login window");
    private static final JTextField textField = new JTextField();
    private static final JPasswordField passwordField = new JPasswordField();

    public static void openWindow(){
        frame.setLayout(new GridLayout(3,0));
        frame.setBounds(200,200,320,450);
        Window.loadFeatures();
    }

    private static void loadFeatures() {
        textField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Username", TitledBorder.LEFT, TitledBorder.TOP));
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        textField.setBackground(bgColor);

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
        signUpButton.setFocusPainted(true);
        signUpButton.setBorderPainted(true);
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
                    clearFields();
                    return ;
                }
                if(!Database.isPasswordCorrect(con,userName,password)){
                    showLog("password",'e');
                    clearFields();
                    return ;
                }

                DataSet dataSet = Database.login(userName);                 //Use case: Will/Can be used for storage of data
                showLog("username",'s');

                //Clearing the fields after Success / Error.
                clearFields();

            } catch (SQLException e) {
                System.out.println("SQL Exception");
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        signUpButton.addActionListener(actionEvent -> {
            frame.setVisible(false);
            boolean signUpCompleted = Window.launchSignUpFrame();

            if(signUpCompleted)
                frame.setVisible(true);
        });
        return ;
    }

    private static void showLog(String queryParam,char messageType) {
        JOptionPane.showMessageDialog(new JFrame(),(messageType == 's') ? "Successfully Logged in" : "Username or password is incorrect");
    }

    private static void clearFields(){
        textField.setText("");
        passwordField.setText("");
    }

    private static boolean launchSignUpFrame(){
        JFrame signUpFrame = new JFrame("Register for DataPixie");
        signUpFrame.setBounds(200,200,450,550);
        signUpFrame.setLocation(550,100);

        signUpFrame.setLayout(new GridLayout(0,2));

        JPanel form = new JPanel(new GridLayout(11,0));

        JTextField[] fields = new JTextField[8];
        JPasswordField[] pswdFields = new JPasswordField[2];

        String[] textFieldNames = {"First Name*","Middle Name (Optional)","Last Name*","Username*","Date Of Birth*","About Me*","2nd Line","3rd Line"};
        String[] pswdFieldNames = {"Password**","Retype the Password**"};

        for(int i=0;i<textFieldNames.length;++i){
            fields[i] = new JTextField();
            fields[i].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), textFieldNames[i], TitledBorder.LEFT, TitledBorder.TOP));
            fields[i].setFont(new Font("Times New Roman", Font.PLAIN, 16));
            form.add(fields[i]);
        }
        for(int i=0;i<pswdFieldNames.length;++i){
            pswdFields[i] = new JPasswordField();
            pswdFields[i].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), pswdFieldNames[i], TitledBorder.LEFT, TitledBorder.TOP));
            pswdFields[i].setFont(new Font("Times New Roman", Font.PLAIN, 16));
            form.add(pswdFields[i]);
        }

        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setFocusPainted(false);
        signUpBtn.setBorderPainted(true);
        signUpBtn.setVisible(true);
        signUpBtn.setEnabled(true);

        form.add(signUpBtn);
        JPanel sidePane = new JPanel(new GridLayout(2,0));
        sidePane.setBackground(WHITE);

        JLabel picLabel = new JLabel();
        JLabel infoLabel = new JLabel();

        signUpBtn.addActionListener(actionEvent -> {
            picLabel.setIcon(new ImageIcon("E:\\icons\\Bob.png"));
            String info = "<html>Hi, I am "+ fields[0].getText() + ".<br> "+fields[5].getText()+".<br> "+fields[6].getText()+".<br> "+fields[7].getText()+".</html>";
            infoLabel.setText(info);
            infoLabel.setFont(new Font("Comic Sans MS",Font.BOLD,12));
            infoLabel.setForeground(BLUE);

            sidePane.add(picLabel);
            sidePane.add(infoLabel);
        });

        signUpFrame.add(form, 0);
        signUpFrame.add(sidePane,1);

        signUpFrame.setVisible(true);
        signUpFrame.setEnabled(true);
        signUpFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        return true;
    }

}
