/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.DoctorDao;
import com.smartFarm.pojo.Doctor;
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
public class DoctorController {
    
    private static long count = 10000;
    List<Doctor> doctorList;

    @Autowired
    DoctorDao doctorDao = new DoctorDao();

    @RequestMapping(value = "/managedoctor.htm", method = RequestMethod.GET)
    public String handleRequest(Model model, HttpServletRequest hsr) throws Exception {
        //List<Doctor> doctorList;
        doctorList = doctorDao.getAllDoctor();
        model.addAttribute(doctorList);
        return "manageDoctor";

    }

    @RequestMapping(value = "/adddoctor.htm", method = RequestMethod.GET)
    protected String getAddDoctorPage() {
        return "addDoctor";
    }

    @RequestMapping(value = "/adddoctor.htm", method = RequestMethod.POST)
    protected String doSubmitDoctor(Model model, HttpServletRequest request) throws Exception {
        count = 10000 + doctorList.size();
        
        Doctor doctor = new Doctor();

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String speciaty = request.getParameter("speciaty");
        String password = request.getParameter("password");
        long id = count++;

        doctor.setId(id);
        doctor.setName(name);
        doctor.setPhone(phone);
        doctor.setSpeciaty(speciaty);
        doctor.setPassword(password);

        doctorDao.addDoctor(doctor);
        doctorList.add(doctor);
        //List<Doctor> doctorList;
        //doctorList = doctorDao.getAllDoctor();
        model.addAttribute(doctorList);
        return "manageDoctor";
    }

}
