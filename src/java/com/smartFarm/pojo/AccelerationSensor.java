/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author jingli
 */
public class AccelerationSensor {
    
    private double asRead;
    private String asTime;
    private int asId;

    public AccelerationSensor(int asId) {
        this.asId = asId;
        
        Date time=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        asTime=sdf.format(time);
        
        Random generator=new Random();
        asRead=1+Math.abs(3*generator.nextGaussian());
                
    }

    public AccelerationSensor(double asRead, String asTime, int asId) {
        this.asRead = asRead;
        this.asTime = asTime;
        this.asId = asId;
    }

    public double getAsRead() {
        return asRead;
    }

    public void setAsRead(double asRead) {
        this.asRead = asRead;
    }

    public String getAsTime() {
        return asTime;
    }

    public void setAsTime(String asTime) {
        this.asTime = asTime;
    }

    public int getAsId() {
        return asId;
    }

    public void setAsId(int asId) {
        this.asId = asId;
    }
    
    
    
}
