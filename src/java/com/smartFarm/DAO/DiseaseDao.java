/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;

import com.smartFarm.pojo.Disease;
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
public class DiseaseDao extends DAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    public void addDisease(Disease disease) throws SQLException {
        try {
            conn = getConnection();
            String query = "insert into Disease values(?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            System.out.println(query);

            ps.setLong(1, disease.getId());
            ps.setString(2, disease.getName());
            ps.setString(3, disease.getDescription());
            ps.setString(4, disease.getCure());
            ps.setString(5, disease.getRegion());
           

            ps.executeUpdate();
            // return ps.toString();

        } catch (SQLException ex) {
            Logger.getLogger(DiseaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();

        }
        // return null;
    }

    public List<Disease> getAllDisease( )throws SQLException{
        List<Disease> diseaseList = new ArrayList<>();
        try{
            conn=getConnection();
            
            String query="select * from Disease";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Disease disease = new Disease();
                disease.setId(rs.getLong("Id"));
                disease.setName(rs.getString("Name"));
                disease.setDescription(rs.getString("Description"));
                disease.setCure(rs.getString("Cure"));
                disease.setRegion(rs.getString("Region"));
                diseaseList.add(disease);
            } 
        }catch (SQLException ex) {
            Logger.getLogger(DiseaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return diseaseList;
            
    }
    
    public Disease getDiseaseById(long id) throws SQLException {
        Disease disease = new Disease();

        try {
            conn = getConnection();

            String query = "select * from Disease where Id=?";

            ps = conn.prepareStatement(query);
            ps.setLong(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
               
                disease.setId(rs.getLong("Id"));
                disease.setName(rs.getString("Name"));
                disease.setDescription(rs.getString("Description"));
                disease.setCure(rs.getString("Cure"));
                disease.setRegion(rs.getString("Region"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiseaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
            close(conn);
        }

        return disease;

    }
}
