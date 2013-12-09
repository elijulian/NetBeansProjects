/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import JPAEntities.Measurements;
import RecipesBL.NewMeasurement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jerusalem Live
 */
public class MeasurementsDAL extends AbstractDAL {
    public static final String GET_MAX_ID = "Measurements.findMAXID";
    public static final String FIND_ALL = "Measurements.findAll";
    public static final String SOLID_AMOUNT_BY_ID = "Measurements.findSolidAmountById";
    public static final String LIQUID_AMOUNT_BY_ID = "Measurements.findLiquidAmountById";
    public static final String ID = "id";
    private NewMeasurement newMeasurement;
    
    public MeasurementsDAL(NewMeasurement val){
        this.newMeasurement = val;
        begin();
    }
    
    public String[] getAllMeasurements(){
        List allMeasurements = executeQuery(FIND_ALL);
        StringBuffer measurementsCVS = new StringBuffer("");
        
        for (Iterator it = allMeasurements.iterator(); it.hasNext();) {
            Measurements measurement = (Measurements)it.next();
            measurementsCVS.append(measurement.getName());
            measurementsCVS.append(", ");
        }
        
        String[] measurementsArray = measurementsCVS.toString().split(", ");
        return measurementsArray;
    }
    
    public ArrayList getAllMeasurementsArrayList(){
        List allMeasurements = executeQuery(FIND_ALL);
        ArrayList measurementsAL = new ArrayList();
        
        for (Iterator it = allMeasurements.iterator(); it.hasNext();) {
            Measurements measurement = (Measurements)it.next();
            measurementsAL.add(measurement.getName());
        }
        
        return measurementsAL;
    }
    
    public HashMap getAllMeasurementsHashMap(){
        List allMeasurements = executeQuery(FIND_ALL);
        HashMap measurementsMap = new HashMap();
        
        for (Iterator it = allMeasurements.iterator(); it.hasNext();) {
            Measurements measurements = (Measurements)it.next();
            measurementsMap.put(measurements.getName(),
                                measurements.getId());
        }
        
        return measurementsMap;
    }
    
    public Float getSolidAmountByID(Integer measurementID){
        return (Float)super.getSingleResult(SOLID_AMOUNT_BY_ID, ID, measurementID);
    }
    
    public Float getLiquidAmountByID(Integer measurementID){
        return (Float)super.getSingleResult(LIQUID_AMOUNT_BY_ID, ID, measurementID);
    }
    
    public boolean save(){
        Measurements measurements = new Measurements();
        
        measurements.setAmountG(newMeasurement.getAmountG());
        measurements.setName(newMeasurement.getName());
        measurements.setId(getNextIDVal(GET_MAX_ID));
        
        return super.commit(measurements);
    }
}
