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
public class DiseaseHistory {
    long livestockId, diseaseId, doctorId;
    String curedOrNot;
    Date diagnosisDate;

    public long getLivestockId() {
        return livestockId;
    }

    public void setLivestockId(long livestockId) {
        this.livestockId = livestockId;
    }

    public long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }


    public String getCuredOrNot() {
        return curedOrNot;
    }

    public void setCuredOrNot(String curedOrNot) {
        this.curedOrNot = curedOrNot;
    }
    
    
    
}
