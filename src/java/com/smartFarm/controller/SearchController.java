/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.LivestockDao;
import com.smartFarm.pojo.Cow;
import com.smartFarm.pojo.Pig;
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
public class SearchController {
    
    @Autowired
    LivestockDao livestockDao=new LivestockDao();
    
    @RequestMapping(value="/searchLivestock.htm",method=RequestMethod.POST )
    protected String getLivestock(HttpServletRequest request, Model model) throws SQLException{
        String type=request.getParameter("type");
        String option=request.getParameter("option");
        String search=request.getParameter("search");
        List<Cow> cowList=new ArrayList();
        List<Pig> pigList=new ArrayList();
        if(type.equals("cow")){
            
            if(option.equals("id")){
                long id=Long.parseLong(search);
                cowList=livestockDao.getCowById(id);
            }
            else if(option.equals("employeeId")){
                long employeeId=Long.parseLong(search);
                cowList=livestockDao.getCowByEmployeeId(employeeId);
            }
            else if(option.equals("age")){
                int age=Integer.parseInt(search);
                cowList=livestockDao.getCowByAge(age);
            }
            
            model.addAttribute("livestockList", cowList);
            model.addAttribute("livestockType", "cow");
        }
        
        else if(type.equals("pig")){
        
            if(option.equals("id")){
                long id=Long.parseLong(search);
                pigList=livestockDao.getPigById(id);
            }
            else if(option.equals("employeeId")){
                long employeeId=Long.parseLong(search);
                pigList=livestockDao.getPigByEmployeeId(employeeId);
            }
            else if(option.equals("age")){
                int age=Integer.parseInt(search);
                pigList=livestockDao.getPigByAge(age);
            }
            
            model.addAttribute("livestockList", pigList);
            model.addAttribute("livestockType", "pig");
        
    }
        
        return "index";
    }
    
}
