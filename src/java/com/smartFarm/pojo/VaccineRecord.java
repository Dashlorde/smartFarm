/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.pojo;

import java.sql.Date;



/**
 *
 * @author zhouyunlu
 */
public class VaccineRecord {
    long vaccineId, livestockId;
    Date lastVaccineDate, nextVaccineDate;

    public long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(long vaccineId) {
        this.vaccineId = vaccineId;
    }

    public long getLivestockId() {
        return livestockId;
    }

    public void setLivestockId(long livestockId) {
        this.livestockId = livestockId;
    }

    public Date getLastVaccineDate() {
        return lastVaccineDate;
    }

    public void setLastVaccineDate(Date lastVaccineDate) {
        this.lastVaccineDate = lastVaccineDate;
    }

    public Date getNextVaccineDate() {
        return nextVaccineDate;
    }

    public void setNextVaccineDate(Date nextVaccineDate) {
        this.nextVaccineDate = nextVaccineDate;
    }
    
    
}
