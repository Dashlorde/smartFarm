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
    
    //----------------------------------modify livestock-----------------------------------------
    
    public int addLivestock(Livestock livestock) throws SQLException{
        int Id=0;
        try{
            conn=getConnection();
            String query ="insert into Livestock (Employee_Id, Age, Weight, Gender, Type) values(?,?,?,?,?)";
            ps=conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setLong(1, livestock.getEmployeeId());
            ps.setInt(2, livestock.getAge());
            ps.setInt(3, livestock.getWeight());
            ps.setString(4, livestock.getGender());
            ps.setString(5, livestock.getType());
            
            int result = ps.executeUpdate();
            if (result > 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                Id = rs.getInt(1);
                return Id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
            rs.close();
        }
        return Id;
    }
    
    public List<Livestock> getAllLivestock( )throws SQLException{
        List<Livestock> livestockList=null;
        try{
            conn=getConnection();
            QueryRunner runner=new QueryRunner();
            ResultSetHandler<List<Livestock>> resultSetHandler=new BeanListHandler<>(Livestock.class);
            String query="select * from Livestock";
            livestockList=runner.query(conn,query, resultSetHandler);
        }catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return livestockList;
            
    }
    
   //------------------------------get cow, 不能直接添加cow, 从livestock添加, addCow method没有用----------------------------------------------
    
    
    public int addCow(Cow cow) throws SQLException{
        int Id=0;
        try{
            conn=getConnection();
            String query ="insert into Cow (EmployeeId, Age, Weight, Gender, Type, Milk_Production, Estrous_Detection) values(?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setLong(1, cow.getEmployeeId());
            ps.setInt(2, cow.getAge());
            ps.setInt(3, cow.getWeight());
            ps.setString(4, cow.getGender());
            ps.setString(5, cow.getType());
            ps.setString(6, cow.getMilkProduction());
            ps.setString(7, cow.getEstrousDetection());
            
            int result = ps.executeUpdate();
            if (result > 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                Id = rs.getInt(1);
                return Id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
            rs.close();
        }
        return Id;
    }
    
    
    public List<Livestock> getAllCow( )throws SQLException{
        List<Livestock> cowList=null;
        try{
            conn=getConnection();
            QueryRunner runner=new QueryRunner();
            ResultSetHandler<List<Livestock>> resultSetHandler=new BeanListHandler<>(Livestock.class);
            String query="select * from Livestock where Type='cow'";
            cowList=runner.query(conn,query, resultSetHandler);
        }catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return cowList;
            
    }
    
    
    //---------------------------------get pig------------------------------------------------
    
    
    public List<Livestock> getAllPig( )throws SQLException{
        List<Livestock> pigList=null;
        try{
            conn=getConnection();
            QueryRunner runner=new QueryRunner();
            ResultSetHandler<List<Livestock>> resultSetHandler=new BeanListHandler<>(Livestock.class);
            String query="select * from Livestock where Type='pig'";
            pigList=runner.query(conn,query, resultSetHandler);
        }catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return pigList;
            
    }
}
