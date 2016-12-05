/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;

import com.smartFarm.pojo.AnimalSensor;
import com.smartFarm.pojo.Sensor;
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
    
    public void addAnimalSensor(AnimalSensor animalSensor)throws SQLException{
        try{
            conn=getConnection();
            String query="insert into Animal_Sensor values (?,?)";
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
    
}
