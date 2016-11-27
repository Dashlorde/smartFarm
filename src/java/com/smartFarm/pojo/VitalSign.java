/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.pojo;

import java.math.BigDecimal;

/**
 *
 * @author zhouyunlu
 */
public class VitalSign {
    long Id;
    BigDecimal temperature, bloodpressure, humidity;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getBloodpressure() {
        return bloodpressure;
    }

    public void setBloodpressure(BigDecimal bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }
    
    
            
}
