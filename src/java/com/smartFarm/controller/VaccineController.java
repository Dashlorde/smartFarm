/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.VaccineDao;
import com.smartFarm.DAO.VaccineRecordDao;
import com.smartFarm.pojo.Vaccine;
import com.smartFarm.pojo.VaccineRecord;
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
public class VaccineController {
    
    private static long count = 100;
    private List<Vaccine> vaccineList;    
    
    @Autowired
    VaccineDao vaccineDao = new VaccineDao();
    
    @Autowired
    VaccineRecordDao vaccineRecordDao = new VaccineRecordDao();
    
    @RequestMapping(value="/managevaccine.htm", method=RequestMethod.GET)
    public String handleRequest(Model model,HttpServletRequest hsr) throws Exception{
        vaccineList = vaccineDao.getAllVaccine();
        model.addAttribute(vaccineList);
        //hsr.setAttribute("test", "get method");
        return "manageVaccine";
        
    }
    
    @RequestMapping(value="/addvaccine.htm", method=RequestMethod.GET)
    protected String getAddVaccinePage(){
        return "addVaccine";
    }
    
    @RequestMapping(value="/addvaccine.htm", method=RequestMethod.POST)
    protected String doSubmitVaccine(Model model,HttpServletRequest request)throws Exception{
        count = 100 + vaccineList.size();
        
        Vaccine vaccine = new Vaccine();
        
        String name = request.getParameter("name");
        String diseasePrevent = request.getParameter("prevent_disease");
        String group = request.getParameter("group");
        String vaccineAge = request.getParameter("vaccine_age");
        String immunePeriod = request.getParameter("immune_period");
        
        vaccineList.add(vaccine);
        
        long id = count++;
        vaccine.setVaccineId(id);
        vaccine.setName(name);
        vaccine.setDiseasePrevent(diseasePrevent);
        vaccine.setGroup(group);
        vaccine.setVaccineAge(vaccineAge);
        vaccine.setImmunePeriod(immunePeriod);
        //String q = 
        vaccineDao.addVaccine(vaccine);
        //request.setAttribute("test", "post method");
        model.addAttribute(vaccineList);
        return "manageVaccine";
    }
    
    
    
    
     @RequestMapping(value="/addvaccinerecord.htm", method=RequestMethod.GET)
    protected String getAddVaccineRecordPage(HttpServletRequest hsr){
        long id = Long.parseLong(hsr.getParameter("id"));
        String type = hsr.getParameter("type");
        hsr.setAttribute("id", id);
        hsr.setAttribute("type", type);
        return "addVaccineRecord";
    }
   
    
    @RequestMapping(value="/addvaccinerecord.htm", method=RequestMethod.POST)
    protected String doSubmitVaccineRecord(Model model,HttpServletRequest request)throws Exception{
        
        //request.setAttribute("test", "test");
       
        long id = Long.parseLong(request.getParameter("id"));
        String type = request.getParameter("type");
        List<VaccineRecord> vaccineRecordList = vaccineRecordDao.getAllVaccineRecord(id);
        VaccineRecord vaccineRecord = new VaccineRecord();
        
        Long vaccineId = Long.parseLong(request.getParameter("vaccine_id"));
        Date last = java.sql.Date.valueOf(request.getParameter("lastdate"));
        Date next = java.sql.Date.valueOf(request.getParameter("nextdate"));
        
        vaccineRecordList.add(vaccineRecord);
        
    

        vaccineRecord.setLivestockId(id);
        vaccineRecord.setVaccineId(vaccineId);
        vaccineRecord.setLastVaccineDate(last);
        vaccineRecord.setNextVaccineDate(next);
        
        
        //String test = 
        vaccineRecordDao.addVaccineRecord(vaccineRecord);
       // request.setAttribute("test", test);
        model.addAttribute(vaccineRecordList);
        request.setAttribute("type", type);
        request.setAttribute("id", id);
        return "livestockDetail";
    }
}
