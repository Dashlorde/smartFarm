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
public class WeightSensor {
    private double wsRead;
    private String wsTime;
    private int wsId;

    public WeightSensor(double wsRead, String wsTime, int wsId) {
        this.wsRead = wsRead;
        this.wsTime = wsTime;
        this.wsId = wsId;
    }

    public WeightSensor(int wsId) {
        this.wsId = wsId;
        
        Date time=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        wsTime=sdf.format(time);
        
        Random generator=new Random();
        wsRead=150+75*generator.nextGaussian();
        
    }

    public double getWsRead() {
        return wsRead;
    }

    public void setWsRead(double wsRead) {
        this.wsRead = wsRead;
    }

    public String getWsTime() {
        return wsTime;
    }

    public void setWsTime(String wsTime) {
        this.wsTime = wsTime;
    }

    public int getWsId() {
        return wsId;
    }

    public void setWsId(int wsId) {
        this.wsId = wsId;
    }

    
    
    
}
