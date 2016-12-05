/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.TempSensorDao;
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

    //need map
    @RequestMapping(value = "/.htm", method = RequestMethod.GET)
    public String beginTempSensing() {

        tsd.sensing();
        return null;
    }
    
    //need map
    @RequestMapping(value = "/.htm", method = RequestMethod.GET)
    public String stopTempSensing() {

        tsd.stopSensing();
        return null;
    }

    
}
