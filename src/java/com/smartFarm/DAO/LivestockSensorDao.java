/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;


import com.smartFarm.pojo.LivestockSensor;
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
 * @author he.fa
 */
public class LivestockSensorDao extends DAO{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt;
    
    public List<LivestockSensor> getAllTempSenorResult() throws SQLException{
        List<LivestockSensor> livestockSensorList=new ArrayList<>();
        try{
          
            conn=getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("{call getTempSensorResult}");
            while (rs.next()){
                LivestockSensor livestockSensor=new LivestockSensor();
                
                livestockSensor.setLivestockId(rs.getLong("Livestock_Id"));
                livestockSensor.setRead(rs.getDouble("Ts_Read"));
                livestockSensor.setSensorId(rs.getInt("Sensor_Id"));
                livestockSensor.setSensorType(rs.getString("Sensor_Type"));
                livestockSensor.setTime(rs.getTimestamp("Ts_Time"));
                livestockSensorList.add(livestockSensor);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(LivestockSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            close(conn);
        } 
        return livestockSensorList;
    } 
    
    public List<LivestockSensor> getSingleTempSenorResult(int livestockId) throws SQLException{
        List<LivestockSensor> livestockSensorList=new ArrayList<>();
        try{
          
            conn=getConnection();
            ps = conn.prepareStatement("{call getTempSensorResultByLivestockId(?)}");
            ps.setInt(1, livestockId);
            rs = ps.executeQuery();
            while (rs.next()){
                LivestockSensor livestockSensor=new LivestockSensor();
                
                livestockSensor.setLivestockId(rs.getLong("Livestock_Id"));
                livestockSensor.setRead(rs.getDouble("Ts_Read"));
                livestockSensor.setSensorId(rs.getInt("Sensor_Id"));
                livestockSensor.setSensorType(rs.getString("Sensor_Type"));
                livestockSensor.setTime(rs.getTimestamp("Ts_Time"));
                livestockSensorList.add(livestockSensor);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(LivestockSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            close(conn);
        } 
        return livestockSensorList;
    } 
    
}
