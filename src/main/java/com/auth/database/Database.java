package com.auth.database;

import com.auth.DataSet;

import java.sql.*;

public class Database {
    public static boolean createUser(Connection con){
        return false;
    }
    public static boolean isUserPresent(Connection con,String userName) {
        try{
            Statement ping = con.createStatement();
            ping.execute("USE USERBASE");
        }catch(Exception e){
            System.out.println("Database issues");
        }

        try{
            String userQuery = "SELECT * FROM USERS WHERE USERNAME=?";
            PreparedStatement stmt = con.prepareStatement(userQuery);
            stmt.setString(1, userName);
            stmt.execute();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean isPasswordCorrect(Connection con,String userName,String password){
        try{
            Statement ping = con.createStatement();
            ping.execute("USE USERBASE");
        }catch(Exception e){
            System.out.println("Database issues");
        }

        try{
            String userQuery = "SELECT * FROM USERS WHERE USERNAME=?";
            PreparedStatement stmt = con.prepareStatement(userQuery);
            stmt.setString(1, userName);
            ResultSet set = stmt.executeQuery();

            if(!set.next())
                return false;
            return set.getString("pswd").equals(password);

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static DataSet login(String userName){
        return null;
    }
    public static boolean signUp(String userName,String password,Connection con){
        return true;
    }
    public static boolean updateCredentials(String userName,String password){
        return false;
    }
    public static boolean deleteAccount(){
        return false;
    }
}
