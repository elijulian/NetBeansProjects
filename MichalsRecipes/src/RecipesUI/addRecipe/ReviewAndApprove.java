package RecipesUI.addRecipe;

import JPAEntities.CourseToRec;
import RecipesBL.CourseManager;
import RecipesBL.IngredientAndMeasurement;
import RecipesBL.IngredientManager;
import RecipesBL.MeasurementManager;
import RecipesBL.NewRecipe;
import RecipesUI.BaseFrame;
import RecipesUI.IngredientPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.Document;

public class ReviewAndApprove extends BaseFrame {

    public ReviewAndApprove(NewRecipe newRec) {
        newRecipe = newRec;
        initInfo();
    }

    @Override
    protected JPanel initMainPanel() {
        generalPanel = new JPanel(new BorderLayout(5, 5));
        ingredientsPanel = new JPanel(new GridLayout(0, 3, 10, 5));
        
        txtDirections = new JTextArea();
        directionsPane = new JScrollPane(txtDirections);
        return generalPanel;
    }

    private void initInfo(){
        ArrayList allIngredientPanels = newRecipe.getIngredients();
        for (Iterator it = allIngredientPanels.iterator(); it.hasNext();) {
            IngredientPanel ingredient = (IngredientPanel)it.next();
            JLabel lblAmount = new JLabel(ingredient.getTxtAmount().getText());
            JLabel lblMeasurement = new JLabel(ingredient.getCmbMeasurements().getSelectedItem().toString());
            JLabel lblIngredient = new JLabel(ingredient.getCmbIngredients().getSelectedItem().toString());
            ingredientsPanel.add(lblAmount);
            ingredientsPanel.add(lblMeasurement);
            ingredientsPanel.add(lblIngredient);
        }
        generalPanel.add(ingredientsPanel, BorderLayout.PAGE_START);
        
        txtDirections = new JTextArea();
        txtDirections.setText(newRecipe.getDirections());
        directionsPane = new JScrollPane(txtDirections);
        txtDirections.setEditable(false);
        generalPanel.add(directionsPane);
        pack();
    }
    
    @Override
    protected void setThisTitle() {
        setTitle("Review and approve");
    }

    @Override
    protected void initButtonStrings() {
        strNext = "Save";
        strBack = "Back";
    }

    @Override
    protected void next() {
        convertCoursesArrayList();
        convertIngredientsArrayList();
        boolean success = newRecipe.save();
        if (success) {
            JOptionPane.showMessageDialog(this, 
                                          "The recipe was saved successfully", 
                                          "Success", 
                                          JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Converts the ArrayList containing the IngredientPanels  into an
     * ArrayList containing object initialized with the values of the 
     * ID's for the ingredient and measurement, plus the amount of the measurement
     * called for in the recipe.
     */
    private void convertIngredientsArrayList(){
        ArrayList ingredientPanels = newRecipe.getIngredients();
        ArrayList finalIngredients = new ArrayList();
        String strIngName;
        Integer nIngredientValue;
        String strMeasurementName;
        Integer nMeasurementID;
        int nAmount;
        Float fAmount;
        
        // Get the managers and HashMaps to perform the conversions from 
        // String to the id's
        IngredientManager iManager = new IngredientManager();
        HashMap ingHashMap = iManager.getAllIngredientsHashMap();
        MeasurementManager mManager = new MeasurementManager();
        HashMap measurementHashMap = mManager.getAllMeasurementsHashMap();
        for (Iterator it = ingredientPanels.iterator(); it.hasNext();) {
            IngredientPanel ingredient = (IngredientPanel)it.next();
            
            // Get the name of the ingredient as chosen in the combobox
            // in the ingredient panel and get it's id from the HashMap
            strIngName = ingredient.getCmbIngredients().getSelectedItem().toString();
            nIngredientValue = (Integer)ingHashMap.get(strIngName);
            
            // Do the same for the measurement
            strMeasurementName = ingredient.getCmbMeasurements().getSelectedItem().toString();
            nMeasurementID = (Integer) measurementHashMap.get(strMeasurementName);
            
            fAmount = Float.parseFloat(ingredient.getTxtAmount().getText());
            IngredientAndMeasurement iam = new IngredientAndMeasurement(nIngredientValue, nMeasurementID, fAmount);
            finalIngredients.add(iam);
        }
        newRecipe.setIngredients(finalIngredients);
    }
    
    private void convertCoursesArrayList(){
        ArrayList finalCourses = new ArrayList();
        ArrayList coursesCombos = newRecipe.getCourses();
        CourseManager cManager = new CourseManager();
        HashMap coursesHashMap = cManager.getAllCoursesHashMap();
        String strMeasurement;
        for (Iterator it = coursesCombos.iterator(); it.hasNext();) {
            JComboBox cmbCourse = (JComboBox)it.next();
            strMeasurement = cmbCourse.getSelectedItem().toString();
            finalCourses.add(coursesHashMap.get(strMeasurement));
        }
        
        newRecipe.setCourses(finalCourses);
    }
    
    @Override
    protected void back() {
        Directions directions = new Directions(newRecipe);
        directions.setVisible(true);
        this.dispose();
    }
    
    private JPanel      generalPanel;
    private JPanel      ingredientsPanel;
    private JScrollPane directionsPane;
    private JTextArea   txtDirections;
    private NewRecipe   newRecipe;
}
/*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
*/
