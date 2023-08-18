package com.wang.webservice.mongodb.model.UserInfo.Address;

public class Address {
    private String street;
    private String number;
    private String postalCode;
    private String cityAndCountry;
    public Address(){
        this.street = "";
        this.number = "";
        this.postalCode = "";
        this.cityAndCountry = "";
    }

    public Address(String street, String number, String postalCode, String cityAndCountry) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.cityAndCountry = cityAndCountry;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityAndCountry() {
        return cityAndCountry;
    }

    public void setCityAndCountry(String cityAndCountry) {
        this.cityAndCountry = cityAndCountry;
    }
}
