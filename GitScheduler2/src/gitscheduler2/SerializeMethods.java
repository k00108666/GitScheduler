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
 import java.io.*;
import java.util.Calendar;


public class SerializeMethods {
   String notesWeek;
   String returnData;
   
    
    

public void SerializeNotes () {

      Calendar cal = Calendar.getInstance();
                  
                    cal.setTime(SchedulerGUI.date);
                 int WeekNum = cal.get(Calendar.WEEK_OF_YEAR);
                 int year = cal.get(Calendar.YEAR);
               
                   
    
    notesWeek = "Notes_" + Integer.toString(year) + "_week_" + Integer.toString(WeekNum);
    String notes = SchedulerGUI.notes;
    
    

    
    
      try
      {
         FileOutputStream fileOut =
         new FileOutputStream(notesWeek);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(notes);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in " + notesWeek );
      }catch(IOException i)
      {
          i.printStackTrace();
      }
    
    
}

   







public void LoadNotes () {
    
    Calendar cal = Calendar.getInstance();
                  
                    cal.setTime(SchedulerGUI.date);
                 int WeekNum = cal.get(Calendar.WEEK_OF_YEAR);
                 int year = cal.get(Calendar.YEAR);
               
                   
    
    notesWeek = "Notes_" + Integer.toString(year) + "_week_" + Integer.toString(WeekNum);


   String e = null;
      try
      {
         FileInputStream fileIn = new FileInputStream(notesWeek);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e =  (String) in.readObject();
         in.close();
         fileIn.close();
         returnData = e;
         System.out.println(e);
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
     
    }

}


