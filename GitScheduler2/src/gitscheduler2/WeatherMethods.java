/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitscheduler2;

import com.teknikindustries.yahooweather.WeatherDisplay;
import com.teknikindustries.yahooweather.WeatherDoc;

/**
 *
 * @author Seamus O Connor
 */
public class WeatherMethods {
    String temp;
    String condition;
    String measurement;
    public void getWeather() {
        Methods method = new Methods();
       method.getWOEID();
        
        
        WeatherDoc doc = new WeatherDoc(method.locationCode, "c");
        WeatherDisplay disp = new WeatherDisplay();
        
        temp = disp.getTemperature().toString();
        measurement = disp.getTemperatureUnit();
      condition = disp.getCondition();
        
        
        
    }
    
    
    
    
    
}
