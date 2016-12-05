/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.SensorDao;
import com.smartFarm.pojo.SensorInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zhouyunlu
 */
@Controller

public class ShowSensorInfoController {

    @Autowired
    SensorDao sensorDao = new SensorDao();

    String action;

    @RequestMapping(value="/showAllSensorInfo.htm", method = RequestMethod.GET)
    protected String getShowSensorInfoPage(HttpServletRequest request, Model model) throws SQLException {
        List<SensorInfo> sensorList = new ArrayList<>();
        
            sensorList = sensorDao.getSensorInfo();

            model.addAttribute("sensorList", sensorList);
            for (SensorInfo s : sensorList) {
                System.out.println("sensor id: " + s.getSensorId());
            }
        return "showSensorInfo";
    }

    @RequestMapping(value="/showSensorInfo.htm", method = RequestMethod.POST)
    protected String searchSensorInfo(HttpServletRequest request, Model model) throws SQLException {
        List<SensorInfo> sensorList = new ArrayList<>();

        String search = request.getParameter("search");
        String option = request.getParameter("option");
        action = request.getParameter("action");

        if (action.equals("searchSensor")) {
            if (option.equals("sensorId")) {
                long sensorId = Long.parseLong(search);
                sensorList = sensorDao.getSensorInfoBySensorId(sensorId);
                model.addAttribute("sensorList", sensorList);
            } else if (option.equals("livestockId")) {
                long livestockId = Long.parseLong(search);
                sensorList = sensorDao.getSensorInfoByLivestockId(livestockId);
                model.addAttribute("sensorList", sensorList);
            }else if(option.equals("showAll")){
                sensorList=sensorDao.getSensorInfo();
                model.addAttribute("sensorList", sensorList);
            }else if(option.equals("sensorType")){
                sensorList=sensorDao.getSensorInfoBySensorType(search);
                model.addAttribute("sensorList", sensorList);
            }
        }

        return "showSensorInfo";
    }
}
