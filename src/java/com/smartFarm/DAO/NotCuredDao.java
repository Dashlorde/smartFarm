/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;

import com.smartFarm.pojo.Cow;
import com.smartFarm.pojo.Livestock;
import com.smartFarm.pojo.Pig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhouyunlu
 */
public class NotCuredDao extends DAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt;
    
    public List<Livestock> getLivestockNotCured() throws SQLException{
        List<Livestock> livestockList=new ArrayList<>();
        try{
          
            conn=getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("{call getLivestockNotCured}");
            while (rs.next()){
                Livestock l=new Livestock();
                
                l.setAge(rs.getInt("Age"));
                l.setEmployeeId(rs.getLong("Employee_Id"));
                l.setGender(rs.getString("Gender"));
                l.setId(rs.getLong("Id"));
                l.setWeight(rs.getInt("Weight"));
                livestockList.add(l);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            close(conn);
        } 
        return livestockList;
    } 
    
    
    public List<Cow> getCowNotCured() throws SQLException{
        List<Cow> cowList=new ArrayList<>();
        try{
          
            conn=getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("{call getCowNotCured}");
            while (rs.next()){
                Cow c = new Cow();
                c.setAge(rs.getInt("age"));
                c.setEmployeeId(rs.getLong("Employee_Id"));
                c.setGender(rs.getString("gender"));
                c.setId(rs.getLong("id"));
                c.setWeight(rs.getInt("weight"));
                cowList.add(c);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            close(conn);
        } 
        return cowList;
    }
    
    public List<Pig> getPigNotCured() throws SQLException{
        List<Pig> pigList=new ArrayList<>();
        try{
          
            conn=getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("{call getPigNotCured}");
            while (rs.next()){
                Pig p = new Pig();
                p.setAge(rs.getInt("age"));
                p.setEmployeeId(rs.getLong("Employee_Id"));
                p.setGender(rs.getString("gender"));
                p.setId(rs.getLong("id"));
                p.setWeight(rs.getInt("weight"));
                pigList.add(p);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            close(conn);
        } 
        return pigList;
    }
    
    
}
