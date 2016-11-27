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
public class Vaccine {
    long vaccineId;
    String name, diseasePrevent, group, vaccineAge, immunePeriod;

    public long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(long vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiseasePrevent() {
        return diseasePrevent;
    }

    public void setDiseasePrevent(String diseasePrevent) {
        this.diseasePrevent = diseasePrevent;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getVaccineAge() {
        return vaccineAge;
    }

    public void setVaccineAge(String vaccineAge) {
        this.vaccineAge = vaccineAge;
    }

    public String getImmunePeriod() {
        return immunePeriod;
    }

    public void setImmunePeriod(String immunePeriod) {
        this.immunePeriod = immunePeriod;
    }
    
    
}
