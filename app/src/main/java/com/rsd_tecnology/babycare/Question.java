package com.example.helpcenterhome;

import java.io.Serializable;

public class Question implements Serializable
{
    private String question;
    private String reply;
    private String key;
    private int id;



    public Question(){}

    public Question(String question , String reply, int id)
    {
        this.question = question;
        this.reply = reply;
        this.id =id;

    }
    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
