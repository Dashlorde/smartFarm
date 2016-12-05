/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import java.util.Timer;
import java.util.TimerTask;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 *
 * @author jingli
 */
@Controller

public class SensorController {

    public String beginTempSensing() {

        Timer tempTimer = new Timer();
        tempTimer.schedule(new TempTimerTask(), 1, 1000);

        return null;
    }

    //TempTimerTask ttt=new TempTimerTask();
}
