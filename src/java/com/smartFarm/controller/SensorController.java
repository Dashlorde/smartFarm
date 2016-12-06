/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.AccelerationSensorDao;
import com.smartFarm.DAO.MilkSensorDao;
import com.smartFarm.DAO.TempSensorDao;
import com.smartFarm.DAO.WeightSensorDao;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jingli
 */
@Controller

public class SensorController {

    @Autowired
    TempSensorDao tsd = new TempSensorDao();
    
    @Autowired
    WeightSensorDao wsd = new WeightSensorDao();
    
    @Autowired
    AccelerationSensorDao asd = new AccelerationSensorDao();
    
    @Autowired
    MilkSensorDao msd = new MilkSensorDao();

    //need map
    @RequestMapping(value = "/startsensing.htm", method = RequestMethod.GET)
    public String beginTempSensing() {

        wsd.sensing();
        asd.sensing();
        msd.sensing();
        tsd.sensing();
        return "sensing";
    }

    //need map
    @RequestMapping(value = "/endsensing.htm", method = RequestMethod.GET)
    public String stopTempSensing() {

        wsd.stopSensing();
        asd.stopSensing();
        msd.stopSensing();
        tsd.stopSensing();
        
        return "sensing";
    }

    @RequestMapping(value = "/sensing.htm", method = RequestMethod.GET)
    public String sensing() {

        return "sensing";
    }

}
