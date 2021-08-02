package com.example.medicalsupportsystem;

public class professional {
    String prName, PrIdNumber, PrEmail, prPassword;

    public professional() {

    }

    public professional(String prName, String prIdNumber, String prEmail, String prPassword) {
        this.prName = prName;
        this.PrIdNumber = prIdNumber;
        this.PrEmail = prEmail;
        this.prPassword = prPassword;
    }

    public String getPrName() {
        return prName;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    public String getPrIdNumber() {
        return PrIdNumber;
    }

    public void setPrIdNumber(String prIdNumber) {
        PrIdNumber = prIdNumber;
    }

    public String getPrEmail() {
        return PrEmail;
    }

    public void setPrEmail(String prEmail) {
        PrEmail = prEmail;
    }

    public String getPrPassword() {
        return prPassword;
    }

    public void setPrPassword(String prPassword) {
        this.prPassword = prPassword;
    }
}
