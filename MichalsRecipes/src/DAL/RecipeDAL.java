/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import JPAEntities.CourseToRec;
import JPAEntities.CourseToRecPK;
import JPAEntities.IngToRec;
import JPAEntities.IngToRecPK;
import JPAEntities.Recipes;
import RecipesBL.IngredientAndMeasurement;
import RecipesBL.NewRecipe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jerusalem Live
 */
public class RecipeDAL extends AbstractDAL{
    public static final String FIND_MAX = "Recipes.findMAXID";
    public static final String FIND_ALL = "Recipes.findAll";
    private NewRecipe newRecipe;

    public RecipeDAL(NewRecipe newRecipe) {
        this.newRecipe = newRecipe;
        begin();
    }
    
    public String[] getAllRecipes(){
        List allRecipes = executeQuery(FIND_ALL);
        StringBuffer recipesCSV = new StringBuffer("");
        
        for (Iterator it = allRecipes.iterator(); it.hasNext();) {
            Recipes recipes = (Recipes)it.next();
            recipesCSV.append(recipes.getName());
            recipesCSV.append(", ");
        }
        String[] recipesArray = recipesCSV.toString().split(", ");
        return recipesArray;
    }
    
    public HashMap getRecipesHashMap(){
        List allRecipes = executeQuery(FIND_ALL);
        HashMap recipesMap = new HashMap();
        
        for (Iterator it = allRecipes.iterator(); it.hasNext();) {
            Recipes recipes = (Recipes)it.next();
            recipesMap.put(recipes.getId(), 
                               recipes.getName());
        }
        
        return recipesMap;
    }
    
    public boolean save(){
        Recipes recipes = new Recipes();
        
        int recipeID = getNextIDVal(FIND_MAX); 
        
        recipes.setId(recipeID);
        recipes.setName(newRecipe.getName());
        recipes.setNumOfPortions(newRecipe.getNumOfServings());
        recipes.setDirections(newRecipe.getDirections());
        
        if (!super.commit(recipes))
            return false;
        if (!saveCourses(recipeID))
            return false;
        if (!saveIngredients(recipeID))
            return false;
        
        return true;
    }
    
    private boolean saveCourses(int recipeID){
        ArrayList allCourses = newRecipe.getCourses();
        boolean success;
        for (Iterator it = allCourses.iterator(); it.hasNext();) {
            Integer courseID = (Integer) it.next();
            
            CourseToRec courseToRec = 
                    new CourseToRec(recipeID, courseID);
            if (!super.commit(courseToRec))
                return false;
        }
        
        return true;
    }
    
    private boolean saveIngredients(int recipeID){
        ArrayList allIngredients = newRecipe.getIngredients();
        boolean success;
        for (Iterator it = allIngredients.iterator(); it.hasNext();) {
            IngredientAndMeasurement iam = 
                    (IngredientAndMeasurement) it.next();
            IngToRec ingToRec = new IngToRec(iam.getNIngredientID(), recipeID);
            //ingToRec.setAmount(iam.getFAmount());
            
            if (!super.commit(ingToRec))
                return false;
        }
        
        return true;
    }
}