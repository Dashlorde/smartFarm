/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.pojo;

import java.util.Date;



/**
 *
 * @author zhouyunlu
 */
public class Alert {
    long sensorId;
    String possibleEvent;
    Date datetime;

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public String getPossibleEvent() {
        return possibleEvent;
    }

    public void setPossibleEvent(String possibleEvent) {
        this.possibleEvent = possibleEvent;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    
    
    
}
