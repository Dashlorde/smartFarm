/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;


import com.smartFarm.pojo.FeedRecord;
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
public class FeedRecordDao extends DAO{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public void addFeedRecord(FeedRecord feedRecord) throws SQLException{
        try{
            conn=getConnection();
            String query ="insert into Feed_Record values(?,?,?,?)";
            ps=conn.prepareStatement(query);
           
            ps.setLong(1, feedRecord.getLivestockId());
            ps.setTimestamp(2, feedRecord.getTime());
            ps.setBigDecimal(3, feedRecord.getQuantity());
            ps.setString(4, feedRecord.getFeed());
            
            
            ps.executeUpdate();
            //return ps.toString();
            
        } catch (SQLException ex) {
            Logger.getLogger(FeedRecordDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
           
        }
       //return "not save";
    }
    
    public List<FeedRecord> getAllFeedRecord(long livestockId )throws SQLException{
        List<FeedRecord> feedRecordList = new ArrayList<>();
        try{
            conn=getConnection();
            
            String query="select * from Feed_Record where Livestock_Id = ?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, livestockId);
            rs = ps.executeQuery();
            while (rs.next()){
                FeedRecord feedRecord = new FeedRecord();
                feedRecord.setLivestockId(rs.getLong("Livestock_Id"));
                feedRecord.setTime(rs.getTimestamp("Time"));
                feedRecord.setQuantity(rs.getBigDecimal("Quantity"));
                feedRecord.setFeed(rs.getString("Feed"));
                feedRecordList.add(feedRecord);
            } 
        }catch (SQLException ex) {
            Logger.getLogger(FeedRecordDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return feedRecordList;
            
    }
}
