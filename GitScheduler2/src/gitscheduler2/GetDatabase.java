/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitscheduler2;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;


/**
 *
 * @author Seamus O Connor
 */
public class GetDatabase {
    
    
    private Connection con;
    public GetDatabase(Connection con){
        this.con=con;
    }

    GetDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * This method return JTable object created from Database table having same data asn structure
     * as in original table into database.
     * @param table Name of the database table to be coverted to JTable
     * @return JTable object that consist of data and structure of Database table
     * @throws java.lang.Exception Original object is deferent, e.i either SQLException or NullPointerException
     */
    public JTable getTable(String table)throws Exception{
        JTable t1=new JTable();
        DefaultTableModel dm=new DefaultTableModel();
        Statement st=con.createStatement();   
        ResultSet rs=st.executeQuery("select * from "+table);
        ResultSetMetaData rsmd=rs.getMetaData();
        //Coding to get columns-
        int cols=rsmd.getColumnCount();
        String c[]=new String[cols];
        for(int i=0;i<cols;i++){
            c[i]=rsmd.getColumnName(i+1);
            dm.addColumn(c[i]);
        }
        //get data from rows
        Object row[]=new Object[cols];
        while(rs.next()){
             for(int i=0;i<cols;i++){
                    row[i]=rs.getString(i+1);
                }
            dm.addRow(row);
        }
        t1.setModel(dm);
        con.close();
        return t1;
    }
    
    
    
    
    
    
    
}
