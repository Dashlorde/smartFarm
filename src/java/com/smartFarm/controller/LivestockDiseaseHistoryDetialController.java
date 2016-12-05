/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.DiseaseDao;
import com.smartFarm.DAO.LivestockDao;
import com.smartFarm.pojo.Cow;
import com.smartFarm.pojo.Disease;
import com.smartFarm.pojo.Livestock;
import com.smartFarm.pojo.Pig;
import java.sql.SQLException;
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
public class LivestockDiseaseHistoryDetialController {
    
    @Autowired
    LivestockDao livestockDao = new LivestockDao();
    
    @Autowired
    DiseaseDao diseaseDao = new DiseaseDao();
    
    @RequestMapping(value="/doctorseelivestockdiseasedetail.htm",method=RequestMethod.GET )
    protected String DoctorGetLivestock(HttpServletRequest request, Model model) throws SQLException{
        Long livestockId = Long.parseLong(request.getParameter("livestock_id"));
        Long diseaseId = Long.parseLong(request.getParameter("disease_id"));
        
        Livestock livestock = livestockDao.getLivestockById(livestockId);
        if(livestock.getGender().equals("cow")){
            Cow cow = (Cow) livestockDao.getSingleCowById(livestockId);
            model.addAttribute(cow);
            model.addAttribute("type","cow");
        }else{
            Pig pig = (Pig) livestockDao.getSiglePigById(livestockId);
            model.addAttribute(pig);
            model.addAttribute("type", "pig");
        }
        
        Disease disease = diseaseDao.getDiseaseById(diseaseId);
        model.addAttribute(disease);
        
        return "doctorSeeLivestock";
                
    }
    
}
