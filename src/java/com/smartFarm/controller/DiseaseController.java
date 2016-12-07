/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;


import com.smartFarm.DAO.DiseaseDao;
import com.smartFarm.DAO.DiseaseHistoryDao;
import com.smartFarm.pojo.Disease;
import com.smartFarm.pojo.DiseaseHistory;
import java.sql.Date;
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
 * @author he.fa
 */
@Controller
public class DiseaseController {
    private static long count = 1;
    
    private List<Disease> diseaseList;
    //private List<DiseaseHistory> diseaseHistoryList;
    @Autowired
    DiseaseDao diseaseDao = new DiseaseDao();
    
    @Autowired
    DiseaseHistoryDao diseaseHistoryDao= new DiseaseHistoryDao();
    
    @RequestMapping(value="/managedisease.htm", method=RequestMethod.GET)
    public String handleRequest(Model model,HttpServletRequest hsr) throws Exception{
        diseaseList = diseaseDao.getAllDisease();
        model.addAttribute(diseaseList);
        //hsr.setAttribute("test", "get method");
        return "manageDisease";
        
    }
    
    @RequestMapping(value="/adddisease.htm", method=RequestMethod.GET)
    protected String getAddDiseasePage(){
        return "addDisease";
    }
    
    @RequestMapping(value="/adddisease.htm", method=RequestMethod.POST)
    protected String doSubmitDisease(Model model,HttpServletRequest request)throws Exception{
        count = 1 + diseaseList.size();
        
        Disease disease = new Disease();
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String cure = request.getParameter("cure");
        String region = request.getParameter("region");
        
        diseaseList.add(disease);
        
        long id = count++;
        disease.setId(id);
        disease.setName(name);
        disease.setDescription(description);
        disease.setCure(cure);
        disease.setRegion(region);
        //String q = 
        diseaseDao.addDisease(disease);
        //request.setAttribute("test", "post method");
        model.addAttribute(diseaseList);
        return "manageDisease";
    }
    
    
    @RequestMapping(value="/managediseasehistory.htm", method=RequestMethod.GET)
    public String handleHistoryRequest(Model model,HttpServletRequest hsr) throws Exception{
        List<DiseaseHistory> diseaseHistoryList;
        diseaseHistoryList = diseaseHistoryDao.getAllDiseaseHistory();
        model.addAttribute( diseaseHistoryList);
        //hsr.setAttribute("test", "get method");
        return "manageDiseaseHistory";
        
    }
    
    @RequestMapping(value="/adddiseasehistory.htm", method=RequestMethod.GET)
    protected String getAddDiseaseHistoryPage(HttpServletRequest request){
        Long doctorId = Long.parseLong(request.getParameter("doctor_id"));
        request.setAttribute("id", doctorId);
        return "addDiseaseHistory";
    }
    
    @RequestMapping(value="/adddiseasehistory.htm", method=RequestMethod.POST)
    protected String doSubmitDiseaseHistory(Model model,HttpServletRequest request)throws Exception{
        List<DiseaseHistory> diseaseHistoryList = diseaseHistoryDao.getAllDiseaseHistory();
        DiseaseHistory diseaseHistory = new DiseaseHistory();
        //List<DiseaseHistory> diseaseHistoryList = new ArrayList<>();
        Long doctorId = Long.parseLong(request.getParameter("doctor_id"));
        Long livestockId = Long.parseLong(request.getParameter("livestock_id"));
        Date date = java.sql.Date.valueOf(request.getParameter("date"));
        Long diseaseId = Long.parseLong(request.getParameter("disase_id"));
        String cureornot = request.getParameter("cure_or_not");
        
        diseaseHistoryList.add(diseaseHistory);
        
        diseaseHistory.setLivestockId(livestockId);
        diseaseHistory.setDiagnosisDate(date);
        diseaseHistory.setDiseaseId(diseaseId);
        diseaseHistory.setDoctorId(doctorId);
        diseaseHistory.setCuredOrNot(cureornot);
        //String q = 
        diseaseHistoryDao.addDiseaseHistory(diseaseHistory);
        //request.setAttribute("test", "post method");
        model.addAttribute(diseaseHistoryList);
        return "manageDiseaseHistory";
    }
    
    @RequestMapping(value="/searchdiseasehistory.htm",method=RequestMethod.POST )
    protected String getLivestockDisaseHitory(HttpServletRequest request, Model model) throws SQLException{
        String option=request.getParameter("option");
        Long id = Long.parseLong(request.getParameter("search"));
        List<DiseaseHistory> diseaseHistoryList;
        if(option.equals("livestockId")){
            diseaseHistoryList = diseaseHistoryDao.getSingleDiseaseHistory(id);
        }else if(option.equals("doctorId")){
            diseaseHistoryList = diseaseHistoryDao.getSingleDiseaseHistoryByDoctorId(id);
        }else{
            diseaseHistoryList = diseaseHistoryDao.getSingleDiseaseHistoryByDiseaseId(id);
        }
        request.setAttribute("diseaseHistoryList", diseaseHistoryList);
        //model.addAllAttributes(diseaseHistoryList);
        return "manageDiseaseHistory";
    }
    
    @RequestMapping(value="/searchdiseasehistorynotcure.htm",method=RequestMethod.GET )
     protected String getDiseaseHistoryNotCure(HttpServletRequest request) throws SQLException{
        String status = request.getParameter("status");
        List<DiseaseHistory> diseaseHistoryList = diseaseHistoryDao.getSingleDiseaseHistoryByNotCured(status);
        request.setAttribute("diseaseHistoryList", diseaseHistoryList);
        return "manageDiseaseHistory";
    }
    
}
