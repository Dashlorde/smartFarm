/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.FeedRecordDao;
import com.smartFarm.pojo.FeedRecord;
import java.math.BigDecimal;
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
public class FeedRecordController {
    
   // List<FeedRecord> feedRecordList;
    
    @Autowired
    FeedRecordDao feedRecordDao = new FeedRecordDao();
    
//    @RequestMapping(value="/managefeedrecord.htm", method=RequestMethod.GET)
//    public String handleRequest(Model model,HttpServletRequest hsr) throws Exception{
//        long id = Long.parseLong(hsr.getParameter("id"));
//        feedRecordList = feedRecordDao.getAllFeedRecord(id);
//        model.addAttribute(id);
//        model.addAttribute(feedRecordList);
//        //hsr.setAttribute("test", "get method");
//        return "manageFeedRecord";
//        
//    }
    
    @RequestMapping(value="/addfeedrecord.htm", method=RequestMethod.GET)
    protected String getAddFeedRecordPage(HttpServletRequest hsr){
        long id = Long.parseLong(hsr.getParameter("id"));
        String type = hsr.getParameter("type");
        hsr.setAttribute("id", id);
        hsr.setAttribute("type", type);
        return "addFeedRecord";
    }
    
    @RequestMapping(value="/addfeedrecord.htm", method=RequestMethod.POST)
    protected String doSubmitFeedRecord(Model model,HttpServletRequest request)throws Exception{
        
        //request.setAttribute("test", "test");
       
        long id = Long.parseLong(request.getParameter("id"));
        String type = request.getParameter("type");
        List<FeedRecord> feedRecordList = feedRecordDao.getAllFeedRecord(id);
        FeedRecord feedRecord = new FeedRecord();
        
        //String livestockId = request.getParameter("Livestock_Id");
        //TimeStamp time = request.getParameter("time");
        String quantity = request.getParameter("quantity");
        String feed = request.getParameter("feed");
        
        feedRecordList.add(feedRecord);
        
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

        feedRecord.setLivestockId(id);
        feedRecord.setTime(date);
        feedRecord.setQuantity(new BigDecimal(quantity));
        feedRecord.setFeed(feed);
        
        
        //String test = 
        feedRecordDao.addFeedRecord(feedRecord);
       // request.setAttribute("test", test);
        model.addAttribute(feedRecordList);
        request.setAttribute("type", type);
        request.setAttribute("id", id);
        return "livestockDetail";
    }
    
    
}
