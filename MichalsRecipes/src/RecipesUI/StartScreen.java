/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesUI;

import RecipesUI.addRecipe.NameAndServings;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author EliandMichal
 */
public class StartScreen extends JFrame {

    /**
     * Creates new form StartScreen
     */
    public StartScreen() {
       // super();
        myInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddIngredient = new javax.swing.JButton();
        btnAddRecipe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To Michal's Recipes!");

        btnAddIngredient.setText("Add Ingredient");
        btnAddIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddIngredientActionPerformed(evt);
            }
        });

        btnAddRecipe.setText("Add Recipe");
        btnAddRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecipeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddIngredient, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddRecipe, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddIngredient, btnAddRecipe});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnAddIngredient)
                .addGap(27, 27, 27)
                .addComponent(btnAddRecipe)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddIngredientActionPerformed
        // Call the AddIngredient screen
        AddIngredient addIngredient = new AddIngredient();
        addIngredient.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddIngredientActionPerformed

    private void btnAddRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecipeActionPerformed
        // Call the AddRecipe screen
        /*AddRecipe addRecipe = new AddRecipe();
        addRecipe.setVisible(true);*/
        NameAndServings nameAndServings = new NameAndServings(null);
        nameAndServings.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddRecipeActionPerformed

    private void myInitComponents(){       
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To Michal's Recipes!");
        generalPanel = new JPanel();
        generalPanel.setLayout(new BoxLayout(generalPanel, BoxLayout.PAGE_AXIS));
        generalPanel.add(createImagePanel());
        generalPanel.add(createButtonPanel());
        add(generalPanel);
        pack();
    }
    
    public JPanel createButtonPanel(){
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        btnAddIngredient = new JButton("Add Ingredient");
        btnAddRecipe = new JButton("Add Recipe");



        btnAddIngredient.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddIngredientActionPerformed(evt);
            }
        });

        btnAddRecipe.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecipeActionPerformed(evt);
            }
        });
        
        buttonPanel.add(btnAddIngredient);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(btnAddRecipe);
        
        return buttonPanel;
    }
    
    public JPanel createImagePanel(){
        imagePanel =  new JPanel();
        ImageIcon image = new ImageIcon("C:/Users/Jerusalem Live/Documents/NetBeansProjects/MichalsRecipes/image.png");
        imagePanel.add(new JLabel(image));
        return imagePanel;
    }
    
    private JPanel imagePanel;
    private JPanel buttonPanel;
    private JPanel generalPanel;   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddIngredient;
    private javax.swing.JButton btnAddRecipe;
    // End of variables declaration//GEN-END:variables
}
