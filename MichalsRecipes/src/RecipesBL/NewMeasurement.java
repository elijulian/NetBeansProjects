/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesBL;

import DAL.MeasurementsDAL;

/**
 *
 * @author Jerusalem Live
 */
public class NewMeasurement {
    private String name;
    private Integer amountG;

    public NewMeasurement(String name, String amountG) {
        setAmountG(amountG);
        setName(name);
    }
    
    public void setName(String val){
        name = val;
    }
    
    public void setAmountG(String val){
        amountG = Integer.parseInt(val);
    }

    public String getName() {
        return name;
    }

    public int getAmountG() {
        return amountG;
    }

    public boolean save(){
       MeasurementsDAL dal = new MeasurementsDAL(this);
       return dal.save();
    }
}
