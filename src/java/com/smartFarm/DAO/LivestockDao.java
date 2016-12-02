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
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author zhouyunlu
 */
public class LivestockDao extends DAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
   

    //-----------------------------------------modify livestock-----------------------------------------
    public void addLivestock(Livestock livestock) throws SQLException {
        
        try {
            conn = getConnection();
            String query = "insert into Livestock (Id, Employee_Id, Age, Weight, Gender, Type) values(?,?,?,?,?,?)";
            
            ps = conn.prepareStatement(query);
            ps.setLong(1, livestock.getId());
            ps.setLong(2, livestock.getEmployeeId());
            ps.setInt(3, livestock.getAge());
            ps.setInt(4, livestock.getWeight());
            ps.setString(5, livestock.getGender());
            ps.setString(6, livestock.getType());
 
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();

        }
        
    }

    public List<Livestock> getAllLivestock() throws SQLException {
        List<Livestock> livestockList = new ArrayList<Livestock>();
        try {
            conn = getConnection();
            String query = "select * from Livestock";

            //QueryRunner runner = new QueryRunner();
            ps=conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Livestock c = new Livestock();
                c.setAge(rs.getInt("age"));
                c.setEmployeeId(rs.getLong("Employee_Id"));//Employee_Id
                c.setGender(rs.getString("gender"));
                c.setType(rs.getString("type"));
                c.setId(rs.getLong("id"));
                c.setWeight(rs.getInt("weight"));
                livestockList.add(c);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return livestockList;

    }

    //-----------------------------------------get cow----------------------------------------------
    
    public void addCow(Cow cow) throws SQLException {

        try {
            conn = getConnection();
            String query = "insert into Cow (Id,Employee_Id, Age, Weight, Gender) values(?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setLong(1, cow.getId());
            ps.setLong(2, cow.getEmployeeId());
            ps.setInt(3, cow.getAge());
            ps.setInt(4, cow.getWeight());
            ps.setString(5, cow.getGender());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
        }
    }

    public List<Cow> getAllCow() throws SQLException {
        List<Cow> cowList = new ArrayList<Cow>();
        try {
            conn = getConnection();
            QueryRunner runner = new QueryRunner();
            
            String query = "select * from Cow";
            
            ps=conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
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

    //---------------------------------get pig------------------------------------------------
    public void addPig(Pig pig) throws SQLException {

        try {
            conn = getConnection();
            String query = "insert into Pig (Id, Employee_Id, Age, Weight, Gender) values(?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setLong(1, pig.getId());
            ps.setLong(2, pig.getEmployeeId());
            ps.setInt(3, pig.getAge());
            ps.setInt(4, pig.getWeight());
            ps.setString(5, pig.getGender());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();

        }

    }

    public List<Pig> getAllPig() throws SQLException {
        List<Pig> pigList = new ArrayList<Pig>();
        try {
            conn = getConnection();
            QueryRunner runner = new QueryRunner();
            
            String query = "select * from Pig";
            ps=conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
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
