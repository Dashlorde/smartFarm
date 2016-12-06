/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.LivestockSensorDao;
import com.smartFarm.DAO.TempSensorDao;
import com.smartFarm.pojo.LivestockSensor;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
    LivestockSensorDao livestockSensorDao = new LivestockSensorDao();

    //need map
    @RequestMapping(value = "/startsensing.htm", method = RequestMethod.GET)
    public String beginTempSensing() {

        tsd.sensing();
        return "sensing";
    }

    //need map
    @RequestMapping(value = "/endsensing.htm", method = RequestMethod.GET)
    public String stopTempSensing() {

        tsd.stopSensing();
        return "sensing";
    }

    @RequestMapping(value = "/sensing.htm", method = RequestMethod.GET)
    public String getAllSensor(Model model,HttpServletRequest hsr) throws SQLException {
        List<LivestockSensor> livestockTempSensorList = livestockSensorDao.getAllTempSenorResult();
        //model.addAttribute(livestockTempSensorList);
        hsr.setAttribute("livestocksensorlist", livestockTempSensorList);
        //model.addAttribute("size", livestockTempSensorList.get(0).getLivestockId());
        return "sensing";
    }
    
    @RequestMapping(value = "/livestocktempsenserdetail.htm", method = RequestMethod.GET)
    public String getSingleSenser(Model model,HttpServletRequest hsr) throws SQLException {
        int livestockId = Integer.parseInt(hsr.getParameter("livestock_id"));
        String source = hsr.getParameter("source");
        String type = hsr.getParameter("type");
        List<LivestockSensor> livestockTempSensorList = livestockSensorDao.getSingleTempSenorResult(livestockId);
        //model.addAttribute(livestockTempSensorList);
        hsr.setAttribute("livestocksensorlist", livestockTempSensorList);
        //model.addAttribute("size", livestockTempSensorList.size());
        //model.addAttribute("id", livestockId);
        model.addAttribute("id", livestockTempSensorList.get(0).getLivestockId());
        model.addAttribute("type", livestockTempSensorList.get(0).getSensorType());
        hsr.setAttribute("source", source);
        hsr.setAttribute("livestock_type", type);
        return "livestockSensorDetail";
    }
   
    

}
