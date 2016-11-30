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
public class Cow extends Livestock{
    //public long Id;
    String milkProduction, estrousDetection;
    
     public Cow(){
        
    }
     
    
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }
    
    
    public long getEmployeeId(){
        return EmployeeId;
    }
    
    public void setEmployeeId(long id){
        this.EmployeeId=id;
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

    public String getType() {
        return this.type;
    }

    public void setType() {
        this.type ="Cow";
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
