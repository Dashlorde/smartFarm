/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.QuarantineDao;
import com.smartFarm.pojo.Quarantine;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author he.fa
 */
@Controller
public class QuarantineController {
     @Autowired
     QuarantineDao quarantineDao = new QuarantineDao();
     
     @RequestMapping(value="/addquarantine.htm", method=RequestMethod.GET)
    protected String getAddQuarantine(HttpServletRequest hsr){
        long id = Long.parseLong(hsr.getParameter("id"));
        String type = hsr.getParameter("type");
        hsr.setAttribute("id", id);
        hsr.setAttribute("type", type);
        return "addQuarantine";
    }
    
    @RequestMapping(value="/addquarantine.htm", method=RequestMethod.POST)
    protected String doSubmitQuarantine(Model model,HttpServletRequest request)throws Exception{
        
        //request.setAttribute("test", "test");
       
        long id = Long.parseLong(request.getParameter("id"));
        String type = request.getParameter("type");
        List<Quarantine> quarantineList = quarantineDao.getAllQuarantine(id);
        Quarantine quarantine = new Quarantine();
        
        Date date = java.sql.Date.valueOf(request.getParameter("date"));
        String epidemic = request.getParameter("epidemic");
        String location = request.getParameter("location");
        String status = request.getParameter("status");
        
        quarantineList.add(quarantine);
        
        //java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());

        quarantine.setLivestockId(id);
        quarantine.setTime(date);
        quarantine.setEpidemic(epidemic);
        quarantine.setLocation(location);
        quarantine.setStatus(status);
        
        
        //String test = 
        quarantineDao.addQuarantine(quarantine);
       // request.setAttribute("test", test);
        model.addAttribute(quarantineList);
        request.setAttribute("type", type);
        request.setAttribute("id", id);
        return "livestockDetail";
    }
}
