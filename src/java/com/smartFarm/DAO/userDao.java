/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;

import com.smartFarm.pojo.Doctor;
import com.smartFarm.pojo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhouyunlu
 */
public class userDao extends DAO{
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public Doctor verifyDoctor(String name, String pwd) throws SQLException{
        try{
            conn=getConnection();
            String query="select * from Doctor where Name= ? and Password= ?";
            ps=conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while(rs.next()){
                Doctor doc=new Doctor();
                doc.setId(rs.getInt("Id"));
                doc.setName(rs.getString("Name"));
                doc.setPhone(rs.getString("Phone"));
                doc.setSpeciaty(rs.getString("Speciaty"));
                doc.setPassword(rs.getString("Password"));
                
                
                return doc;
            }
        }catch(SQLException ex){
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close(conn);
            rs.close();
            ps.close();
        }
        return null;
    }
    
    public Doctor getDoctor(String name, long id)throws SQLException{
        try{
            conn=getConnection();
            String query="select * from Doctor where Name= ? and Id= ?";
            ps=conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setLong(2, id);
            rs=ps.executeQuery();
            while(rs.next()){
                Doctor doc=new Doctor();
                doc.setId(rs.getInt("Id"));
                doc.setName(rs.getString("Name"));
                doc.setPhone(rs.getString("Phone"));
                doc.setSpeciaty(rs.getString("Speciaty"));
                doc.setPassword(rs.getString("Password"));
                
                
                return doc;
            }
        }catch(SQLException ex){
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close(conn);
            rs.close();
            ps.close();
        }
        return null;
        }
    
    
    public Employee verifyEmployee(String name, String pwd) throws SQLException{
        try{
            conn=getConnection();
            String query="select * from Employee where Name= ? and Password= ?";
            ps=conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while(rs.next()){
                Employee e=new Employee();
                e.setId(rs.getInt("Id"));
                e.setCategory(rs.getString("Category"));
                e.setName(rs.getString("Name"));
                e.setPhone(rs.getString("Phone"));
                e.setPassword(rs.getString("Password"));
                
                
                return e;
            }
        }catch(SQLException ex){
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close(conn);
            rs.close();
            ps.close();
        }
        return null;
    }
    
    public Employee getEmployee(String name, long id) throws SQLException{
        try{
            conn=getConnection();
            String query="select * from Employee where Name= ? and Id= ?";
            ps=conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setLong(2, id);
            rs = ps.executeQuery();
            while(rs.next()){
                Employee e=new Employee();
                e.setId(rs.getInt("Id"));
                e.setCategory(rs.getString("Category"));
                e.setName(rs.getString("Name"));
                e.setPhone(rs.getString("Phone"));
                e.setPassword(rs.getString("Password"));
                
                
                return e;
            }
        }catch(SQLException ex){
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close(conn);
            rs.close();
            ps.close();
        }
        return null;
    }
}
