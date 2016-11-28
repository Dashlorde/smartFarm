/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;


import com.smartFarm.DAO.userDao;
import com.smartFarm.pojo.Doctor;
import com.smartFarm.pojo.Employee;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zhouyunlu
 */
@Controller
@RequestMapping("/login.htm")
public class loginController {
    
    @Autowired
    userDao userDao;
    
    protected String login(HttpServletRequest request, Model model) throws Exception{
        HttpSession session=request.getSession();
        String character=request.getParameter("character");
        String name=request.getParameter("username");
        String password=request.getParameter("password");
            
        
        if(character.equals("doctor")){
            
            Doctor doc=userDao.verifyDoctor(name, password);
            if(doc!=null){
                session.setAttribute("Id", doc.getId());
                session.setAttribute("Name", doc.getName());
                
                return "index";
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
                
                return "index";
            }
            
            else{
                model.addAttribute("error","Invalid username or password!");
                return "login";
            }
            
        }
        
        return "index";
    }
}
