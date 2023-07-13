package com.auth;

public class DataSet {
    private long userID;
    private String userName;

    //Getters and Setters
    public void setUserID(long userID){
        this.userID = userID;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public long getUserID(){
        return userID;
    }
    public String userName(){
        return this.userName;
    }
}
