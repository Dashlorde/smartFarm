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
    
    @Autowired
    EmployeeDao employeeDao=new EmployeeDao();
    
    @RequestMapping(value="/manageemployee.htm", method=RequestMethod.GET)
    public String handleRequest(Model model,HttpServletRequest hsr) throws Exception{
        List<Employee> employeeList;
        employeeList = employeeDao.getAllEmployee();
        for(Employee employee: employeeList){
            System.out.println(employee.getId()+" "+employee.getName());
        }
        model.addAttribute(employeeList);
        return "manageEmployee";
        
    }
    
    @RequestMapping(value="/addemployee.htm", method=RequestMethod.GET)
    protected String getAddLivestockPage(){
        return "addEmployee";
    }
    
    @RequestMapping(value="/addemployee.htm", method=RequestMethod.POST)
    protected String doSubmitLivestock(HttpServletRequest request)throws Exception{
        Employee employee = new Employee();
        
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String category = request.getParameter("category");
        
        
        employee.setName(name);
        employee.setPhone(phone);
        employee.setCategory(category);
        
        int id = employeeDao.addEmployee(employee);
        
        return "redirect://manageEmployee.htm";
    }
    
}
