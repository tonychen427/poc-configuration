package com._8x8.presentation.model;

public class UserPhoneLog {
    Integer Id;
    Integer userId;
    Boolean answer;
    Boolean trasfer;
    Boolean missed;
    String timestamp;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public Boolean getTrasfer() {
        return trasfer;
    }

    public void setTrasfer(Boolean trasfer) {
        this.trasfer = trasfer;
    }

    public Boolean getMissed() {
        return missed;
    }

    public void setMissed(Boolean missed) {
        this.missed = missed;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    
    
}
