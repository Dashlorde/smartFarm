/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;

import com.smartFarm.pojo.Livestock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author zhouyunlu
 */
public class LivestockDao extends DAO {
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public int addLivestock(Livestock livestock) throws SQLException{
        int Id=0;
        try{
            conn=getConnection();
            String query ="insert into Livestock (Employ_Id, Age, Weight, Gender, Type) values(?,?,?,?,?)";
            ps=conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setLong(1, livestock.getEmployeeId());
            ps.setInt(2, livestock.getWeight());
            ps.setInt(3, livestock.getWeight());
            ps.setString(4, livestock.getGender());
            ps.setString(5, livestock.getType());
            
            int result = ps.executeUpdate();
            if (result > 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                Id = rs.getInt(1);
                return Id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
            rs.close();
        }
        return Id;
    }
    
    public List<Livestock> getAllLivestock( )throws SQLException{
        List<Livestock> livestockList=null;
        try{
            conn=getConnection();
            QueryRunner runner=new QueryRunner();
            ResultSetHandler<List<Livestock>> resultSetHandler=new BeanListHandler<>(Livestock.class);
            String query="select * from Livestock";
            livestockList=runner.query(conn,query, resultSetHandler);
        }catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return livestockList;
            
    }
}
