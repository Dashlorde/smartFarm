/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.SensorDao;
import com.smartFarm.pojo.AnimalSensor;
import com.smartFarm.pojo.Sensor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zhouyunlu
 */
@Controller
@RequestMapping("/addSensor.htm")
public class AddSensorController {
    
    
    @Autowired
    SensorDao sensorDao=new SensorDao();
    
    @RequestMapping(method=RequestMethod.GET)
    protected String getAddSensorPage(){
        return "addSensor";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    protected String doSubmitSensorPage(HttpServletRequest request) throws Exception{
        Sensor sensor=new Sensor();
        AnimalSensor aSensor=new AnimalSensor();
        List<Sensor> sensorList=sensorDao.getAllSensor();
        
        String livestockIdString=request.getParameter("livestockId");
        long livestockId=Long.parseLong(livestockIdString);
        String sensorType=request.getParameter("sensorType");
        
        long sensorId=sensorDao.getSensorId();
        
        sensor.setSensorId(sensorId);
        sensor.setSensorType(sensorType);
        aSensor.setLivestockId(livestockId);
        aSensor.setSensorId(sensorId);
        
        sensorDao.addAnimalSensor(aSensor);
        sensorDao.addSensor(sensor);
        
        return "redirect://showAllSensorInfo.htm";
        
        
    }
    
}
