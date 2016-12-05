/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;


import com.smartFarm.DAO.UserDao;
import com.smartFarm.pojo.Doctor;
import com.smartFarm.pojo.Employee;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/login.htm")
public class LoginController {
    
    @Autowired


    UserDao userDao = new UserDao();

 

    

   

    
    @RequestMapping(method=RequestMethod.GET)
    protected String getLoginPage(){
        return "login";
    }
    
    @RequestMapping(value="/adminManagement.htm", method=RequestMethod.GET)
    public String handleRequest(HttpServletRequest hsr) throws Exception{
         return "adminManagement";
        
    }
    
    
    
    @RequestMapping(method=RequestMethod.POST)
    protected String login(HttpServletRequest request, Model model) throws Exception{
        HttpSession session=request.getSession();
        String character=request.getParameter("character");
        String name=request.getParameter("username");
        System.out.println(name);
        
        String password=request.getParameter("password");
        System.out.println(password);
            
        
        if(character.equals("doctor")){
            
            Doctor doctor=userDao.verifyDoctor(name, password);
            if (doctor != null) {
                session.setAttribute("Id", doctor.getId());
                session.setAttribute("Name", doctor.getName());
                //session.setAttribute("doctor", doctor);
                session.setAttribute("userType", "doctor");

                //return "redirect:/showAllCow.htm";
                return "redirect:/managediseasehistory.htm";
                
            }
            
            else{
                model.addAttribute("error","Invalid username or password!");
                
                return "login";
            }            
        }
        
       
        if(character.equals("employee")){
            Employee employee=userDao.verifyEmployee(name, password);
            if(employee!=null){
                session.setAttribute("Id", employee.getId());
                session.setAttribute("Name", employee.getName()); 
                //session.setAttribute("employee", employee);
                session.setAttribute("userType", "employee");
                return "redirect:/showAllCow.htm";
            }
            
            else{
                model.addAttribute("error","Invalid username or password!");
                
                return "login";
            }
            
        }
        
        return "login";
    }

    
    
    
}
