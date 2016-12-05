/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.DiseaseHistoryDao;
import com.smartFarm.DAO.FeedRecordDao;
import com.smartFarm.DAO.QuarantineDao;
import com.smartFarm.DAO.VaccineRecordDao;
import com.smartFarm.pojo.DiseaseHistory;
import com.smartFarm.pojo.FeedRecord;
import com.smartFarm.pojo.Quarantine;
import com.smartFarm.pojo.VaccineRecord;
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
public class LiveStockDetailController {
    List<FeedRecord> feedRecordList;
    List<Quarantine> quarantineList;
    List<VaccineRecord> vaccineRecordList;
    List<DiseaseHistory> diseaseHistoryList;
    
    
    @Autowired
    FeedRecordDao feedRecordDao = new FeedRecordDao();
    
    @Autowired
    QuarantineDao quarantineDao = new QuarantineDao();
    
    @Autowired
    VaccineRecordDao vaccineRecordDao = new VaccineRecordDao();
    
    @Autowired
    DiseaseHistoryDao diseaseHistoryDao = new DiseaseHistoryDao();
    
    @RequestMapping(value="/livestockdetail.htm", method=RequestMethod.GET)
    public String handleRequest(Model model,HttpServletRequest hsr) throws Exception{
        long id = Long.parseLong(hsr.getParameter("id"));
        String type = hsr.getParameter("type");
        feedRecordList = feedRecordDao.getAllFeedRecord(id);
        quarantineList = quarantineDao.getAllQuarantine(id);
        vaccineRecordList = vaccineRecordDao.getAllVaccineRecord(id);
        diseaseHistoryList = diseaseHistoryDao.getSingleDiseaseHistory(id);
        model.addAttribute("id",id);
        model.addAttribute("type",type);
        //hsr.setAttribute("id", id);
        model.addAttribute(feedRecordList);
        model.addAttribute(quarantineList);
        model.addAttribute(vaccineRecordList);
        model.addAttribute(diseaseHistoryList);
        //hsr.setAttribute("test", "get method");
        return "livestockDetail";
        
    }
}
