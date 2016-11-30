/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.LivestockDao;
import com.smartFarm.DAO.userDao;
import com.smartFarm.pojo.Livestock;
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
public class showLivestockController {
    
    @Autowired
    LivestockDao livestockDao=new LivestockDao();
    
    @Autowired 
    userDao userDao=new userDao();
    
    
    //list all the livestock
    @RequestMapping(value="/showAllLivestock.htm", method=RequestMethod.GET)
    protected String showAllLivestock(Model model, HttpServletRequest request)throws Exception{
        List<Livestock> livestockList;
        livestockList=livestockDao.getAllLivestock();
        for(Livestock l: livestockList){
            System.out.println(l.getId()+" "+l.getType());
        }
        model.addAttribute(livestockList);
        return "index";
        
    }
    
    //list all the cow
    @RequestMapping(value="/showAllCow.htm", method=RequestMethod.GET)
    protected String showAllCow(Model model) throws Exception{
        List<Livestock> cowList;
        
        cowList=livestockDao.getAllCow();
        for(Livestock c: cowList){
            System.out.println(c.getId());
        }
        model.addAttribute(cowList);
        return "index";
        
    }
    
    //list all the pig
    @RequestMapping(value="/showAllPig.htm", method=RequestMethod.GET)
    protected String showAllPig(Model model) throws Exception{
        List<Livestock> pigList;
        
        pigList=livestockDao.getAllPig();
        for(Livestock p: pigList){
            System.out.println(p.getId());
        }
        model.addAttribute(pigList);
        return "index";
        
    }
    
    

    
}
