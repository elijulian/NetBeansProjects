/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesUI.addRecipe;

import RecipesBL.NewRecipe;
import RecipesBL.Validate;
import RecipesUI.BaseFrame;
import RecipesUI.StartScreen;
import Utilities.Globals;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jerusalem Live
 */
public class NameAndServings extends BaseFrame {
  
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
    */
    
    public NameAndServings(NewRecipe newRec) {
        newRecipe = newRec;
        if (newRecipe != null) {
            initFields();
        }
    }

    @Override
    protected void setThisTitle(){
        setTitle("Add a recipe");
    }
    
    @Override
    protected JPanel initMainPanel() {
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        
        lblInstructions = new JLabel("Please enter the name \n and number of portions");
        textPanel.add(lblInstructions);
        
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        lblName = new JLabel("Name:");
        txtName = new JTextField(10);
        namePanel.add(lblName);
        namePanel.add(Box.createGlue());
        namePanel.add(txtName);
        textPanel.add(namePanel);
        
        JPanel servingsPanel = new JPanel();
        servingsPanel.setLayout(new BoxLayout(servingsPanel, BoxLayout.LINE_AXIS));
        lblServings = new JLabel("Number of servings:");
        txtServings = new JTextField(3);
        servingsPanel.add(lblServings);
        servingsPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        servingsPanel.add(txtServings);
        
        textPanel.add(servingsPanel);
        
        return textPanel;
    }

    private void initFields(){
        txtName.setText(newRecipe.getName());
        txtServings.setText(newRecipe.getNumOfServings().toString());
    }
    
    @Override
    protected void initButtonStrings(){
        strBack = "Back";
        strNext = "Next";
    }
    
    @Override
    protected void back(){
        StartScreen startScreen = new StartScreen();
        startScreen.setVisible(true);
        this.dispose();
    }
    
    @Override
    protected void next(){
        if(validateSubmition()){
            newRecipe = new NewRecipe();
            newRecipe.setName(txtName.getText());
            newRecipe.setNumOfServings(Integer.parseInt(txtServings.getText()));
            RecCourses recCourses = new RecCourses(newRecipe);
            recCourses.setVisible(true);
            this.dispose();
        }
    }
    
    private boolean validateSubmition(){
        String name = this.txtName.getText();
        String amount = this.txtServings.getText();
        
        if (name == null ||
            name.equals("") ||
            amount == null ||
            amount.equals("")) {
            JOptionPane.showMessageDialog(this, 
                                          Globals.CANNOT_BE_NULL, 
                                          "Cannot be null", 
                                          JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!Validate.text(name)) {
            this.txtName.setBackground(Color.red);
            this.txtName.setText("");
            JOptionPane.showMessageDialog(this, 
                                          Globals.ENTER_TEXT, 
                                          "Cannot be null", 
                                          JOptionPane.ERROR_MESSAGE);
            
            return false;
        } else if(!Validate.number(amount)){
            this.txtServings.setBackground(Color.red);
            this.txtServings.setText("");
            this.txtName.setBackground(Color.white);
            JOptionPane.showMessageDialog(this, 
                                          Globals.ENTER_NUM, 
                                          "Cannot be null", 
                                          JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        
        return true;
    }
    
    private JPanel     textPanel;
    private JLabel     lblName;
    private JLabel     lblServings;
    private JTextField txtName;
    private JLabel     lblInstructions;
    private JTextField txtServings;
    private NewRecipe  newRecipe;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    
}
