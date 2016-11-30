/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;


import com.smartFarm.pojo.Employee;
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
 * @author he.fa
 */
public class EmployeeDao extends DAO{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public int addEmployee(Employee employee) throws SQLException{
        int Id=0;
        try{
            conn=getConnection();
            String query ="insert into Livestock (Id, Name, Phone, Category) values(?,?,?,?)";
            ps=conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setLong(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getPhone());
            ps.setString(4, employee.getCategory());
            
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
    
    public List<Employee> getAllEmployee( )throws SQLException{
        List<Employee> employeeList=null;
        try{
            conn=getConnection();
            QueryRunner runner=new QueryRunner();
            ResultSetHandler<List<Employee>> resultSetHandler=new BeanListHandler<>(Employee.class);
            String query="select * from Employee";
            employeeList=runner.query(conn,query, resultSetHandler);
        }catch (SQLException ex) {
            Logger.getLogger(LivestockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }
        
        return employeeList;
            
    }
}
