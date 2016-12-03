/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;


import com.smartFarm.pojo.Doctor;
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
public class DoctorDao extends DAO{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public void addDoctor(Doctor dorcor) throws SQLException{
       
        try{
            conn=getConnection();
            String query ="insert into Doctor values(?,?,?,?,?)";
            ps=conn.prepareStatement(query);
            
            ps.setLong(1, dorcor.getId());
            ps.setString(2, dorcor.getName());
            ps.setString(3, dorcor.getPhone());
            ps.setString(4, dorcor.getSpeciaty());
            ps.setString(5, dorcor.getPassword());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
           
        }
        
    }
    
    public List<Doctor> getAllDoctor( )throws SQLException{
        List<Doctor> doctorList = new ArrayList<>();
        try{
            conn=getConnection();
            
            String query="select * from Doctor";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Doctor doctor = new Doctor();
                doctor.setId(rs.getLong("Id"));
                doctor.setName(rs.getString("Name"));
                doctor.setPhone(rs.getString("Phone"));
                doctor.setSpeciaty(rs.getString("Speciaty"));
                doctor.setPassword(rs.getString("Password"));
                doctorList.add(doctor);
            } 
        }catch (SQLException ex) {
            Logger.getLogger(DoctorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return doctorList;
            
    }
}
