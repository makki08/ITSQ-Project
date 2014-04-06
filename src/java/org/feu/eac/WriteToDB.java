/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.feu.eac;

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
public class WriteToDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private PreparedStatement preparedStatement2 = null;

    public void addToSubmissions (int student_num, String student_name, String student_year, 
            String student_section, String content, double overall_score, double content_score, 
            double grammar_score) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            String sql = "INSERT INTO test.submissions(student_num, student_name, student_year, student_section, content, overall_score, content_score, grammar_score, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, student_num);
            preparedStatement.setString(2, student_name);
            preparedStatement.setString(3, student_year);
            preparedStatement.setString(4, student_section);
            preparedStatement.setString(5, content);
            preparedStatement.setDouble(6, overall_score);
            preparedStatement.setDouble(7, content_score);
            preparedStatement.setDouble(8, grammar_score);
            preparedStatement.setDate(9, sqlDate);

            // Execute SQL insert
            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WriteToDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WriteToDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void createNewTopic (String topic) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "UPDATE properties SET topic = ?, corpus_size = 0, submissions = 0 WHERE topic_id = 1;";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, topic);

            // Execute SQL insert
            preparedStatement.executeUpdate();
            
            String sql2 = "DELETE FROM submissions;";
            preparedStatement2 = connect.prepareStatement(sql2);
            preparedStatement2.executeUpdate(); 
            
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WriteToDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WriteToDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
   public void changePass (String password) {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "UPDATE test.users SET password = ? WHERE username = ?;";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, DigestUtils.md5Hex(password));
            preparedStatement.setString(2, "admin");
            
            // Execute SQL insert
            preparedStatement.executeUpdate();
            
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WriteToDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WriteToDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
   }
}
