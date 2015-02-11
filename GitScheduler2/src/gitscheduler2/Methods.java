/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitscheduler2;

import com.toedter.calendar.JCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Seamus O Connor
 */
public  class Methods {
    
   public  Connection con;
    Statement stmt;
   
    PreparedStatement pst;
     ResultSet rs;
    ResultSet rs2;
    String sql;
  
    
    
    
    
    
    
    
    
    
public final void doConnect() {

 try {
             String host = "jdbc:mysql://localhost:3306/weeklyschedule?zeroDateTimeBehavior=convertToNull";
             String user = "root";
             String pass = "nbuser";
             con = DriverManager.getConnection(host, user, pass);
             
             
             
             
             
           
         } catch (SQLException ex) {
             Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
         }


}
    
    
    
    
  
   
 
            public  void createSchedule() {
                
                
              try {
                 this.doConnect();
               
                 stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //SchedulerGUI gui = new SchedulerGUI();
                 Calendar cal = Calendar.getInstance();
                    cal.setTime(SchedulerGUI.date);
                 int WeekNum = cal.get(Calendar.WEEK_OF_YEAR);
                 int year = cal.get(Calendar.YEAR);
                      
                 String DatabaseString = "CREATE TABLE " + Integer.toString(year) + "_week_" + Integer.toString(WeekNum) + " (PeriodNum INT DEFAULT 1  NOT NULL, Monday VARCHAR(30), Tuesday VARCHAR(30), Wednesday VARCHAR(30), Thursday VARCHAR(30), Friday VARCHAR(30), Saturday VARCHAR(30), Sunday VARCHAR(30), PRIMARY KEY (PeriodNum))";
                 System.out.println(DatabaseString);
                
             stmt.executeUpdate(DatabaseString);
             
             
             for (int x = 1; x < 11; x++) {
             String DatabaseString2 = "INSERT INTO " + Integer.toString(year) + "_week_" + Integer.toString(WeekNum) + " (PeriodNum, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday) VALUES (" + Integer.toString(x) + " , Default, Default, Default, Default, Default, Default, Default)" ;
             stmt.executeUpdate(DatabaseString2);
             };
              
             } catch (SQLException ex) {
                 Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null, "This schedule already exists. Please update it or select another week.");
             }   
            }   
            
            
            public void  getSelectedDb() throws SQLException {
         
                
                
                         
                
                 
         
                        this.doConnect();
                      stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //SchedulerGUI gui = new SchedulerGUI();
                 Calendar cal = Calendar.getInstance();
                    cal.setTime(SchedulerGUI.date);
                 int WeekNum = cal.get(Calendar.WEEK_OF_YEAR);
                 int year = cal.get(Calendar.YEAR);
                      
     
                 
                 String selectedDb = "SELECT * FROM " + Integer.toString(year) + "_week_" + Integer.toString(WeekNum);  
          

            //String sql     = "UPDATE student SET firstName = ? "
            //       + " Set lastName = ?, "
            //       + " WHERE studentID = 456987";
              System.out.println(selectedDb);
             
            rs = stmt.executeQuery(selectedDb);
           
                 //String selectedDb = "SELECT * FR0M ?" + Integer.toString(year) + "_week_" + Integer.toString(WeekNum);  
                // System.out.println(selectedDb);
                
                 
                // rs = pst.executeQuery();
                 
                 
                 // rs = stmt.executeQuery(selectedDb);
                  //System.out.print(rs);
                    }
                    
                    
                    
                 
                 
                 
                               
                    
  
            
               public void getDefaultSchedule() throws SQLException {
                   
                     this.doConnect();
                      stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                     String DatabaseString = "SELECT * FROM schedule";  
                 System.out.println(DatabaseString);
                
                 rs = stmt.executeQuery(DatabaseString);
                  System.out.print(rs);
                    }
                  
                 
               public void updateDb() throws SQLException {
                   
                   
                   this.doConnect();
               
                 stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //SchedulerGUI gui = new SchedulerGUI();
                 Calendar cal = Calendar.getInstance();
                  
                    cal.setTime(SchedulerGUI.date);
                 int WeekNum = cal.get(Calendar.WEEK_OF_YEAR);
                 int year = cal.get(Calendar.YEAR);
               
                   
                 
                 
                 
                 
                 String sql = "UPDATE " + Integer.toString(year) + "_week_" + Integer.toString(WeekNum) + " SET " + SchedulerGUI.colName + " = " + SchedulerGUI.newData + " WHERE PeriodNum = " + SchedulerGUI.periodNum;
                 
              System.out.println(sql);
                 
              
                 
                 
                
           
            
              stmt.executeUpdate(sql);
            
                   
               }
               
                     
                    
             }
                     
                     
                     
               




        

    
    
    
    
    
    
    
    
    
    
    
    
    




