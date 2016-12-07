/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.AlertDao;
import com.smartFarm.pojo.Alert;
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
 * @author he.fa
 */
@Controller
public class AlertController {
    
    @Autowired
    AlertDao alertDao = new AlertDao();
    
    @RequestMapping(value="/managealert.htm", method=RequestMethod.GET)
    public String handleRequest(Model model,HttpServletRequest hsr) throws Exception{
        List<Alert> alertList = alertDao.getAllAlert();
        model.addAttribute(alertList);
        //hsr.setAttribute("test", "get method");
        return "manageAlert";
        
    }
    
}
