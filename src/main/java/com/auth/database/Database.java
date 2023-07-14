package com.auth.database;

import com.auth.DataSet;

import java.sql.Connection;

public class Database {
    public boolean createUser(Connection con){
        return false;
    }
    public boolean isUserPresent(Connection con){
        return false;
    }
    public boolean isPasswordCorrect(Connection con){
        return false;
    }
    public DataSet login(String userName){
        return null;
    }
    public boolean signUp(String userName,String password,Connection con){
        return true;
    }
    public boolean updateCredentials(String userName,String password){
        return false;
    }
    public boolean deleteAccount(){
        return false;
    }
}
