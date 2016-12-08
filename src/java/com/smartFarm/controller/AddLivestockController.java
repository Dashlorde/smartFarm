/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.LivestockDao;
import com.smartFarm.pojo.Cow;
import com.smartFarm.pojo.Livestock;
import com.smartFarm.pojo.Pig;
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
public class AddLivestockController {
    
    @Autowired
    LivestockDao livestockDao = new LivestockDao();
    
    //----------------------------add livestock-------------------------------------------------
    
    @RequestMapping(value="/addLivestock.htm", method=RequestMethod.GET)
    protected String getAddLivestockPage(){
        return "addLivestockForm";
    }
    
    @RequestMapping(value="/addLivestock.htm", method=RequestMethod.POST)
    protected String doSubmitLivestock(HttpServletRequest request)throws Exception{
        Livestock livestock=new Livestock();
        
        String ageString=request.getParameter("age").toString();
        int age=Integer.parseInt(ageString);
        String employeeString=request.getParameter("employeeId").toString();
        long employeeId=Long.parseLong(employeeString);
        String weightString=request.getParameter("weight").toString();
        int weight=Integer.parseInt(weightString);
       
        livestock.setAge(age);
        livestock.setEmployeeId(employeeId);
        
        livestock.setGender(request.getParameter("gender"));
        
        livestock.setWeight(weight);
        livestock.setType(request.getParameter("type"));
        
        livestockDao.addLivestock(livestock);
        
        return "redirect://showAllLivestock.htm";
    }
    
    //-----------------------------add cow-------------------------------------------------
    @RequestMapping(value="/addCow.htm", method=RequestMethod.GET)
    protected String getAddCowPage(){
        return "addCowForm";
    }
    
    @RequestMapping(value="/addCow.htm", method=RequestMethod.POST)
    protected String doSubmitCow(HttpServletRequest request) throws Exception{
        List<Cow> cowList = livestockDao.getAllCow();
        Cow cow=new Cow();
        
        String ageString=request.getParameter("age");
        int age=Integer.parseInt(ageString);
        String employeeIdString=request.getParameter("employeeId");
        long employeeId=Long.parseLong(employeeIdString);
        String weightString=request.getParameter("weight");
        int weight=Integer.parseInt(weightString);
        String milkProduction = request.getParameter("milk_production");
        String estrousDetection = request.getParameter("estrous_detection");
        
        int id=livestockDao.getCowId();
        cow.setAge(age);
        cow.setEmployeeId(employeeId);
        cow.setId(id);
        cow.setGender("cow");
        cow.setMilkProduction(milkProduction);
        cow.setEstrousDetection(estrousDetection);
        
        cow.setWeight(weight);
        livestockDao.addCow(cow);
        return "redirect://showAllCow.htm";
        
    }
    
    //--------------------------------add pig----------------------------------------------------------
   
    @RequestMapping(value="/addPig", method=RequestMethod.GET)
    protected String getAddPigPage(){
        return "addPigForm";
    }
    
     @RequestMapping(value="/addPig.htm", method=RequestMethod.POST)
    protected String doSubmitPig(HttpServletRequest request) throws Exception{
        Pig pig=new Pig();
        List<Pig> pigList = livestockDao.getAllPig();
        String ageString=request.getParameter("age");
        int age=Integer.parseInt(ageString);
        String employeeIdString=request.getParameter("employeeId");
        long employeeId=Long.parseLong(employeeIdString);
        String weightString=request.getParameter("weight");
        int weight=Integer.parseInt(weightString);
        String estrousDetection = request.getParameter("estrous_detection");
        
        String gender=request.getParameter("gender");
        
        
        int id=livestockDao.getPigId();
        pig.setAge(age);
        pig.setEmployeeId(employeeId);
        pig.setId(id);
        pig.setGender(gender);
        pig.setEstrousDetection(estrousDetection);
        pig.setWeight(weight);
        livestockDao.addPig(pig);
        return "redirect://showAllPig.htm";
        
    }
    
}
