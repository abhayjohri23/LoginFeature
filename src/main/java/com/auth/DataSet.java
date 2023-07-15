package com.auth;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
public class DataSet {

    private String firstName;
    private String lastName;
    private String userName;
    private Date dateOfJoining;
    private Date dateOfBirth;
    private List<URL> socialHandles = new ArrayList<>();
    private String shortDescription;
    private Image image;

    public DataSet(String firstName,String lastName,String userName,Date doj,Date dob,List<URL> handles,String desc){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.socialHandles = handles;
        this.dateOfBirth = dob;
        this.dateOfJoining = doj;
    }

}
