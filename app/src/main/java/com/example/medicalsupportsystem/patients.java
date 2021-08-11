package com.example.medicalsupportsystem;

public class patients {
    String pname, email, ppassword, idnumber;

    public patients() {

    }

    public patients(String pname, String email, String ppassword, String idnumber) {
        this.pname = pname;
        this.email = email;
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
        return email;
    }

    public void setpUserName(String pemail) {
        this.email = email;
    }

    public String getPpassword() {
        return ppassword;
    }

    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }


}
