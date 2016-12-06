/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;

import com.smartFarm.pojo.MilkSensor;
import com.smartFarm.pojo.TempSensor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jingli
 */
public class MilkSensorDao  extends DAO{
    Connection conn;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    
    //Boolean stop;
    Timer tempTimer;
    
    public void sensing(){
        
        tempTimer = new Timer();
        tempTimer.schedule(new TempTimerTask(), 1, 12000);
        
        
    }
    
    
    public void stopSensing(){
        
        tempTimer.cancel();
        tempTimer.purge();
        
    }
    
    
    public class TempTimerTask extends TimerTask{

        @Override
        public void run() {
            
                addRecords();

            
        }
        
        
    }
    
    
    public void addRecords(){
        
        MilkSensor ts;
            
            ArrayList<Integer> idList=getSensorIds();
            
            for(Integer integerId: idList){
                
                int tsId=integerId;
                
                ts=new MilkSensor(tsId);
                
                addTempRecord(ts);
            }
        
    }
    
    public ArrayList<Integer> getSensorIds(){
        ArrayList<Integer> idList=new ArrayList<Integer>();
        
        try {
            conn = getConnection();

            String query = "select Sensor_Id from Sensor where Sensor_Type = 'MILK'";

            stmt = conn.createStatement();
            

            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()){
                idList.add(rs.getInt("Sensor_Id"));
                
            }


        } catch (SQLException ex) {
            Logger.getLogger(TempSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);

        }
        return idList;
        
    }
    

    public void addTempRecord(MilkSensor ts) {

        try {
            conn = getConnection();

            String query = "insert into MilkSensorRecord (Sensor_Id, Ms_Time, Ms_Read) values (?,?,?)";

            ps = conn.prepareStatement(query);
            ps.setInt(1, ts.getMsId());
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(ts.getMsTime()));
            ps.setDouble(3, ts.getMsRead());

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("temp record added successfully!");
            } else {
                System.out.println("temp record cannot be added!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(TempSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);

        }

    }

    public List<MilkSensor> getAllTempSensor() {

        List<MilkSensor> tsList = new ArrayList<>();

        try {
            MilkSensor ts;

            conn = getConnection();

            String query = "select * from MilkSensorRecord";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                Date time = new Date(rs.getTimestamp("Ms_Time").getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strTime = sdf.format(time);

                ts = new MilkSensor(rs.getDouble("Ms_Read"), strTime, rs.getInt("Sensor_Id"));

                tsList.add(ts);

            }

            //QueryRunner qr=new QueryRunner();
            //ResultSetHandler<List<TempSensor>> handler=new BeanListHandler<>(TempSensor.class);
            //tsList=qr.query(conn, query, handler);
        } catch (SQLException ex) {
            Logger.getLogger(TempSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return tsList;

    }

    public MilkSensor getTSById(int id) {

        MilkSensor ts = null;

        try {
            conn = getConnection();

            String query = "select * from MilkSensorRecord where Sensor_Id = ?";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                Date time = new Date(rs.getTimestamp("Ms_Time").getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strTime = sdf.format(time);

                ts = new MilkSensor(rs.getDouble("Ms_Read"), strTime, rs.getInt("Sensor_Id"));

                return ts;

            }

        } catch (SQLException ex) {
            Logger.getLogger(TempSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return null;
    }
}
