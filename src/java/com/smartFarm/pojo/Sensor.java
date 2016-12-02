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
public class Sensor {
    static long id = 10000;
    long livestockId;
    String read, type;
    Date time;
    
    public Sensor(){
        id++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLivestockId() {
        return livestockId;
    }

    public void setLivestockId(long livestockId) {
        this.livestockId = livestockId;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    
}
