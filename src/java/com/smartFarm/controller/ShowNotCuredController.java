/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.NotCuredDao;
import com.smartFarm.pojo.Cow;
import com.smartFarm.pojo.Livestock;
import com.smartFarm.pojo.Pig;
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
 * @author zhouyunlu
 */
@Controller
@RequestMapping("/showNotCured.htm")
public class ShowNotCuredController {
    @Autowired
    NotCuredDao notCuredDao=new NotCuredDao();
    
    @RequestMapping(method=RequestMethod.GET)
    public String getNotCuredPage(Model model) throws SQLException{
        List<Livestock> list=notCuredDao.getLivestockNotCured();
        
        model.addAttribute("livestockList", list);
        
        return "showNotCured"; 
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String listSelectNotCured(HttpServletRequest request, Model model) throws SQLException{
        List<Livestock> livestockList;
        List<Cow> cowList;
        List<Pig> pigList;
        
        String option=request.getParameter("option");
        if(option.equals("showLivestockNotCured")){
            livestockList=notCuredDao.getLivestockNotCured();
            model.addAttribute("livestockList", livestockList);
            model.addAttribute("livestockType", "livestock");
            
            return "showNotCured";
        }
        
        else if(option.equals("showCowNotCured")){
            cowList=notCuredDao.getCowNotCured();
            model.addAttribute("livestockList", cowList);
            model.addAttribute("livestockType", "cow");    
            
            return "showNotCured";
        }
        
        else if(option.equals("showPigNotCured")){
            pigList=notCuredDao.getPigNotCured();
            model.addAttribute("livestockList", pigList);
            model.addAttribute("livestockType", "cow");    
            
            return "showNotCured";
        }
        
        return "showNotCured";
    }
}
