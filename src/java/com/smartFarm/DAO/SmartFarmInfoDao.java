/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;

import com.smartFarm.pojo.Cow;
import com.smartFarm.pojo.Pig;
import java.sql.CallableStatement;
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
public class SmartFarmInfoDao extends DAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt;
    CallableStatement clbstmt;
    
    public int getCowNumber() throws SQLException{
        int num =-1;
        try{
            conn=getConnection();
            String query="select COUNT(*) from Cow";
            stmt=conn.createStatement();
             rs=stmt.executeQuery(query);
             rs.next();
            
             num=rs.getInt(1);
             System.out.println("total cow number is "+num);
             
             return num;
             
             
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            //ps.close();

        }
        
        return num;
    }
    
    
    public int getPigNumber() throws SQLException{
        int num=-1;
        try{
            conn=getConnection();
            String query="select COUNT(*) from Pig";
            stmt=conn.createStatement();
             rs=stmt.executeQuery(query);
             rs.next();
             num=rs.getInt(1);
             return num;
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            //ps.close();

        }
        return num;
    }
    
    public int getAverageAge() throws SQLException{
        int num=0;
        try{
            conn=getConnection();
            String query="SELECT AVG(Age) FROM Livestock";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(query);
            rs.next();

            num=rs.getInt(1);
            return num;

        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            //ps.close();

        }
        return num;
    }
    
    public List<Cow> getYoungestCow() throws SQLException{
        List<Cow> youngCowList=new ArrayList<>();
        try{
            conn=getConnection();
            String query="select * from Cow where Age= (select MIN(Age) from Cow)";
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                Cow c=new Cow();
                c.setAge(rs.getInt("age"));
                c.setEmployeeId(rs.getLong("Employee_Id"));//Employee_Id
                c.setGender(rs.getString("gender"));                
                c.setId(rs.getLong("id"));
                c.setWeight(rs.getInt("weight"));
                youngCowList.add(c);
                
            }
            
        }  catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();

        }
        return youngCowList;   
    }
    
    public List<Cow> getoldestCow() throws SQLException{
        List<Cow> oldCowList=new ArrayList<>();
        try{
            conn=getConnection();
            String query="select * from Cow where Age= (select Max(Age) from Cow)";
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                Cow c=new Cow();
                c.setAge(rs.getInt("age"));
                c.setEmployeeId(rs.getLong("Employee_Id"));//Employee_Id
                c.setGender(rs.getString("gender"));                
                c.setId(rs.getLong("id"));
                c.setWeight(rs.getInt("weight"));
                oldCowList.add(c);
            }
            
        }  catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();

        }
        return oldCowList;   
    }
    
    public List<Pig> getYoungestPig() throws SQLException{
        List<Pig> youngPigList=new ArrayList<>();
        try{
            conn=getConnection();
            String query="select * from Pig where Age= (select MIN(Age) from Pig)";
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                Pig p=new Pig();
                p.setAge(rs.getInt("age"));
                p.setEmployeeId(rs.getLong("Employee_Id"));
                p.setGender(rs.getString("gender"));                
                p.setId(rs.getLong("id"));
                p.setWeight(rs.getInt("weight"));
                youngPigList.add(p);
            }
            
        }  catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();

        }
        return youngPigList;   
    }
    
    
    public List<Pig> getOldestPig() throws SQLException{
        List<Pig> oldPigList=new ArrayList<>();
        try{
            conn=getConnection();
            String query="select * from Pig where Age= (select MAX(Age) from Pig)";
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                Pig p=new Pig();
                p.setAge(rs.getInt("age"));
                p.setEmployeeId(rs.getLong("Employee_Id"));
                p.setGender(rs.getString("gender"));                
                p.setId(rs.getLong("id"));
                p.setWeight(rs.getInt("weight"));
                oldPigList.add(p);
            }
            
        }  catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();

        }
        return oldPigList;   
    }
}
