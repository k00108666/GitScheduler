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
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Seamus O Connor
 */
public  class Methods {
    
     Connection con;
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
    
    
    
    
   public  Methods() {
            
       
       
    // this.doConnect();
      
        
         
         
             try {
                 this.doConnect();
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                 sql = "SELECT * FROM schedule";
                 rs2 = stmt.executeQuery(sql);
                 // rs.close();
                 //   stmt.close();
         
          
             } catch (SQLException ex) {
                 Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
               
             }    finally{
                 
                 
                 try {
                    if (con != null) con.close();
                    if(stmt!= null) stmt.close();
                 } catch (SQLException ex) {
                      JOptionPane.showMessageDialog(null, "Could not load schedule template");
                 }
             }
      
           
             
             
             
             
             
             
             
              try {
                 this.doConnect();;
                  SchedulerGUI gui = new SchedulerGUI();
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                
                  Calendar cal = Calendar.getInstance();
                cal.setTime(gui.setSelectedDate());
                 int WeekNum = cal.get(Calendar.WEEK_OF_YEAR);
              System.out.println(Integer.toString(WeekNum));
            int year = cal.get(Calendar.YEAR);
                       System.out.println(Integer.toString(year));
           String DatabaseString = "SELECT * FROM " + Integer.toString(year) + "_week_" + Integer.toString(WeekNum);
                 System.out.println(DatabaseString);
                
                 rs = stmt.executeQuery(DatabaseString);
             } catch (SQLException ex) {
                 
                  JOptionPane.showMessageDialog(null, "I'm sorry but no schedule exists. Please create one for the selected week");
             }   finally{
                 
                 
                 try {
                    if (con != null) con.close();
                    if(stmt!= null) stmt.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
      
       
   
               
           } 
   
   
 
               


   }
        

    
    
    
    
    
    
    
    
    
    
    
    
    




