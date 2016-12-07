/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.pojo;

import java.sql.Timestamp;




/**
 *
 * @author zhouyunlu
 */
public class Alert {

    public Alert() {
    }
    
    long sensorId;
    String possibleEvent;
    Timestamp time;
    long livestockId;
    String sensorType;

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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public long getLivestockId() {
        return livestockId;
    }

    public void setLivestockId(long livestockId) {
        this.livestockId = livestockId;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
  
}
