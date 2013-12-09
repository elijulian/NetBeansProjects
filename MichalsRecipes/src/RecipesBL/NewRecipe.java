/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesBL;

import DAL.IngredientDAL;
import DAL.MeasurementsDAL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jerusalem Live
 */
public class NewRecipe {
    
    private String name;
    private Integer numOfServings;
    private String directions;
    private ArrayList ingredients;
    private ArrayList courses;

    public NewRecipe() {
    }
    
    public ArrayList getCourses() {
        return courses;
    }

    public void setCourses(ArrayList courses) {
        this.courses = courses;
    }

    public ArrayList getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Integer getNumOfServings() {
        return numOfServings;
    }

    public void setNumOfServings(Integer numOfServings) {
        this.numOfServings = numOfServings;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean save(){
        mutiplyAmountByMeasurement();
        minimize();
        return false;
    }
    
    private void mutiplyAmountByMeasurement(){
        IngredientDAL ingDAL = new IngredientDAL(null);
        MeasurementsDAL measDAL = new MeasurementsDAL(null);
        
        for (Iterator it = ingredients.iterator(); it.hasNext();) {
            IngredientAndMeasurement iam = (IngredientAndMeasurement)it.next();
            if (ingDAL.isLiquid(iam.getNIngredientID())) {
                iam.setFAmount(iam.getFAmount() * measDAL.getLiquidAmountByID(iam.getNMeasurementID()));
            }
        }
    }
    
    public void minimize(){
        if (numOfServings > 1) {
            
        }
    }
    
    public int getNumOfIndivisibles(){
        for (Iterator it = ingredients.iterator(); it.hasNext();) {
            Object object = it.next();
            
        }
        
        return 1;
    }
}
