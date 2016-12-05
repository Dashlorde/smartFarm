/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.pojo;

/**
 *
 * @author zhouyunlu
 */
public class SensorInfo {
    long sensorId, livestockId;
    String sensorType;
    
    public SensorInfo(){
        
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
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
