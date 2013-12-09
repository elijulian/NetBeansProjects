package RecipesBL;

public class IngredientAndMeasurement {

    public IngredientAndMeasurement(Integer nIngredient, Integer nMeasurement, Float fAmount) {
        this.nIngredientID = nIngredient;
        this.nMeasurementID = nMeasurement;
        this.fAmount =fAmount;
    }
    
    private Integer nIngredientID;
    private Integer nMeasurementID;
    private Float fAmount;

    public Float getFAmount() {
        return fAmount;
    }

    public void setFAmount(Float nAmount) {
        this.fAmount = nAmount;
    }

    public Integer getNMeasurementID() {
        return nMeasurementID;
    }

    public void setNMeasurementID(Integer strMeasurementName) {
        this.nMeasurementID = strMeasurementName;
    }
    
    public Integer getNIngredientID() {
        return nIngredientID;
    }

    public void setNIngredientID(Integer nIngredient) {
        this.nIngredientID = nIngredient;
    }

    
}
