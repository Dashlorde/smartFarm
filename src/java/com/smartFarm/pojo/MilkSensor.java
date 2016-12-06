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
public class MilkSensor {
    private double msRead;
    private String msTime;
    private int msId;

    public MilkSensor(int msId) {
        this.msId = msId;
        
        Date time=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        msTime=sdf.format(time);
        
        Random generator=new Random();
        msRead=27.6+7.5*generator.nextGaussian();
        
    }

    public MilkSensor(double msRead, String msTime, int msId) {
        this.msRead = msRead;
        this.msTime = msTime;
        this.msId = msId;
    }

    public double getMsRead() {
        return msRead;
    }

    public void setMsRead(double msRead) {
        this.msRead = msRead;
    }

    public String getMsTime() {
        return msTime;
    }

    public void setMsTime(String msTime) {
        this.msTime = msTime;
    }

    public int getMsId() {
        return msId;
    }

    public void setMsId(int msId) {
        this.msId = msId;
    }
    
    
}
