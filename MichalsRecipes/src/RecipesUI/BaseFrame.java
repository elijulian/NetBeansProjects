package RecipesUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public abstract class BaseFrame extends JFrame {

    public BaseFrame() {
       initComponents();
    }

    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        imagePanel = GeneralUI.createImagePanel();
        generalPanel = new JPanel();
        generalPanel.setSize(imagePanel.getSize());
        allPanels = new JPanel();
        allPanels.add(imagePanel);
        allPanels.add(initGeneralPanel());
        add(allPanels);
        pack();
    }
    
    abstract protected JPanel initMainPanel();
    abstract protected void setThisTitle();
    abstract protected void initButtonStrings();
    abstract protected void next();
    abstract protected void back();
    
    private JPanel initGeneralPanel(){
        generalPanel = new JPanel();
        generalPanel.setLayout(new BorderLayout());
        generalPanel.add(initMainPanel(), BorderLayout.CENTER);
        generalPanel.add(initButtonPanel(), BorderLayout.PAGE_END);
        return generalPanel;
    }
    
    protected JPanel initButtonPanel() {
        initButtonStrings();
        btnBack = new JButton(strBack);
        btnNext = new JButton(strNext);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                next();
            }
        });
        getRootPane().setDefaultButton(btnNext);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(btnBack);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        buttonPanel.add(btnNext);
        
        return buttonPanel;
    }
    
    private   JPanel allPanels;
    private   JPanel imagePanel;
    private   JPanel generalPanel;
    private   JPanel buttonPanel;
    private   JButton btnNext;
    private   JButton btnBack;
    protected String strNext;
    protected String strBack;
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