/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author zhouyunlu
 */
public class FeedRecord {
    Timestamp time;
    long livestockId;
    BigDecimal quantity;
    String feed;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public long getLivestockId() {
        return livestockId;
    }

    public void setLivestockId(long livestockId) {
        this.livestockId = livestockId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }
    
    
}
