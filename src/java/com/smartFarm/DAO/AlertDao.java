/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;


import com.smartFarm.pojo.Alert;
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
public class AlertDao extends DAO{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Alert> getAllAlert( )throws SQLException{
        List<Alert> alertList = new ArrayList<>();
        try{
            conn=getConnection();
            
            String query="{call getAlertResult}";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Alert alert = new Alert();
                alert.setSensorId(rs.getLong("Sensor_Id"));
                alert.setTime(rs.getTimestamp("Time"));
                alert.setPossibleEvent(rs.getString("Possible_Event"));
                alert.setSensorType(rs.getString("Sensor_Type"));
                alert.setLivestockId(rs.getLong("Livestock_Id"));
                alertList.add(alert);
            } 
        }catch (SQLException ex) {
            Logger.getLogger(AlertDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return alertList;
            
    }
}
