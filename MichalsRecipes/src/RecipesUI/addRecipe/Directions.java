package RecipesUI.addRecipe;

import RecipesBL.NewRecipe;
import RecipesUI.BaseFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Directions extends BaseFrame {

    public Directions(NewRecipe newRec) {
        newRecipe = newRec;
    }

    @Override
    protected JPanel initMainPanel() {
        generalPanel = new JPanel(new BorderLayout(10, 10));
        generalPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        lblInstructions = new JLabel("Please enter the directions for the recipe");
        generalPanel.add(lblInstructions, BorderLayout.PAGE_START);
        
        txtaDirections = new JTextArea();
        txtaDirections.setWrapStyleWord(true);
        txtaDirections.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(txtaDirections);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(350, 250));
        generalPanel.add(scrollPane);
        
        return generalPanel;
    }

    @Override
    protected void setThisTitle() {
        super.setTitle("Enter directions");
    }

    @Override
    protected void initButtonStrings() {
        strNext = "Next";
        strBack = "Back";
    }

    @Override
    protected void next() {
        newRecipe.setDirections(txtaDirections.getText());
        ReviewAndApprove reviewAndApprove = new ReviewAndApprove(newRecipe);
        reviewAndApprove.setVisible(true);
        this.dispose();
    }
    
    @Override
    protected void back() {
        RecipeIngredients recipeIngredients = new RecipeIngredients(newRecipe);
        recipeIngredients.setVisible(true);
        this.dispose();
    }
    
    private NewRecipe newRecipe;
    private JLabel    lblInstructions;
    private JTextArea txtaDirections;
    private JPanel    generalPanel;
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
}*/
