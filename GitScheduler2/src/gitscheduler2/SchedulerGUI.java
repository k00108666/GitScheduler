/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitscheduler2;

/**
 *
 * @author Seamus O Connor
 */




import com.toedter.calendar.JCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import jdk.nashorn.internal.objects.Global;
import net.proteanit.sql.DbUtils;
import javax.swing.event.*;
import javax.swing.table.TableModel;



public class SchedulerGUI extends javax.swing.JFrame {

    /**
     * 
     * 
     * 
     * 
     * 
     * Creates new form SchedulerGUI
     */
    
    
  
    
    Statement stmt;
  public static Date date;
  public static Object tableData;
  public static String newData;
  public static String colName;
  public static String periodNum;

  
  

  
    public SchedulerGUI() {
        initComponents();
      
            JTableSchedule.getModel().addTableModelListener(new TableListener());
        
        
        
    }

    
    
    
    
    
    
             
      
        
        public  void loadTable()  {
        
            Methods method = new Methods();
      //Connection  con = method.con;
     ResultSet rs = method.rs;
             
     
      if (rs!=null)JTableSchedule.setModel(DbUtils.resultSetToTableModel(rs));
        try {
            if (rs!=null)rs.close();
        } catch (Exception ex) {
            
           System.out.println("GUI.loadTableError");
        }
      
        }
        
        
        
        
        
     // yourtable.getModel().addTableModelListener(new TableModelListener() {
          
    
     
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
 
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableSchedule = new javax.swing.JTable();
        WorkingsPanel = new javax.swing.JPanel();
        JCalendar = new com.toedter.calendar.JCalendar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTableSchedule.getModel().addTableModelListener(new TableListener());
        JTableSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTableSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableScheduleMouseClicked(evt);
            }
        });
        JTableSchedule.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JTableSchedulePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(JTableSchedule);
        JTableSchedule.getModel().addTableModelListener(new TableModelListener()  {

            public void tableChanged(TableModelEvent e) {

                Methods method = new Methods();
                System.out.println("seamy");

            }

        });

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JCalendar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JCalendarFocusGained(evt);
            }
        });
        JCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCalendarMouseClicked(evt);
            }
        });
        JCalendar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                JCalendarCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                JCalendarInputMethodTextChanged(evt);
            }
        });
        JCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JCalendarPropertyChange(evt);
            }
        });
        JCalendar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCalendarKeyPressed(evt);
            }
        });
        JCalendar.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                JCalendarVetoableChange(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setText("Weekly Notes");

        javax.swing.GroupLayout WorkingsPanelLayout = new javax.swing.GroupLayout(WorkingsPanel);
        WorkingsPanel.setLayout(WorkingsPanelLayout);
        WorkingsPanelLayout.setHorizontalGroup(
            WorkingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WorkingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(WorkingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        WorkingsPanelLayout.setVerticalGroup(
            WorkingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WorkingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WorkingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WorkingsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(WorkingsPanelLayout.createSequentialGroup()
                        .addComponent(JCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 278, Short.MAX_VALUE)))
                .addContainerGap())
        );

        JTableSchedule.getModel().addTableModelListener(new TableModelListener()  {

            public void tableChanged(TableModelEvent e) {

                Methods method = new Methods();
                System.out.println("seamy");

            }

        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(WorkingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WorkingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JCalendarPropertyChange


                  
date = JCalendar.getDate();
System.out.println(JCalendar.getDate());// TODO add your handling code here:

Methods method = new Methods();



try{
method.getSelectedDb();
//if (method.rs != null){
JTableSchedule.setModel(DbUtils.resultSetToTableModel(method.rs));
}
catch (SQLException ex) {
 
   System.out.println("No database exists to select");
   
    try {
        
        method.getDefaultSchedule();
        if (method.rs != null){
        JTableSchedule.setModel(DbUtils.resultSetToTableModel(method.rs));}}
    
     catch (SQLException ex1) {
        Logger.getLogger(SchedulerGUI.class.getName()).log(Level.SEVERE, null, ex1);
    } finally {
        try{
            method.con.close();
            method.stmt.close();
            method.rs.close();
        } catch (Exception ex1) {
            
             Logger.getLogger(SchedulerGUI.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
    }
    
}

//JTableSchedule.setModel(DbUtils.resultSetToTableModel(method.rs));
        
           
        
    }//GEN-LAST:event_JCalendarPropertyChange

    private void JCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCalendarMouseClicked

        

// TODO add your handling code here:
    
    }//GEN-LAST:event_JCalendarMouseClicked

    private void JCalendarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCalendarFocusGained
        // TODO add your handling code here:
    
    }//GEN-LAST:event_JCalendarFocusGained

    private void JCalendarCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JCalendarCaretPositionChanged
        // TODO add your handling code here:
    
    }//GEN-LAST:event_JCalendarCaretPositionChanged

    private void JCalendarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCalendarKeyPressed
     // TODO add your handling code here:
    }//GEN-LAST:event_JCalendarKeyPressed

    private void JCalendarVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_JCalendarVetoableChange
        // TODO add your handling code here:
     
    }//GEN-LAST:event_JCalendarVetoableChange

    private void JCalendarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JCalendarInputMethodTextChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_JCalendarInputMethodTextChanged

    private void JTableSchedulePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JTableSchedulePropertyChange
        // TODO add your handling code here:
        
              
    }//GEN-LAST:event_JTableSchedulePropertyChange

    private void JTableScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableScheduleMouseClicked
        // TODO add your handling code here:
    
           
    }//GEN-LAST:event_JTableScheduleMouseClicked

    
 
  
  
   public    void getColName() {
       int columnIndex = JTableSchedule.getSelectedColumn();
        int rowIndex = JTableSchedule.getSelectedRow();
       colName = JTableSchedule.getColumnName(columnIndex);
   
        
        
           
        
        
    }
   
   public    void getPeriodNum() {
       int columnIndex = JTableSchedule.getSelectedColumn();
        int rowIndex = JTableSchedule.getSelectedRow();
       colName = JTableSchedule.getColumnName(columnIndex);
 
       
        periodNum = JTableSchedule.getValueAt(rowIndex, 0).toString();
       
                 
       
        
    }
   
   public void getNewData()  {

       
         int columnIndex = JTableSchedule.getSelectedColumn();
        int rowIndex = JTableSchedule.getSelectedRow();
        newData = JTableSchedule.getValueAt(rowIndex, columnIndex).toString();
      
       
       
    
       
       
       
       
   }
  
  
 
    
  
  
  public  class TableListener implements TableModelListener  {
      
       @Override 
       public void tableChanged(TableModelEvent tme) {
          
               getColName();
        getPeriodNum();
        getNewData();
         
           
            System.out.println("DataChanged");
           Methods method = new Methods();
            try {
              
                method.updateDb();
            } catch (SQLException ex1) {
                Logger.getLogger(SchedulerGUI.class.getName()).log(Level.SEVERE, null, ex1);
                  
                method.createSchedule();
            }
           
                   try {
                       method.updateDb();
                   } catch (SQLException ex) {
                       Logger.getLogger(SchedulerGUI.class.getName()).log(Level.SEVERE, null, ex);
                   }
              
            }
     } //end method

   //end class

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SchedulerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchedulerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchedulerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchedulerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchedulerGUI().setVisible(true);
                
            }
        });
        
     
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
  
        
        
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar JCalendar;
    private javax.swing.JTable JTableSchedule;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JPanel WorkingsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
