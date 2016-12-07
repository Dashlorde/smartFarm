/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;


import com.smartFarm.DAO.LivestockSensorDao;
import com.smartFarm.pojo.LivestockSensor;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.smartFarm.DAO.AccelerationSensorDao;
import com.smartFarm.DAO.MilkSensorDao;
import com.smartFarm.DAO.TempSensorDao;
import com.smartFarm.DAO.WeightSensorDao;
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

    WeightSensorDao wsd = new WeightSensorDao();
    
    @Autowired
    AccelerationSensorDao asd = new AccelerationSensorDao();
    
    @Autowired
    MilkSensorDao msd = new MilkSensorDao();

    
    @Autowired
    LivestockSensorDao livestockSensorDao = new LivestockSensorDao();


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
    public String getAllSensor(Model model,HttpServletRequest hsr) throws SQLException {
        List<LivestockSensor> livestockTempSensorList = livestockSensorDao.getAllTempSenorResult();
        List<LivestockSensor> livestockMilkSensorList = livestockSensorDao.getAllMilkSenorResult();
        List<LivestockSensor> livestockWeightSensorList = livestockSensorDao.getAllWeightSenorResult();
        List<LivestockSensor> livestockAcceSensorList = livestockSensorDao.getAllAcceSenorResult();
        
        //model.addAttribute(livestockTempSensorList);
        hsr.setAttribute("livestocksensorlist", livestockTempSensorList);
        hsr.setAttribute("livestocksensorlistM", livestockMilkSensorList);
        hsr.setAttribute("livestocksensorlistW", livestockWeightSensorList);
        hsr.setAttribute("livestocksensorlistA", livestockAcceSensorList);
        //model.addAttribute("size", livestockAcceSensorList.size());
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
    
    @RequestMapping(value = "/livestockmilksenserdetail.htm", method = RequestMethod.GET)
    public String getSingleMilkSenser(Model model,HttpServletRequest hsr) throws SQLException {
        int livestockId = Integer.parseInt(hsr.getParameter("livestock_id"));
        String source = hsr.getParameter("source");
        String type = hsr.getParameter("type");
        List<LivestockSensor> livestockMilkSensorList = livestockSensorDao.getSingleMilkSenorResult(livestockId);
        //model.addAttribute(livestockTempSensorList);
        hsr.setAttribute("livestocksensorlistM", livestockMilkSensorList);
        //model.addAttribute("size", livestockTempSensorList.size());
        //model.addAttribute("id", livestockId);
        model.addAttribute("id", livestockMilkSensorList.get(0).getLivestockId());
        model.addAttribute("type", livestockMilkSensorList.get(0).getSensorType());
        hsr.setAttribute("source", source);
        hsr.setAttribute("livestock_type", type);
        return "livestockSensorDetail";
    }
    
    @RequestMapping(value = "/livestockweightsenserdetail.htm", method = RequestMethod.GET)
    public String getSingleWeightSenser(Model model,HttpServletRequest hsr) throws SQLException {
        int livestockId = Integer.parseInt(hsr.getParameter("livestock_id"));
        String source = hsr.getParameter("source");
        String type = hsr.getParameter("type");
        List<LivestockSensor> livestockWeightSensorList = livestockSensorDao.getSingleWeightSenorResult(livestockId);
        //model.addAttribute(livestockTempSensorList);
        hsr.setAttribute("livestocksensorlistW", livestockWeightSensorList);
        //model.addAttribute("size", livestockTempSensorList.size());
        //model.addAttribute("id", livestockId);
        model.addAttribute("id", livestockWeightSensorList.get(0).getLivestockId());
        model.addAttribute("type", livestockWeightSensorList.get(0).getSensorType());
        hsr.setAttribute("source", source);
        hsr.setAttribute("livestock_type", type);
        return "livestockSensorDetail";
    }
    
    @RequestMapping(value = "/livestockaccesenserdetail.htm", method = RequestMethod.GET)
    public String getSingleAcceSenser(Model model,HttpServletRequest hsr) throws SQLException {
        int livestockId = Integer.parseInt(hsr.getParameter("livestock_id"));
        String source = hsr.getParameter("source");
        String type = hsr.getParameter("type");
        List<LivestockSensor> livestockAcceSensorList = livestockSensorDao.getSingleAcceSenorResult(livestockId);
        //model.addAttribute(livestockTempSensorList);
        hsr.setAttribute("livestocksensorlistA", livestockAcceSensorList);
        //model.addAttribute("size", livestockTempSensorList.size());
        //model.addAttribute("id", livestockId);
        model.addAttribute("id", livestockAcceSensorList.get(0).getLivestockId());
        model.addAttribute("type", livestockAcceSensorList.get(0).getSensorType());
        hsr.setAttribute("source", source);
        hsr.setAttribute("livestock_type", type);
        return "livestockSensorDetail";
    }
    
    @RequestMapping(value = "/livestockallsenserdetail.htm", method = RequestMethod.GET)
    public String getSingleLivestockSenser(Model model,HttpServletRequest hsr) throws SQLException {
        int livestockId = Integer.parseInt(hsr.getParameter("livestock_id"));
        String source = hsr.getParameter("source");
        String type = hsr.getParameter("type");
        List<LivestockSensor> livestockTempSensorList = livestockSensorDao.getSingleTempSenorResult(livestockId);
        List<LivestockSensor> livestockMilkSensorList = livestockSensorDao.getSingleMilkSenorResult(livestockId);
        List<LivestockSensor> livestockWeightSensorList = livestockSensorDao.getSingleWeightSenorResult(livestockId);
        List<LivestockSensor> livestockAcceSensorList = livestockSensorDao.getSingleAcceSenorResult(livestockId);
        //model.addAttribute(livestockTempSensorList);
        hsr.setAttribute("livestocksensorlist", livestockTempSensorList);
        hsr.setAttribute("livestocksensorlistM", livestockMilkSensorList);
        hsr.setAttribute("livestocksensorlistW", livestockWeightSensorList);
        hsr.setAttribute("livestocksensorlistA", livestockAcceSensorList);
        //model.addAttribute("size", livestockTempSensorList.size());
        //model.addAttribute("id", livestockId);
        model.addAttribute("id", livestockId);
       // model.addAttribute("type", livestockAcceSensorList.get(0).getSensorType());
        hsr.setAttribute("source", source);
        hsr.setAttribute("livestock_type", type);
        return "employeeSeeLivestockSensorDetail";
    }
   
   
}
