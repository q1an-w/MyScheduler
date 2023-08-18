package com.wang.webservice.mongodb.model.UserInfo;

import com.wang.webservice.mongodb.model.UserInfo.Address.Address;

public class UserInfo {
    private String phoneNumber;
    private Address address;
    private String age;
    private String dateOfBirth;
    private String fName;
    private String lName;

    public UserInfo(){
        this.phoneNumber = "";
        this.address = new Address();
        this.age = "";
        this.dateOfBirth = "";
        this.fName = "";
        this.lName = "";
    }

    public UserInfo(String phoneNumber, Address address, String age, String dateOfBirth, String fName, String lName) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.fName = fName;
        this.lName = lName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
