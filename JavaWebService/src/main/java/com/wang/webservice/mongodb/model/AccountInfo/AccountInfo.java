package com.wang.webservice.mongodb.model.AccountInfo;

public class AccountInfo {
    private String userName;
    private String userEmail;
    private int accessLevel;
    private String password;
    public AccountInfo(){
        this.userName = "";
        this.userEmail = "";
        this.accessLevel = -1; // null user access level (-1) shouldd be smthg between 1 - 100 (100 highest privileges
        this.password = "";
    }

    public AccountInfo(String userName, String userEmail, int accessLevel, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.accessLevel = accessLevel;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
