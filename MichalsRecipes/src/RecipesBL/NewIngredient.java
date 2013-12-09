/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesBL;

import DAL.IngredientDAL;
/**
 *
 * @author Jerusalem Live
 */
public class NewIngredient {
    
    private String name;
    private Integer amountSold;
    private int indDivisible;
    private int indLiquid;

    public NewIngredient(String name, 
                         String amountSold, 
                         boolean indDivisible,
                         boolean indLiquid) {
        this.name = name;
        this.amountSold = Integer.parseInt(amountSold);
        this.indDivisible = indDivisible?1:0;
        this.indLiquid = indLiquid?1:0;
    }
    
    public int isIndDivisible() {
        return indDivisible;
    }
    
    public int isIndLiquid(){
        return indLiquid;
    }

    public Integer getAmountSold() {
        return amountSold;
    }

    public String getName() {
        return name;
    }
    
    

    public boolean save(){
        IngredientDAL dal = new IngredientDAL(this);
        return dal.save();
    }
}
