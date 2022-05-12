package com.rsd_tecnology.babycare;

public class HealthReportModel {

    String date, topic, description;

    HealthReportModel()
    {

    }
    public HealthReportModel(String date, String topic, String description) {
        this.date = date;
        this.topic = topic;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
