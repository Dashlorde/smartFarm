/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;

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
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author jingli
 */
public class TempSensorDao extends DAO {

    Connection conn;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    
    
    public void sensing(){
        
        Timer tempTimer = new Timer();
        tempTimer.schedule(new TempTimerTask(), 1, 2000);
        
    }
    
    
    public class TempTimerTask extends TimerTask{

        @Override
        public void run() {
            
                addRecords();
            
            
        }
        
        
    }
    
    
    public void addRecords(){
        
        TempSensor ts;
            
            ArrayList<Integer> idList=getSensorIds();
            
            for(Integer integerId: idList){
                
                int tsId=integerId;
                
                ts=new TempSensor(tsId);
                
                addTempRecord(ts);
            }
        
    }
    
    public ArrayList<Integer> getSensorIds(){
        ArrayList<Integer> idList=new ArrayList<Integer>();
        
        try {
            conn = getConnection();

            String query = "select Sensor_Id from Sensor where Sensor_Type = 'TEMP'";

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
    

    public void addTempRecord(TempSensor ts) {

        try {
            conn = getConnection();

            String query = "insert into TempSensorRecord (Sensor_Id, Ts_Time, Ts_Read) values (?,?,?)";

            ps = conn.prepareStatement(query);
            ps.setInt(1, ts.getTsId());
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(ts.getTsTime()));
            ps.setDouble(3, ts.getTsRead());

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

    public List<TempSensor> getAllTempSensor() {

        List<TempSensor> tsList = new ArrayList<>();

        try {
            TempSensor ts;

            conn = getConnection();

            String query = "select * from TempSensorRecord";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                Date time = new Date(rs.getTimestamp("Ts_Time").getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strTime = sdf.format(time);

                ts = new TempSensor(rs.getDouble("Ts_Read"), strTime, rs.getInt("Sensor_Id"));

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

    public TempSensor getTSById(int id) {

        TempSensor ts = null;

        try {
            conn = getConnection();

            String query = "select * from TempSensorRecord where Sensor_Id = ?";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                Date time = new Date(rs.getTimestamp("Ts_Time").getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strTime = sdf.format(time);

                ts = new TempSensor(rs.getDouble("Ts_Read"), strTime, rs.getInt("Sensor_Id"));

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
