/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;


import com.smartFarm.pojo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author he.fa
 */
public class EmployeeDao extends DAO{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
   
    
    public void addEmployee(Employee employee) throws SQLException{
        try{
            conn=getConnection();
            String query ="insert into Employee values(?,?,?,?,?)";
            ps=conn.prepareStatement(query);
           
            
            ps.setLong(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getPhone());
            ps.setString(4, employee.getCategory());
            ps.setString(5, employee.getPassword());
            
            ps.executeUpdate();
           // return ps.toString();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
           
        }
       // return null;
    }
    
    public List<Employee> getAllEmployee( )throws SQLException{
        List<Employee> employeeList = new ArrayList<>();
        try{
            conn=getConnection();
            
            String query="select * from Employee";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getLong("Id"));
                employee.setName(rs.getString("Name"));
                employee.setPhone(rs.getString("Phone"));
                employee.setCategory(rs.getString("Category"));
                employee.setPassword(rs.getString("Password"));
                employeeList.add(employee);
            } 
        }catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return employeeList;
            
    }
}
