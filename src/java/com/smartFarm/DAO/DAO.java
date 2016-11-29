/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author zhouyunlu
 */
public class DAO {
    private String driver;
    private String dburl;
    private String dbuser;
    private String dbpassword;
    
    public DAO(){
        driver = "com.mysql.jdbc.Driver";
        dburl = "jdbc:mysql://localhost:3306/smartFarm";
        dbuser = "root";
        dbpassword="1234";
        
        DbUtils.loadDriver(driver);
    }
    
    public Connection getConnection(){
        Connection conn =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
        try{
            conn = DriverManager.getConnection(dburl,dbuser,dbpassword);
            
        }catch(SQLException ex){
            System.out.println("Connection Failed! Check output console");
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        if (conn != null) {
            System.out.println("You made it, take control your database now!");
        }
        return conn;
    }
    public void close(Connection connection){
        if(connection != null){
            try{
                DbUtils.close(connection);
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    } 
}
