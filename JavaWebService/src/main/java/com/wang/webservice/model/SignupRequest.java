package com.wang.webservice.model;

public class SignupRequest {
    private static final long serialVersionUID = 5926468583005150707L;

    private String userName;
    private String userEmail;
    private String password;

    //need default constructor for JSON Parsing
    public SignupRequest()
    {

    }

    public SignupRequest(String userName, String userEmail, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
