/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.LivestockDao;
import com.smartFarm.pojo.Cow;
import com.smartFarm.pojo.Livestock;
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
public class addLivestockController {
    
    @Autowired
    LivestockDao livestockDao=new LivestockDao();
    
    @RequestMapping(value="/addLivestock.htm", method=RequestMethod.GET)
    protected String getAddLivestockPage(){
        return "addLivestockForm";
    }
    
    @RequestMapping(value="/addLivestock.htm", method=RequestMethod.POST)
    protected String doSubmitLivestock(HttpServletRequest request)throws Exception{
        Livestock livestock=new Livestock();
        
        String a=request.getParameter("age").toString();
        int age=Integer.parseInt(a);
        String e=request.getParameter("employeeId").toString();
        long employeeId=Long.parseLong(e);
        String w=request.getParameter("weight").toString();
        int weight=Integer.parseInt(w);
        
        
        livestock.setAge(age);
        livestock.setEmployeeId(employeeId);
        
        livestock.setGender(request.getParameter("gender"));
        
        livestock.setWeight(weight);
        livestock.setType(request.getParameter("type"));
        
        int livestockId=livestockDao.addLivestock(livestock);
        livestock.setId(livestockId);
        return "redirect://showAllLivestock.htm";
    }
    
    @RequestMapping(value="/addCow.htm", method=RequestMethod.GET)
    protected String getAddCowPage(){
        return "addCowForm";
    }
    
    @RequestMapping(value="/addCow.htm", method=RequestMethod.POST)
    protected String doSubmitCow(HttpServletRequest request) throws Exception{
        Cow cow=new Cow();
        
        String a=request.getParameter("age").toString();
        int age=Integer.parseInt(a);
        String e=request.getParameter("employeeId").toString();
        long employeeId=Long.parseLong(e);
        String w=request.getParameter("weight").toString();
        int weight=Integer.parseInt(w);
        
        
        cow.setAge(age);
        cow.setEmployeeId(employeeId);
        cow.setEstrousDetection(request.getParameter("estrousDetection"));
        cow.setGender("cow");
        cow.setMilkProduction(request.getParameter("milkProduction"));
        cow.setWeight(weight);
        cow.setType();
        
        int cowId=livestockDao.addCow(cow);
        return "redirect://showAllCow.htm";
        
    }
    
    
    
    
    
    @RequestMapping(value="/addPig", method=RequestMethod.GET)
    protected String getAddPigPage(){
        return "addPigForm";
    }
    
}
