/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;


import com.smartFarm.pojo.Quarantine;
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
public class QuarantineDao extends DAO{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public void addQuarantine(Quarantine quarantine) throws SQLException{
        try{
            conn=getConnection();
            String query ="insert into Quarantine values(?,?,?,?,?)";
            ps=conn.prepareStatement(query);
            ps.setDate(1, quarantine.getTime());
            ps.setLong(2, quarantine.getLivestockId());
            ps.setString(3, quarantine.getEpidemic());
            ps.setString(4, quarantine.getLocation());
            ps.setString(5, quarantine.getStatus());
            
            
            ps.executeUpdate();
            //return ps.toString();
            
        } catch (SQLException ex) {
            Logger.getLogger(QuarantineDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
           
        }
       //return "not save";
    }
    
    public List<Quarantine> getAllQuarantine(long livestockId )throws SQLException{
        List<Quarantine> quarantineList = new ArrayList<>();
        try{
            conn=getConnection();
            
            String query="select * from Quarantine where Livestock_Id = ?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, livestockId);
            rs = ps.executeQuery();
            while (rs.next()){
                Quarantine quarantine = new Quarantine();
                quarantine.setTime(rs.getDate("Time"));
                quarantine.setLivestockId(rs.getLong("Livestock_Id"));
                quarantine.setEpidemic(rs.getString("Epidemic"));
                quarantine.setLocation(rs.getString("Location"));
                quarantine.setStatus(rs.getString("Status"));
                quarantineList.add(quarantine);
            } 
        }catch (SQLException ex) {
            Logger.getLogger(QuarantineDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return quarantineList;
            
    }
}
