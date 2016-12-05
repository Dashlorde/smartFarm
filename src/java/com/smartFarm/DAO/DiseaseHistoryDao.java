/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;

import com.smartFarm.pojo.DiseaseHistory;
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
public class DiseaseHistoryDao extends DAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public void addDiseaseHistory(DiseaseHistory diseaseHistory) throws SQLException {
        try {
            conn = getConnection();
            String query = "insert into Disease_History values(?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            System.out.println(query);

            ps.setLong(1, diseaseHistory.getLivestockId());
            ps.setDate(2, diseaseHistory.getDiagnosisDate());
            ps.setLong(3, diseaseHistory.getDiseaseId());
            ps.setLong(4, diseaseHistory.getDoctorId());
            ps.setString(5, diseaseHistory.getCuredOrNot());

            ps.executeUpdate();
            // return ps.toString();

        } catch (SQLException ex) {
            Logger.getLogger(DiseaseHistoryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();

        }
        // return null;
    }
    
    public List<DiseaseHistory> getSingleDiseaseHistory(Long livestockId) throws SQLException {
        List<DiseaseHistory> diseaseHistoryList = new ArrayList<>();
        try {
            conn = getConnection();

            String query = "select * from Disease_History where Livestock_Id = ?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, livestockId);
            rs = ps.executeQuery();
            while (rs.next()) {
                DiseaseHistory diseaseHistory = new DiseaseHistory();
                diseaseHistory.setLivestockId(rs.getLong("Livestock_Id"));
                diseaseHistory.setDiagnosisDate(rs.getDate("Diagnosis_Date"));
                diseaseHistory.setDiseaseId(rs.getLong("Disease_Id"));
                diseaseHistory.setDoctorId(rs.getLong("Doctor_Id"));
                diseaseHistory.setCuredOrNot(rs.getString("Cured_or_Not"));
                diseaseHistoryList.add(diseaseHistory);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiseaseHistoryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return diseaseHistoryList;

    }

    public List<DiseaseHistory> getAllDiseaseHistory() throws SQLException {
        List<DiseaseHistory> diseaseHistoryList = new ArrayList<>();
        try {
            conn = getConnection();

            String query = "select * from Disease_History";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                DiseaseHistory diseaseHistory = new DiseaseHistory();
                diseaseHistory.setLivestockId(rs.getLong("Livestock_Id"));
                diseaseHistory.setDiagnosisDate(rs.getDate("Diagnosis_Date"));
                diseaseHistory.setDiseaseId(rs.getLong("Disease_Id"));
                diseaseHistory.setDoctorId(rs.getLong("Doctor_Id"));
                diseaseHistory.setCuredOrNot(rs.getString("Cured_or_Not"));
                diseaseHistoryList.add(diseaseHistory);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiseaseHistoryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return diseaseHistoryList;

    }
}
