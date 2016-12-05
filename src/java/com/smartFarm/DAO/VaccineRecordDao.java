/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;


import com.smartFarm.pojo.VaccineRecord;
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
public class VaccineRecordDao extends DAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public void addVaccineRecord(VaccineRecord vaccineRecord) throws SQLException{
        try{
            conn=getConnection();
            String query ="insert into Vaccine_Record values(?,?,?,?)";
            ps=conn.prepareStatement(query);
           
            ps.setLong(1, vaccineRecord.getVaccineId());
            ps.setLong(2, vaccineRecord.getLivestockId());
            ps.setDate(3, vaccineRecord.getLastVaccineDate());
            ps.setDate(4, vaccineRecord.getNextVaccineDate());
            
            
            ps.executeUpdate();
            //return ps.toString();
            
        } catch (SQLException ex) {
            Logger.getLogger(VaccineRecordDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
           
        }
       //return "not save";
    }
    
    public List<VaccineRecord> getAllVaccineRecord(long livestockId )throws SQLException{
        List<VaccineRecord> vaccineRecordList = new ArrayList<>();
        try{
            conn=getConnection();
            
            String query="select * from Vaccine_Record where Livestock_Id = ?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, livestockId);
            rs = ps.executeQuery();
            while (rs.next()){
                VaccineRecord vaccineRecord = new VaccineRecord();
                vaccineRecord.setVaccineId(rs.getLong("Vaccine_Id"));
                vaccineRecord.setLivestockId(rs.getLong("Livestock_Id"));
                vaccineRecord.setLastVaccineDate(rs.getDate("Last_Vaccine_Date"));
                vaccineRecord.setNextVaccineDate(rs.getDate("Next_Vaccine_Date"));
                vaccineRecordList.add(vaccineRecord);
            } 
        }catch (SQLException ex) {
            Logger.getLogger(VaccineRecordDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return vaccineRecordList;
            
    }
}
