/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.SmartFarmInfoDao;
import com.smartFarm.pojo.Cow;
import com.smartFarm.pojo.Pig;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author zhouyunlu
 */
@Controller
@RequestMapping("/showOverview.htm")
public class ShowOverviewController {
    
    @Autowired
    SmartFarmInfoDao smartFarmInfoDao=new SmartFarmInfoDao();
    
    @RequestMapping(method=RequestMethod.GET)
    protected String showOverview(ModelMap model) throws SQLException{
        ModelAndView mv=new ModelAndView();
        int averageAge=smartFarmInfoDao.getAverageAge();
        System.out.println(averageAge);
        
        int cowNum=smartFarmInfoDao.getCowNumber();
        System.out.println(cowNum);
        
        
       int pigNum=smartFarmInfoDao.getPigNumber();
        
        
        List<Cow> youngCowList=smartFarmInfoDao.getYoungestCow();
        
         List<Cow> oldCowList=smartFarmInfoDao.getoldestCow();
         
         List<Pig> youngPigList=smartFarmInfoDao.getYoungestPig();
         
        List<Pig> oldPigList=smartFarmInfoDao.getOldestPig();
        
        model.addAttribute("pigNum", pigNum);
        model.addAttribute("cowNum", cowNum);
        model.addAttribute("averageAge", averageAge);
        
        model.addAttribute("oldPigList", oldPigList);
        model.addAttribute("youngPigList", youngPigList);
        model.addAttribute("oldCowList", oldCowList);
        model.addAttribute("youngCowList", youngCowList);

        
        
        
         
         
        
        return "viewSmartFarmInfo";
        
        
    }
}
