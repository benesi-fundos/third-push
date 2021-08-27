package com.example.medicalsupportsystem;

public class appointments {
    String fullname, idnum, distict, ta, village, psign1, psign2, psign3, psign4;
    public appointments() {
    }

    public appointments(String fullname, String idnum, String distict, String ta, String village, String psign1, String psign2, String psign3, String psign4) {
        this.fullname = fullname;
        this.idnum = idnum;
        this.distict = distict;
        this.ta = ta;
        this.village = village;
        this.psign1 = psign1;
        this.psign2 = psign2;
        this.psign3 = psign3;
        this.psign4 = psign4;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public String getDistict() {
        return distict;
    }

    public void setDistict(String distict) {
        this.distict = distict;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPsign1() {
        return psign1;
    }

    public void setPsign1(String psign1) {
        this.psign1 = psign1;
    }

    public String getPsign2() {
        return psign2;
    }

    public void setPsign2(String psign2) {
        this.psign2 = psign2;
    }

    public String getPsign3() {
        return psign3;
    }

    public void setPsign3(String psign3) {
        this.psign3 = psign3;
    }

    public String getPsign4() {
        return psign4;
    }

    public void setPsign4(String psign4) {
        this.psign4 = psign4;
    }
}



