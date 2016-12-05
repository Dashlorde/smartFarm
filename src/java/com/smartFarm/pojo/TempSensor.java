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
public class TempSensor {
    private double tsRead;
    private String tsTime;
    private int tsId;

    
    
    public TempSensor(double tsRead, String tsTime, int tsId) {
        this.tsRead = tsRead;
        this.tsTime = tsTime;
        this.tsId = tsId;
    }
    
    
//放入controller
    public TempSensor(int tsId) {
        
        this.tsId=tsId;
        
        Date time=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tsTime=sdf.format(time);
        
        Random generator=new Random();
        tsRead=38+3*generator.nextGaussian();
        
    }

    public double getTsRead() {
        return tsRead;
    }

    public void setTsRead(double tsRead) {
        this.tsRead = tsRead;
    }

    public String getTsTime() {
        return tsTime;
    }

    public void setTsTime(String tsTime) {
        this.tsTime = tsTime;
    }

    public int getTsId() {
        return tsId;
    }

    public void setTsId(int tsId) {
        this.tsId = tsId;
    }
    
    
    
    
}
