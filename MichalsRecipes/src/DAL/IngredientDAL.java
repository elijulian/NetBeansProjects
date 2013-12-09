/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import JPAEntities.Ingredients;
import RecipesBL.NewIngredient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jerusalem Live
 */
public class IngredientDAL extends AbstractDAL{
    public static final String FIND_MAX = "Ingredients.findMAXID";
    public static final String FIND_ALL = "Ingredients.findAll";
    public static final String FIND_BY_ID = "Ingredients.findById";
    public static final String ID = "id";
    private NewIngredient newIngredient;

    public IngredientDAL(NewIngredient newIngredient) {
        this.newIngredient = newIngredient;
        begin();
    }
    
    public String[] getAllIngredients(){
        List allIngredients = executeQuery(FIND_ALL);
        StringBuffer ingredientsCSV = new StringBuffer("");
        
        for (Iterator it = allIngredients.iterator(); it.hasNext();) {
            Ingredients ingredients = (Ingredients)it.next();
            ingredientsCSV.append(ingredients.getName());
            ingredientsCSV.append(", ");
        }
        String[] ingredientsArray = ingredientsCSV.toString().split(", ");
        return ingredientsArray;
    }
    
    public HashMap getIngredientsHashMap(){
        List allIngredients = executeQuery(FIND_ALL);
        HashMap ingredientsMap = new HashMap();
        
        for (Iterator it = allIngredients.iterator(); it.hasNext();) {
            Ingredients ingredients = (Ingredients)it.next();
            ingredientsMap.put(ingredients.getName(),
                               ingredients.getId());
        }
        
        return ingredientsMap;
    }
    
    public boolean isLiquid(Integer ingID){
        Ingredients ingredient =  
                (Ingredients) getSingleResult(FIND_BY_ID, ID, ingID);
        return ingredient.getIndLiquid() == 1;
    }
    
    public boolean isUndivisible(Integer ingID){
        Ingredients ingredient = 
                (Ingredients) getSingleResult(FIND_BY_ID, ID, ingID);
        return ingredient.getIndDivisible() == 0;
    }
    
    public boolean save(){
        Ingredients ingredients = new Ingredients();
        
        ingredients.setId(getNextIDVal(FIND_MAX));
        ingredients.setName(newIngredient.getName());
        ingredients.setAmountSold(newIngredient.getAmountSold());
        ingredients.setIndLiquid(newIngredient.isIndLiquid());
        ingredients.setIndDivisible(newIngredient.isIndDivisible());
        
        return super.commit(ingredients);
    }
}
