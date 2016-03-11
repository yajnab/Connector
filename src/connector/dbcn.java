/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author yajnavalkya
 */
public class dbcn {
    Connection con;
    public dbcn() throws SQLException, ClassNotFoundException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
          con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/broadband?zeroDateTimeBehavior=convertToNull","yajnab","petrol123");
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();}
      }
    public void dbtcreate(){
        Statement stmt;
        try {
            stmt = con.createStatement();
            try{
                int executeUpdate = stmt.executeUpdate("Create table broadbandu(uname varchar(20) NOT NULL, passwd varchar(45) NOT NULL, provider varchar(60), PRIMARY KEY('uname'),);");
            }catch(SQLException ee){ee.printStackTrace();}
        } catch (SQLException ex) {
            Logger.getLogger(dbcn.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public void idret(){
        Statement stmt;
        try{
            stmt = con.createStatement();
            try{
                int executeUpdate = stmt.executeUpdate("Select * from broadbandu;");
            }catch(SQLException e){e.printStackTrace();}
        }catch(SQLException e){e.printStackTrace();}
    }
}

   

