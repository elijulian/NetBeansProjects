/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesUI;

import RecipesBL.IngredientManager;
import RecipesBL.MeasurementManager;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jerusalem Live
 */
public class IngredientPanel extends JPanel{
    
    private JLabel lblAmount;
    private JTextField txtAmount;
    private JComboBox cmbIngredients;
    private JComboBox cmbMeasurements;
    private EventList eventList;
    private AutoCompleteSupport measSupport;
   
    private JComboBox initMeasurements(){
        MeasurementManager mesMan = new MeasurementManager();
        String[] measurementVals = mesMan.getAllMeasurements();
        JComboBox combo = new JComboBox(measurementVals);
        eventList = GlazedLists.eventListOf(measurementVals);
        measSupport = 
                AutoCompleteSupport.install(combo, 
                                            eventList);
        measSupport.setStrict(true);
        return combo;
    }
    
    private JComboBox initIngredients(){
        IngredientManager ingMan = new IngredientManager();
        String[] ingredientVals = ingMan.getAllIngredientsCSV();
        JComboBox combo = new JComboBox(ingredientVals);
        AutoCompleteSupport support = 
                AutoCompleteSupport.install(combo, 
                                            GlazedLists.eventListOf(ingredientVals));
        support.setStrict(true);
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeMeasurementsIfIngUndivisible();
            }
        });
        return combo;
    }

    public IngredientPanel(){
        setLayout(new FlowLayout());
        lblAmount = new JLabel("Amount");
        txtAmount = new JTextField(2);
        cmbMeasurements = initMeasurements();
        cmbIngredients = initIngredients();
        
        add(lblAmount);
        add(txtAmount);
        add(cmbMeasurements);
        add(cmbIngredients);
        setBorder(BorderFactory.createTitledBorder("New Ingredient"));
    }

    public JComboBox getCmbMeasurements() {
        return cmbMeasurements;
    }

    public JComboBox getCmbIngredients() {
        return cmbIngredients;
    }

    public JTextField getTxtAmount() {
        return txtAmount;
    }
    
    public void removeMeasurementsIfIngUndivisible(){
        String ingName = cmbIngredients.getSelectedItem().toString();
        IngredientManager iManager = new IngredientManager();
        if (iManager.isUndivisible(ingName)) {
            Dimension size = cmbMeasurements.getSize();
            measSupport.uninstall();
            cmbMeasurements.setModel(new DefaultComboBoxModel(new String[]{"        "}));
            cmbMeasurements.setSize(size);
//            eventList.clear();
//            eventList = GlazedLists.eventListOf(new String[]{""});
        }
    }
}
