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
public class Pig {
    long id;
    String estrousDetection;
    int age, weight;
    String gender;
    long employeeId;
    
     public Pig(){
        
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

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEstrousDetection() {
        return estrousDetection;
    }

    public void setEstrousDetection(String estrousDetection) {
        this.estrousDetection = estrousDetection;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    
    
}
