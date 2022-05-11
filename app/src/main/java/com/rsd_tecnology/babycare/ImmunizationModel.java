package com.rsd_tecnology.babycare;

public class ImmunizationModel {

    String immunization, place, date;

    ImmunizationModel(){

    }
    public ImmunizationModel(String immunization, String place, String date) {
        this.immunization = immunization;
        this.place = place;
        this.date = date;
    }

    public String getImmunization() {
        return immunization;
    }

    public void setImmunization(String immunization) {
        this.immunization = immunization;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
