/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.presentation.model;

/**
 *
 * @author ttran
 */
public class GCM {
    
    public Integer id;
    public String gcmSendURL;
    public String gcmProjectNumber;
    public String gcmAPIKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGcmSendURL() {
        return gcmSendURL;
    }

    public void setGcmSendURL(String gcmSendURL) {
        this.gcmSendURL = gcmSendURL;
    }

    public String getGcmProjectNumber() {
        return gcmProjectNumber;
    }

    public void setGcmProjectNumber(String gcmProjectNumber) {
        this.gcmProjectNumber = gcmProjectNumber;
    }

    public String getGcmAPIKey() {
        return gcmAPIKey;
    }

    public void setGcmAPIKey(String gcmAPIKey) {
        this.gcmAPIKey = gcmAPIKey;
    }

    
}
