package com.wang.webservice.mongodb.model;
import com.wang.webservice.mongodb.model.AccountInfo.*;
import com.wang.webservice.mongodb.model.UserInfo.*;
import com.wang.webservice.mongodb.model.Course.*;
import com.wang.webservice.mongodb.model.Event.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "SchedulerCollection")
public class User {
    @Id
    private ObjectId uniqueID;
    private AccountInfo accountInfo;
    private UserInfo userInfo;
    private ArrayList<Course> academicInfo;
    private ArrayList<Event> calendar;
    private String file;
    public User() {
        this.uniqueID = new ObjectId();
        this.accountInfo = new AccountInfo();
        this.userInfo = new UserInfo();
        this.academicInfo = new ArrayList<Course>();
        this.calendar = new ArrayList<Event>();
        this.file = "";
    }

    public User(AccountInfo accountInfo, UserInfo userInfo, ArrayList<Course> academicInfo, ArrayList<Event> calendar, String file) {
        this.uniqueID = new ObjectId();
        this.accountInfo = accountInfo;
        this.userInfo = userInfo;
        this.academicInfo = academicInfo;
        this.calendar = calendar;
        this.file = file;
    }
    public void updateUser(User user){
        this.setAccountInfo(user.getAccountInfo());
        this.setUserInfo(user.getUserInfo());
        this.setAcademicInfo(user.getAcademicInfo());
        this.setCalendar(user.getCalendar());
        this.setFile(user.getFile());
    }
//    public void addEventToCalendar(Event event){
//        this.calendar.add(event);
//    }

    public ObjectId getUniqueID() {
        return uniqueID;
    }

//    public void setUniqueID(String uniqueID) {
//        this.uniqueID = new ObjectId(uniqueID);
//    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public ArrayList<Course> getAcademicInfo() {
        return academicInfo;
    }

    public void setAcademicInfo(ArrayList<Course> academicInfo) {
        this.academicInfo = academicInfo;
    }

    public ArrayList<Event> getCalendar() {
        return calendar;
    }

    public void setCalendar(ArrayList<Event> calendar) {
        this.calendar = calendar;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
