/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feu.eac.dto;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

   public String getTopic () throws Exception {
       String topic = "";
       try {
            
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "SELECT * FROM test.properties WHERE topic_id = 1";
            preparedStatement = connect.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                topic = rs.getString("topic");
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
       
       return topic;
   }
    
   public int getNumberOfEssays() throws Exception {
       int numOfEssays = 0;
       try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql2 = "SELECT count(*) AS rowcount FROM test.submissions";
            preparedStatement = connect.prepareStatement(sql2);
            ResultSet rs2 = preparedStatement.executeQuery();
            if (rs2.next()) {
                numOfEssays = rs2.getInt("rowcount");
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
       return numOfEssays;
   }
   
   public List<Essay> getEssays () throws Exception {
       List<Essay> essays = new ArrayList<Essay>();
       
       try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "SELECT * FROM test.submissions ORDER BY overall_score DESC";
            preparedStatement = connect.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Essay essay = new Essay();
                essay.setEssay_id(rs.getInt("essay_id"));
                essay.setStudent_num(rs.getInt("student_num"));
                essay.setStudent_name(rs.getString("student_name"));
                essay.setStudent_year(rs.getString("student_year"));
                essay.setStudent_section(rs.getString("student_section"));
                essay.setContent(rs.getString("content"));
                essay.setOverall_score(rs.getDouble("overall_score"));
                essay.setContent_score(rs.getDouble("content_score"));
                essay.setGrammar_score(rs.getDouble("grammar_score"));
                essay.setDate(rs.getDate("date").toString());
                essays.add(essay);
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
        return essays;
   }

   public String getEssayContent(int essay_id) throws Exception {
       String content = "";
       try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "SELECT content FROM test.submissions where essay_id = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, essay_id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                content = rs.getString("content");
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
       return content;
   }
   
   public boolean checkPass (String password) throws Exception {
       boolean valid = false;
       try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "SELECT * FROM test.users WHERE username = ? AND password = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, "admin");
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
   
   
}
