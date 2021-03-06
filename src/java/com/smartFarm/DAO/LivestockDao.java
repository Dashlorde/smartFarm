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

/**
 *
 * @author zhouyunlu
 */
public class LivestockDao extends DAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt;

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
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
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
    public Livestock getLivestockById(long id) throws SQLException {
        Livestock livestock = new Livestock();

        try {
            conn = getConnection();

            String query = "select * from Livestock where Id=?";

            ps = conn.prepareStatement(query);
            ps.setLong(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
               
                livestock.setId(rs.getLong("Id"));
                livestock.setEmployeeId(rs.getLong("Employee_Id"));
                livestock.setAge(rs.getInt("Age"));
                livestock.setWeight(rs.getInt("Weight"));
                livestock.setGender(rs.getString("Gender"));
                livestock.setType(rs.getString(""));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
            close(conn);
        }

        return livestock;

    }

    //-----------------------------------------get cow----------------------------------------------
    public void addCow(Cow cow) throws SQLException {

        try {
            conn = getConnection();
            String query = "insert into Cow values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setLong(1, cow.getId());
            ps.setLong(2, cow.getEmployeeId());
            ps.setInt(3, cow.getAge());
            ps.setInt(4, cow.getWeight());
            ps.setString(5, cow.getGender());
            ps.setString(6, cow.getMilkProduction());
            //ps.setString(7, cow.getEstrousDetection());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
        }
    }
    
    public int getCowId()throws SQLException{
        int id=1000;
        try{
            conn=getConnection();
            String query="select max(Id) from Cow";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(query);
            rs.next();
            id=rs.getInt(1);
            id++;
            return id;
            
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return id;
    }

    public List<Cow> getAllCow() throws SQLException {
        List<Cow> cowList = new ArrayList<Cow>();
        try {
            conn = getConnection();
            //QueryRunner runner = new QueryRunner();

            String query = "select * from Cow";
            ps = conn.prepareStatement(query);
            //stmt = conn.createStatement();
            //rs = stmt.executeQuery(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cow c = new Cow();
                c.setAge(rs.getInt("age"));
                c.setEmployeeId(rs.getLong("Employee_Id"));
                c.setGender(rs.getString("gender"));
                c.setId(rs.getLong("id"));
                c.setWeight(rs.getInt("weight"));
                c.setMilkProduction(rs.getString("Milk_Production"));
                
                cowList.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //rs.close();
            close(conn);
        }

        return cowList;

    }

    public List<Cow> getCowById(long id) throws SQLException {
        List<Cow> cowList = new ArrayList<Cow>();

        try {
            conn = getConnection();

            String query = "select * from Cow where Id=?";

            ps = conn.prepareStatement(query);
            ps.setLong(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cow c = new Cow();
                c.setId(rs.getLong("Id"));
                c.setEmployeeId(rs.getLong("Employee_Id"));
                c.setAge(rs.getInt("Age"));
                c.setWeight(rs.getInt("Weight"));
                c.setGender(rs.getString("Gender"));
                c.setMilkProduction(rs.getString("Milk_Production"));
                
                cowList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
            close(conn);
        }

        return cowList;

    }
    
    public Cow getSingleCowById(long id) throws SQLException {
       Cow c = new Cow();

        try {
            conn = getConnection();

            String query = "select * from Cow where Id=?";

            ps = conn.prepareStatement(query);
            ps.setLong(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
              
                c.setId(rs.getLong("Id"));
                c.setEmployeeId(rs.getLong("Employee_Id"));
                c.setAge(rs.getInt("Age"));
                c.setWeight(rs.getInt("Weight"));
                c.setGender(rs.getString("Gender"));
                c.setMilkProduction(rs.getString("Milk_Production"));
                
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
            close(conn);
        }

        return c;

    }

    public List<Cow> getCowByEmployeeId(long id) throws SQLException {
        List<Cow> cowList = new ArrayList<Cow>();
        try {
            conn = getConnection();

            String query = "select * from Cow where Employee_Id=?";

            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cow c = new Cow();
                 c.setId(rs.getLong("Id"));
                c.setEmployeeId(rs.getLong("Employee_Id"));
                c.setAge(rs.getInt("Age"));
                c.setWeight(rs.getInt("Weight"));
                c.setGender(rs.getString("Gender"));
                c.setMilkProduction(rs.getString("Milk_Production"));
                
                cowList.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
            close(conn);
        }

        return cowList;

    }

    public List<Cow> getCowByAge(int age) throws SQLException {
        List<Cow> cowList = new ArrayList<Cow>();
        try {
            conn = getConnection();

            String query = "select * from Cow where Age=?";

            ps = conn.prepareStatement(query);
            ps.setLong(1, age);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cow c = new Cow();
                c.setId(rs.getLong("Id"));
                c.setEmployeeId(rs.getLong("Employee_Id"));
                c.setAge(rs.getInt("Age"));
                c.setWeight(rs.getInt("Weight"));
                c.setGender(rs.getString("Gender"));
                c.setMilkProduction(rs.getString("Milk_Production"));
               
                cowList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            rs.close();

        }

        return cowList;

    }

    public void updateCowEmployeeId(long id, long employeeId) throws SQLException {
        try {
            conn = getConnection();
            String query = "update Cow set Employee_Id = ? where Id = ?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, employeeId);
            ps.setLong(2, id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            close(conn);
        }
    }

    public void updateCowWeight(long id, int weight) throws SQLException {
        try {
            conn = getConnection();

            String query = "update Cow set Weight = ? where Id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, weight);
            ps.setLong(2, id);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ps.close();

        }
    }

    //---------------------------------get pig------------------------------------------------
    public void addPig(Pig pig) throws SQLException {

        try {
            conn = getConnection();
            String query = "insert into Pig  values(?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setLong(1, pig.getId());
            ps.setLong(2, pig.getEmployeeId());
            ps.setInt(3, pig.getAge());
            ps.setInt(4, pig.getWeight());
            ps.setString(5, pig.getGender());
            //ps.setString(6, pig.getEstrousDetection());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();

        }

    }
    
    
    public int getPigId()throws SQLException{
        int id=100;
        try{
            conn=getConnection();
            String query="select max(Id) from Pig";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(query);
            rs.next();
            id=rs.getInt(1);
            id++;
            return id;
            
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return id;
    }

    public List<Pig> getAllPig() throws SQLException {
        List<Pig> pigList = new ArrayList<Pig>();
        try {
            conn = getConnection();
            QueryRunner runner = new QueryRunner();

            String query = "select * from Pig";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
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

    public List<Pig> getPigById(long id) throws SQLException {
        List<Pig> pigList = new ArrayList<Pig>();
        try {
            conn = getConnection();

            String query = "select * from Pig where Id=?";

            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pig p = new Pig();
                p.setId(rs.getLong("Id"));
                p.setEmployeeId(rs.getLong("Employee_Id"));
                p.setAge(rs.getInt("Age"));
                p.setWeight(rs.getInt("Weight"));
                p.setGender(rs.getString("Gender"));
                
                pigList.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return pigList;

    }
    public Pig getSiglePigById(long id) throws SQLException {
        Pig p = new Pig();
        try {
            conn = getConnection();

            String query = "select * from Pig where Id=?";

            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
               
                p.setId(rs.getLong("Id"));
                p.setEmployeeId(rs.getLong("Employee_Id"));
                p.setAge(rs.getInt("Age"));
                p.setWeight(rs.getInt("Weight"));
                p.setGender(rs.getString("Gender"));
               

            }

        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return p;

    }

    public List<Pig> getPigByEmployeeId(long id) throws SQLException {
        List<Pig> pigList = new ArrayList<Pig>();
        try {
            conn = getConnection();

            String query = "select * from Pig where Employee_Id=?";

            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pig p = new Pig();
                p.setId(rs.getLong("Id"));
                p.setEmployeeId(rs.getLong("Employee_Id"));
                p.setAge(rs.getInt("Age"));
                p.setWeight(rs.getInt("Weight"));
                p.setGender(rs.getString("Gender"));
                
                pigList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return pigList;

    }

    public List<Pig> getPigByAge(int age) throws SQLException {
        List<Pig> pigList = new ArrayList<Pig>();
        try {
            conn = getConnection();

            String query = "select * from Pig where Age=?";

            ps = conn.prepareStatement(query);
            ps.setLong(1, age);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pig p = new Pig();
                p.setId(rs.getLong("Id"));
                p.setEmployeeId(rs.getLong("Employee_Id"));
                p.setAge(rs.getInt("Age"));
                p.setWeight(rs.getInt("Weight"));
                p.setGender(rs.getString("Gender"));
                
                pigList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return pigList;

    }

    public void updatePigEmployeeId(long id, long employeeId) throws SQLException {
        try {
            conn = getConnection();
            String query = "update Pig set Employee_Id=? where Id=?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, employeeId);
            ps.setLong(2, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
    }

    public void updatePigWeight(long id, int weight) throws SQLException {
        try {
            conn = getConnection();
            String query = "update Pig set Weight=? where Id=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, weight);
            ps.setLong(2, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
    }
}
