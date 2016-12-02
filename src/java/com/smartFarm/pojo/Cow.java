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
    long employeeId;
    int age, weight;
    String gender;
    
     public Cow(){
        
    }
     
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    
    
    
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
       this.gender = gender;
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
