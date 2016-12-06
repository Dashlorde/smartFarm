/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this accelerationlate file, choose Tools | Accelerationlates
 * and open the accelerationlate in the editor.
 */
package com.smartFarm.DAO;

import com.smartFarm.pojo.AccelerationSensor;
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
public class AccelerationSensorDao  extends DAO{
    Connection conn;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    
    //Boolean stop;
    Timer accelerationTimer;
    
    public void sensing(){
        
        accelerationTimer = new Timer();
        accelerationTimer.schedule(new AccelerationTimerTask(), 1, 10000);
        
        
    }
    
    
    public void stopSensing(){
        
        accelerationTimer.cancel();
        accelerationTimer.purge();
        
    }
    
    
    public class AccelerationTimerTask extends TimerTask{

        @Override
        public void run() {
            
                addRecords();

            
        }
        
        
    }
    
    
    public void addRecords(){
        
        AccelerationSensor as;
            
            ArrayList<Integer> idList=getSensorIds();
            
            for(Integer integerId: idList){
                
                int asId=integerId;
                
                as=new AccelerationSensor(asId);
                
                addAccelerationRecord(as);
            }
        
    }
    
    public ArrayList<Integer> getSensorIds(){
        ArrayList<Integer> idList=new ArrayList<Integer>();
        
        try {
            conn = getConnection();

            String query = "select Sensor_Id from Sensor where Sensor_Type = 'ACCELERATOR'";

            stmt = conn.createStatement();
            

            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()){
                idList.add(rs.getInt("Sensor_Id"));
                
            }


        } catch (SQLException ex) {
            Logger.getLogger(AccelerationSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);

        }
        return idList;
        
    }
    

    public void addAccelerationRecord(AccelerationSensor as) {

        try {
            conn = getConnection();

            String query = "insert into AccelerationSensorRecord (Sensor_Id, As_Time, As_Read) values (?,?,?)";

            ps = conn.prepareStatement(query);
            ps.setInt(1, as.getAsId());
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(as.getAsTime()));
            ps.setDouble(3, as.getAsRead());

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("acceleration record added successfully!");
            } else {
                System.out.println("acceleration record cannot be added!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccelerationSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);

        }

    }

    public List<AccelerationSensor> getAllAccelerationSensor() {

        List<AccelerationSensor> asList = new ArrayList<>();

        try {
            AccelerationSensor as;

            conn = getConnection();

            String query = "select * from AccelerationSensorRecord";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                Date time = new Date(rs.getTimestamp("As_Time").getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strTime = sdf.format(time);

                as = new AccelerationSensor(rs.getDouble("As_Read"), strTime, rs.getInt("Sensor_Id"));

                asList.add(as);

            }

            //QueryRunner qr=new QueryRunner();
            //ResultSetHandler<List<AccelerationSensor>> handler=new BeanListHandler<>(AccelerationSensor.class);
            //asList=qr.query(conn, query, handler);
        } catch (SQLException ex) {
            Logger.getLogger(AccelerationSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return asList;

    }

    public AccelerationSensor getTSById(int id) {

        AccelerationSensor as = null;

        try {
            conn = getConnection();

            String query = "select * from AccelerationSensorRecord where Sensor_Id = ?";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                Date time = new Date(rs.getTimestamp("As_Time").getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strTime = sdf.format(time);

                as = new AccelerationSensor(rs.getDouble("As_Read"), strTime, rs.getInt("Sensor_Id"));

                return as;

            }

        } catch (SQLException ex) {
            Logger.getLogger(AccelerationSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return null;
    }
}
