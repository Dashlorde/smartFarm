/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;

import com.smartFarm.pojo.AnimalSensor;
import com.smartFarm.pojo.Sensor;
import com.smartFarm.pojo.SensorInfo;
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
public class SensorDao extends DAO{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt;
    
    public void addSensor(Sensor sensor)throws SQLException{
        try{
            conn=getConnection();
            String query="insert into Sensor values (?,?)";
            ps=conn.prepareStatement(query);
            ps.setLong(1, sensor.getSensorId());
            ps.setString(2, sensor.getSensorType());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
        }
    }
    
    public int getSensorId()throws SQLException{
        int id=0;
        try{
            conn=getConnection();
            String query="select max(Sensor_Id) from Sensor";
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
    
    public void addAnimalSensor(AnimalSensor animalSensor)throws SQLException{
        try{
            conn=getConnection();
            String query="insert into AnimalSensor values (?,?)";
            ps=conn.prepareStatement(query);
            ps.setLong(1, animalSensor.getLivestockId());
            ps.setLong(2, animalSensor.getSensorId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
        }
    }
    
    public List<Sensor> getAllSensor()throws SQLException{
        List<Sensor> sensorList=new ArrayList<Sensor>();
        try{
            conn=getConnection();
            String query="select * from Sensor";
            ps=conn.prepareStatement(query);
            
            rs=ps.executeQuery();
            while(rs.next()){
                Sensor c=new Sensor();
                c.setSensorId(rs.getLong("Sensor_Id"));
                c.setSensorType(rs.getString("Sensor_Type"));
                sensorList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            
        }
        
        return sensorList;
    }
    
    public List<SensorInfo> getSensorInfo() throws SQLException{
        List<SensorInfo> list=new ArrayList<>();
        
        try{
            conn=getConnection();
            String query="select Sensor.Sensor_Id, Sensor.Sensor_Type, AnimalSensor.Livestock_Id from Sensor inner join AnimalSensor on Sensor.Sensor_Id=AnimalSensor.Sensor_Id ;";
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            
            while(rs.next()){
                SensorInfo s=new SensorInfo();
                s.setLivestockId(rs.getLong("Livestock_Id"));
                s.setSensorId(rs.getLong("Sensor_Id"));
                s.setSensorType(rs.getString("Sensor_Type"));
                list.add(s);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            
        } return list;
    }
    
    public List<SensorInfo> getSensorInfoBySensorId(long sensorId) throws SQLException{
        List<SensorInfo> list=new ArrayList<>();
        
        try{
            conn=getConnection();
            String query="select Sensor.Sensor_Id, Sensor.Sensor_Type, AnimalSensor.Livestock_Id from Sensor inner join AnimalSensor on Sensor.Sensor_Id=AnimalSensor.Sensor_Id where Sensor.Sensor_Id=?";
            ps=conn.prepareStatement(query);
            ps.setLong(1, sensorId);
            rs=ps.executeQuery();
            
            while(rs.next()){
                SensorInfo s=new SensorInfo();
                s.setLivestockId(rs.getLong("Livestock_Id"));
                s.setSensorId(rs.getLong("Sensor_Id"));
                s.setSensorType(rs.getString("Sensor_Type"));
                list.add(s);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            
        } return list;
    }
    
    
    public List<SensorInfo> getSensorInfoByLivestockId(long LivestockId) throws SQLException{
        List<SensorInfo> list=new ArrayList<>();
        
        try{
            conn=getConnection();
            String query="select Sensor.Sensor_Id, Sensor.Sensor_Type, AnimalSensor.Livestock_Id from Sensor inner join AnimalSensor on Sensor.Sensor_Id=AnimalSensor.Sensor_Id where AnimalSensor.Livestock_Id=?";
            ps=conn.prepareStatement(query);
            ps.setLong(1, LivestockId);
            rs=ps.executeQuery();
            
            while(rs.next()){
                SensorInfo s=new SensorInfo();
                s.setLivestockId(rs.getLong("Livestock_Id"));
                s.setSensorId(rs.getLong("Sensor_Id"));
                s.setSensorType(rs.getString("Sensor_Type"));
                list.add(s);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            
        } return list;
    }
    
    public List<SensorInfo> getSensorInfoBySensorType(String sensorType) throws SQLException{
        List<SensorInfo> list=new ArrayList<>();
        
        try{
            conn=getConnection();
            String query="select Sensor.Sensor_Id, Sensor.Sensor_Type, AnimalSensor.Livestock_Id from Sensor inner join AnimalSensor on Sensor.Sensor_Id=AnimalSensor.Sensor_Id where Sensor.Sensor_Type=?";
            ps=conn.prepareStatement(query);
            ps.setString(1, sensorType);
            rs=ps.executeQuery();
            
            while(rs.next()){
                SensorInfo s=new SensorInfo();
                s.setLivestockId(rs.getLong("Livestock_Id"));
                s.setSensorId(rs.getLong("Sensor_Id"));
                s.setSensorType(rs.getString("Sensor_Type"));
                list.add(s);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            
        } return list;
    }
    
    
}
