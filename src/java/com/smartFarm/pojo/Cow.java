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
public class Cow {
    long id;
    String milkProduction, estrousDetection;
    
    public Cow(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMilkProduction() {
        return milkProduction;
    }

    public void setMilkProduction(String milkProduction) {
        this.milkProduction = milkProduction;
    }

    public String getEstrousDetection() {
        return estrousDetection;
    }

    public void setEstrousDetection(String estrousDetection) {
        this.estrousDetection = estrousDetection;
    }
    
}
