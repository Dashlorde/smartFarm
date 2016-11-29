/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.LivestockDao;
import com.smartFarm.pojo.Livestock;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author zhouyunlu
 */
@Controller
public class showLivestockController {
    
    @Autowired
    LivestockDao livestockDao=new LivestockDao();
    
    
    @RequestMapping(value="/showAllLivestock.htm", method=RequestMethod.GET)
    protected String showAllLivestock(Model model, HttpServletRequest request)throws Exception{
        List<Livestock> livestockList;
        HttpSession session=request.getSession();
        if(session.getAttribute("Name")!=null){
            
        }
        ModelAndView mv=new ModelAndView();
        livestockList=livestockDao.getAllLivestock();
        for(Livestock l: livestockList){
            System.out.println(l.getId()+" "+l.getType());
        }
        model.addAttribute(livestockList);
        return "index";

        
    }

    
}