/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;


import com.smartFarm.pojo.Vaccine;
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
public class VaccineDao extends DAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public void addVaccine(Vaccine vaccine) throws SQLException {
        try {
            conn = getConnection();
            String query = "insert into Vaccine values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            System.out.println(query);

            ps.setLong(1, vaccine.getVaccineId());
            ps.setString(2, vaccine.getName());
            ps.setString(3, vaccine.getDiseasePrevent());
            ps.setString(4, vaccine.getGroup());
            ps.setString(5, vaccine.getVaccineAge());
            ps.setString(6, vaccine.getImmunePeriod());

            ps.executeUpdate();
            // return ps.toString();

        } catch (SQLException ex) {
            Logger.getLogger(VaccineDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();

        }
        // return null;
    }

    public List<Vaccine> getAllVaccine( )throws SQLException{
        List<Vaccine> vaccineList = new ArrayList<>();
        try{
            conn=getConnection();
            
            String query="select * from Vaccine";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Vaccine vaccine = new Vaccine();
                vaccine.setVaccineId(rs.getLong("Vaccine_Id"));
                vaccine.setName(rs.getString("Name"));
                vaccine.setDiseasePrevent(rs.getString("Disease_Prevent"));
                vaccine.setGroup(rs.getString("Group"));
                vaccine.setVaccineAge(rs.getString("Vaccine_Age"));
                vaccine.setImmunePeriod(rs.getString("Immune_Period"));
                vaccineList.add(vaccine);
            } 
        }catch (SQLException ex) {
            Logger.getLogger(VaccineDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return vaccineList;
            
    }
}
