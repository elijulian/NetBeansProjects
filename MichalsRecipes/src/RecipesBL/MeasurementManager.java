/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesBL;

import DAL.MeasurementsDAL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author EliandMichal
 */
public class MeasurementManager {
    private MeasurementsDAL dal;

    public MeasurementManager() {
        dal = new MeasurementsDAL(null);
    }
    
    public String[] getAllMeasurements(){
        return dal.getAllMeasurements();
    }
    
    public ArrayList getAllMeasurementsAL(){
        return dal.getAllMeasurementsArrayList();
    }
    
    public HashMap getAllMeasurementsHashMap(){
        return dal.getAllMeasurementsHashMap();
    }
}
