/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.pojo;

import java.sql.Timestamp;

/**
 *
 * @author he.fa
 */
public class LivestockSensor {
    
    public LivestockSensor(){
        
    }
    
    private int sensorId;
    private Timestamp time;
    private double read;
    private String sensorType;
    private Long livestockId;

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public double getRead() {
        return read;
    }

    public void setRead(double read) {
        this.read = read;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Long getLivestockId() {
        return livestockId;
    }

    public void setLivestockId(Long livestockId) {
        this.livestockId = livestockId;
    }

    
    
}
