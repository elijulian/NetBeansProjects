/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesBL;

import DAL.IngredientDAL;
import java.util.HashMap;
/**
 *
 * @author EliandMichal
 */
public class IngredientManager {
    private IngredientDAL dal;

    public IngredientManager() {
        dal = new IngredientDAL(null);
    }
    
    public HashMap getAllIngredientsHashMap(){
        return dal.getIngredientsHashMap();
    }
    
    public String[] getAllIngredientsCSV(){
        return dal.getAllIngredients();
    }
    
    public boolean isUndivisible(String ingName){
        IngredientDAL dal = new IngredientDAL(null);
        HashMap ingHashMap = dal.getIngredientsHashMap();
        Integer ingID = (Integer) ingHashMap.get(ingName);
        return dal.isUndivisible(ingID);
    }
}
