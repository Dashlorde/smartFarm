/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;


import com.smartFarm.DAO.EmployeeDao;
import com.smartFarm.pojo.Employee;
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
public class EmployeeController {
    
    private static long count = 10000;
    
    private List<Employee> employeeList;
    @Autowired
    EmployeeDao employeeDao = new EmployeeDao();
    
    @RequestMapping(value="/manageemployee.htm", method=RequestMethod.GET)
    public String handleRequest(Model model,HttpServletRequest hsr) throws Exception{
        employeeList = employeeDao.getAllEmployee();
        model.addAttribute(employeeList);
        //hsr.setAttribute("test", "get method");
        return "manageEmployee";
        
    }
    
    @RequestMapping(value="/addemployee.htm", method=RequestMethod.GET)
    protected String getAddEmployeePage(){
        return "addEmployee";
    }
    
    @RequestMapping(value="/addemployee.htm", method=RequestMethod.POST)
    protected String doSubmitEmployee(Model model,HttpServletRequest request)throws Exception{
        count = 10000 + employeeList.size();
        
        Employee employee = new Employee();
        
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String category = request.getParameter("category");
        String password = request.getParameter("password");
        
        employeeList.add(employee);
        
        long id = count++;
        employee.setId(id);
        employee.setName(name);
        employee.setPhone(phone);
        employee.setCategory(category);
        employee.setPassword(password);
        //String q = 
        employeeDao.addEmployee(employee);
        //request.setAttribute("test", "post method");
        model.addAttribute(employeeList);
        return "manageEmployee";
    }
    
}
