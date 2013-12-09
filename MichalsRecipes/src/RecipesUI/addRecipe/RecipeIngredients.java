/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesUI.addRecipe;

import RecipesBL.NewRecipe;
import RecipesBL.Validate;
import RecipesUI.BaseFrame;
import RecipesUI.IngredientPanel;
import Utilities.Globals;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jerusalem Live
 */
public class RecipeIngredients extends BaseFrame {

    /**
     * Creates new form RecipeIngredients
     */
    public RecipeIngredients(NewRecipe newRec) {
        newRecipe = newRec;
    }    
    
    @Override
    protected JPanel initMainPanel() {
        allIngredientsPanel = new JPanel();
        allIngredientsPanel.setLayout(new BoxLayout(allIngredientsPanel, 
                                                    BoxLayout.PAGE_AXIS));
        allIngredientPanelsAL = new ArrayList();
        allIngredientsPanel.add(createIngredientPanel());
        allIngredientsPanel.add(createIngredientPanel());
        
        btnAddIngredient = new JButton("Add another ingredient");
        btnAddIngredient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addIngredientPanel();
            }
        });
        
        allPanels = new JPanel();
        allPanels.setLayout(new BoxLayout(allPanels, BoxLayout.PAGE_AXIS));
        
        allPanels.add(allIngredientsPanel);
        allPanels.add(btnAddIngredient);
        
        return allPanels;
    }
    
    private IngredientPanel createIngredientPanel(){
        IngredientPanel ingredientPanel = new IngredientPanel();
        allIngredientPanelsAL.add(ingredientPanel);
        return ingredientPanel;
    }
    
    private void addIngredientPanel(){
        allIngredientsPanel.add(createIngredientPanel());
        pack();
    }

    @Override
    protected void setThisTitle() {
        super.setTitle("Add a new recipe");
    }

    @Override
    protected void initButtonStrings() {
        strNext = "Next";
        strBack = "Back";
    }

    @Override
    protected void next() {
        if (validateEntries()) {
            newRecipe.setIngredients(allIngredientPanelsAL);
            Directions directions = new Directions(newRecipe);
            directions.setVisible(true);
            this.dispose();
        }
    }

    private boolean validateEntries(){
        for (Iterator it = allIngredientPanelsAL.iterator(); it.hasNext();) {
            IngredientPanel ingredient = (IngredientPanel)it.next();
            JTextField txtAmount = ingredient.getTxtAmount();
            String strAmount = txtAmount.getText();
            if (strAmount.isEmpty() ||
                strAmount.equals("")) {
                JOptionPane.showMessageDialog(this, 
                                          Globals.CANNOT_BE_NULL, 
                                          "Cannot be null", 
                                          JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (!Validate.number(strAmount)){
                txtAmount.setText("");
                txtAmount.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, 
                                              Globals.ENTER_NUM, 
                                              "Cannot be null", 
                                              JOptionPane.ERROR_MESSAGE);

                return false;
            } else {
                txtAmount.setBackground(Color.white);
            }
        }
        
        return true;
    }
    
    @Override
    protected void back() {
        RecCourses recCourses = new RecCourses(newRecipe);
        recCourses.setVisible(true);
        this.dispose();
    }

    private NewRecipe newRecipe;
    private JButton   btnAddIngredient;
    private JPanel    allIngredientsPanel;
    private JPanel    allPanels;
    private JLabel    lblInstructions;
    private ArrayList allIngredientPanelsAL;
    
    @SuppressWarnings("unchecked")
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


}
