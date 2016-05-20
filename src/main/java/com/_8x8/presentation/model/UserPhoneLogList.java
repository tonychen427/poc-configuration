
package com._8x8.presentation.model;

public class UserPhoneLogList {
    Integer userId;
    String fullname;
    Integer totalAnswer;
    Integer totalTransfer;
    Integer totalMissed;

    public UserPhoneLogList(Integer userId, String fullname, Integer totalAnswer, Integer totalTransfer, Integer totalMissed) {
        this.userId = userId;
        this.fullname = fullname;
        this.totalAnswer = totalAnswer;
        this.totalTransfer = totalTransfer;
        this.totalMissed = totalMissed;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getTotalAnswer() {
        return totalAnswer;
    }

    public void setTotalAnswer(Integer totalAnswer) {
        this.totalAnswer = totalAnswer;
    }

    public Integer getTotalTransfer() {
        return totalTransfer;
    }

    public void setTotalTransfer(Integer totalTransfer) {
        this.totalTransfer = totalTransfer;
    }

    public Integer getTotalMissed() {
        return totalMissed;
    }

    public void setTotalMissed(Integer totalMissed) {
        this.totalMissed = totalMissed;
    }
    
}
