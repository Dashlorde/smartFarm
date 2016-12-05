/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.TempSensorDao;
import com.smartFarm.pojo.TempSensor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jingli
 */
public class TempTimerTask extends TimerTask{


    
    @Override
    public void run() {
        
        conn=get
        TempSensor ts=new TempSensor(0);

    }
    
}
