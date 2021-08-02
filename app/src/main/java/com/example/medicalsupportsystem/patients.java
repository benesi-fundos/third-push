package com.example.medicalsupportsystem;

public class patients {
    String pname, pUserName, ppassword, idnumber;

    public patients() {

    }

    public patients(String pname, String pUserName, String ppassword, String idnumber) {
        this.pname = pname;
        this.pUserName = pUserName;
        this.ppassword = ppassword;
        this.idnumber = idnumber;
    }

    public String getPname() {
        return pname;
    }
    public String getidnumber() {
        return idnumber;
    }
    public void setidnumber(String idnumber) {
        this.idnumber = idnumber;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getpUserName() {
        return pUserName;
    }

    public void setpUserName(String pemail) {
        this.pUserName = pUserName;
    }

    public String getPpassword() {
        return ppassword;
    }

    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }


}
