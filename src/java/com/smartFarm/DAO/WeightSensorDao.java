/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this weightlate file, choose Tools | Weightlates
 * and open the weightlate in the editor.
 */
package com.smartFarm.DAO;

import com.smartFarm.pojo.WeightSensor;
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
public class WeightSensorDao  extends DAO{
    Connection conn;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    
    //Boolean stop;
    Timer weightTimer;
    
    public void sensing(){
        
        weightTimer = new Timer();
        weightTimer.schedule(new WeightTimerTask(), 1, 12000);
        
        
    }
    
    
    public void stopSensing(){
        
        weightTimer.cancel();
        weightTimer.purge();
        
    }
    
    
    public class WeightTimerTask extends TimerTask{

        @Override
        public void run() {
            
                addRecords();

            
        }
        
        
    }
    
    
    public void addRecords(){
        
        WeightSensor ws;
            
            ArrayList<Integer> idList=getSensorIds();
            
            for(Integer integerId: idList){
                
                int wsId=integerId;
                
                ws=new WeightSensor(wsId);
                
                addWeightRecord(ws);
            }
        
    }
    
    public ArrayList<Integer> getSensorIds(){
        ArrayList<Integer> idList=new ArrayList<Integer>();
        
        try {
            conn = getConnection();

            String query = "select Sensor_Id from Sensor where Sensor_Type = 'WEIGHT'";

            stmt = conn.createStatement();
            

            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()){
                idList.add(rs.getInt("Sensor_Id"));
                
            }


        } catch (SQLException ex) {
            Logger.getLogger(WeightSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);

        }
        return idList;
        
    }
    

    public void addWeightRecord(WeightSensor ws) {

        try {
            conn = getConnection();

            String query = "insert into WeightSensorRecord (Sensor_Id, Ws_Time, Ws_Read) values (?,?,?)";

            ps = conn.prepareStatement(query);
            ps.setInt(1, ws.getWsId());
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(ws.getWsTime()));
            ps.setDouble(3, ws.getWsRead());

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("weight record added successfully!");
            } else {
                System.out.println("weight record cannot be added!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(WeightSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);

        }

    }

    public List<WeightSensor> getAllWeightSensor() {

        List<WeightSensor> wsList = new ArrayList<>();

        try {
            WeightSensor ws;

            conn = getConnection();

            String query = "select * from WeightSensorRecord";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                Date time = new Date(rs.getTimestamp("Ws_Time").getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strTime = sdf.format(time);

                ws = new WeightSensor(rs.getDouble("Ws_Read"), strTime, rs.getInt("Sensor_Id"));

                wsList.add(ws);

            }

            //QueryRunner qr=new QueryRunner();
            //ResultSetHandler<List<WeightSensor>> handler=new BeanListHandler<>(WeightSensor.class);
            //wsList=qr.query(conn, query, handler);
        } catch (SQLException ex) {
            Logger.getLogger(WeightSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return wsList;

    }

    public WeightSensor getTSById(int id) {

        WeightSensor ws = null;

        try {
            conn = getConnection();

            String query = "select * from WeightSensorRecord where Sensor_Id = ?";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                Date time = new Date(rs.getTimestamp("Ws_Time").getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strTime = sdf.format(time);

                ws = new WeightSensor(rs.getDouble("Ws_Read"), strTime, rs.getInt("Sensor_Id"));

                return ws;

            }

        } catch (SQLException ex) {
            Logger.getLogger(WeightSensorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return null;
    }
}
