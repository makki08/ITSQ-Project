/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feu.eac.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author makki
 */
public class ReadFromDB {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public boolean connect(String username, String password) throws Exception {
        boolean valid = false;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "SELECT * FROM test.users WHERE username = ? AND password = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, DigestUtils.md5Hex(password));
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                valid = true;
            }
            
        } catch (SQLException se) {
            System.out.println(se.getMessage()); 
        } catch (Exception e) {
            throw e;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReadFromDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReadFromDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return valid;
    }

   public Properties getProps () throws Exception {
       Properties props = new Properties();
       
       try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "SELECT * FROM test.properties WHERE topic_id = 1";
            preparedStatement = connect.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                props.setTopic(rs.getString("topic"));
                props.setFilesInCorpus(rs.getInt("corpus_size"));
                props.setNumberOfSubmittesEssays(rs.getInt("submissions"));
            }
            
        } catch (SQLException se) {
            System.out.println(se.getMessage()); 
        } catch (Exception e) {
            throw e;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReadFromDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReadFromDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       
       return props;
   }
    

}
