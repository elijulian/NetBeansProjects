package RecipesUI;

import RecipesBL.NewIngredient;
import RecipesBL.Validate;
import Utilities.Globals;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddIngredient extends BaseFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveData(){
        String name = this.txtName.getText();
        String amount = this.txtAmountSold.getText();
        boolean indDivisible = this.chbxIndDivisible.isSelected();
        boolean indLiquid = rdbtLiquid.isSelected();
        NewIngredient newIngredient = new NewIngredient(name, 
                                                        amount, 
                                                        indDivisible, 
                                                        indLiquid);
        
        if(newIngredient.save()){
            
            this.txtAmountSold.setBackground(Color.white);
            this.txtName.setBackground(Color.white);
            this.txtAmountSold.setText("");
            this.txtName.setText("");
            JOptionPane.showMessageDialog(this, 
                                          "The entry was saved successfully"); 
            
        }
    }
    
    private boolean validateSubmition(){
        String name = this.txtName.getText();
        String amount = this.txtAmountSold.getText();
        
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
            this.txtAmountSold.setBackground(Color.red);
            this.txtAmountSold.setText("");
            this.txtName.setBackground(Color.white);
            JOptionPane.showMessageDialog(this, 
                                          Globals.ENTER_NUM, 
                                          "Cannot be null", 
                                          JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        
        return true;
    }
    
    private JPanel createEnterTextPanel(){
        enterTextPanel = new JPanel();
        enterTextPanel.setLayout(new BoxLayout(enterTextPanel, BoxLayout.PAGE_AXIS));
        enterTextPanel.add(createNamePanel());
        enterTextPanel.add(createAmountPanel());
        
        return enterTextPanel;
    }
    
    private JPanel createIndsPanel(){
        indsPanel = new JPanel();
        indsPanel.setLayout(new BoxLayout(indsPanel, BoxLayout.PAGE_AXIS));
        rdbtLiquid = new JRadioButton("Liquid");
        rdbtSolid = new JRadioButton("Solid");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtLiquid);
        buttonGroup.add(rdbtSolid);
        chbxIndDivisible = new JCheckBox("Divisible");
        rdbtSolid.setSelected(true);
        indsPanel.add(rdbtSolid);
        indsPanel.add(rdbtLiquid);
        indsPanel.add(chbxIndDivisible);
        lblHiddenMsg = new JLabel();
        return indsPanel;
    }
    
    private JPanel createNamePanel(){
        namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        lblName = new JLabel("Name");
        txtName = new JTextField(10);
        namePanel.add(Box.createHorizontalGlue());
        namePanel.add(lblName);
        namePanel.add(txtName);
        return namePanel;
    }
    
    private JPanel createAmountPanel(){
        amountPanel = new JPanel();
        amountPanel.setLayout(new BoxLayout(amountPanel, BoxLayout.LINE_AXIS));
        lblAmountSold = new JLabel("Amount as sold");
        txtAmountSold = new JTextField(10);
        amountPanel.add(Box.createHorizontalGlue());
        amountPanel.add(lblAmountSold);
        amountPanel.add(txtAmountSold);
        return amountPanel;
    }
    
     @Override
    protected JPanel initMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(createEnterTextPanel(), BorderLayout.PAGE_START);
        mainPanel.add(createIndsPanel(), BorderLayout.CENTER);
        return mainPanel;
    }
    
    @Override
    protected void setThisTitle(){
        setTitle("Add a new ingredient");
    }
    
    @Override
    public void back(){
        StartScreen startScreen = new StartScreen();
        startScreen.setVisible(true);
        this.dispose();
    }
    
    @Override
    public void next(){
         if (validateSubmition()) {
            saveData();
        }
        pack();
    }
    
    @Override
    protected void initButtonStrings() {
        strBack = "Cancel";
        strNext = "Submit";
    }

   
    
    private JPanel mainPanel;
    private JPanel namePanel;
    private JPanel amountPanel;
    private JPanel enterTextPanel;
    private JLabel lblHiddenMsg;
    private JPanel buttonPanel;
    private JPanel indsPanel;
    private JButton btnCancel;
    private JLabel lblAmountSold;
    private JLabel lblName;
    private JTextField txtAmountSold;
    private JTextField  txtName;
    private JRadioButton rdbtLiquid;
    private JRadioButton rdbtSolid;
    private JCheckBox chbxIndDivisible;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    // End of variables declaration//GEN-END:variables

    
}
