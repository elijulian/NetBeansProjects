package RecipesUI.addRecipe;

import RecipesBL.CourseManager;
import RecipesBL.NewRecipe;
import RecipesUI.BaseFrame;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RecCourses extends BaseFrame {

    public RecCourses(NewRecipe newRec) {
        newRecipe = newRec;
        initCoursesCombos();
    }

    @Override
    protected JPanel initMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        
        lblInstructions = new JLabel("Please choose which course or courses in which to categorize the recipe");
        mainPanel.add(lblInstructions);
        
        btnAddCourse = new JButton("Add to another course");
        btnAddCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewCourseCombo();
            }
        });
        
        mainPanel.add(createComboPanel());
        mainPanel.add(btnAddCourse);
        return mainPanel;
    }
    
    public JPanel createComboPanel(){
        comboPanel = new JPanel();
        comboPanel.setLayout(new BoxLayout(comboPanel, BoxLayout.PAGE_AXIS));
        
        return comboPanel;
    }

    private JComboBox createNewCourseCombo(){
        JComboBox cmbCourses = null;
        
        if (nNumOfCombos < nNumOfCourses) {
            String[] availableCourses = filterAvailableCourses();
            cmbCourses = new JComboBox(availableCourses);
            AutoCompleteSupport support = 
                    AutoCompleteSupport.install(cmbCourses, 
                                                GlazedLists.eventListOf(availableCourses));
            support.setStrict(true);
            coursesArrayList.add(cmbCourses);
            nNumOfCombos++;
            System.out.print(nNumOfCourses);

        }
        if (nNumOfCombos == nNumOfCourses-1) {
            btnAddCourse.setEnabled(false);
        }
        
        return cmbCourses;
    }
    
    private String[] filterAvailableCourses(){
        CourseManager courseMgr = new CourseManager();
        String strCourses = courseMgr.getAllCoursesCSV();
        for (Iterator it = coursesArrayList.iterator(); it.hasNext();) {
            JComboBox jComboBox = (JComboBox)it.next();
            String selectedCourse = jComboBox.getSelectedItem().toString();
            selectedCourse += ",";
            if (strCourses.contains(selectedCourse)) {
                strCourses = strCourses.replace(selectedCourse, "");
            }
        }
        if (strCourses.equals("")) {
            return null;
        } else {
            return strCourses.split(",");
        }
    }
    
    public void addNewCourseCombo(){
        JComboBox cmbCourses = createNewCourseCombo();
        comboPanel.add(cmbCourses);
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
        ArrayList chosenCoursesAL = new ArrayList();
        for (Iterator it = coursesArrayList.iterator(); it.hasNext();) {
            JComboBox jComboBox = (JComboBox)it.next();
            chosenCoursesAL.add(jComboBox);
        }
        
        newRecipe.setCourses(chosenCoursesAL);
        RecipeIngredients recIng = new RecipeIngredients(newRecipe);
        recIng.setVisible(true);
        this.dispose();
    }

    @Override
    protected void back() {
        NameAndServings nameAndServings = new NameAndServings(newRecipe);
        nameAndServings.setVisible(true);
        this.dispose();
    }
    
    private void initCoursesCombos(){
        coursesArrayList = newRecipe.getCourses();
        if (coursesArrayList == null) {
            coursesArrayList = new ArrayList();
            nNumOfCourses = new CourseManager().getCoursesCount();

            comboPanel.add(createNewCourseCombo());
        } else {
            for (Iterator it = coursesArrayList.iterator(); it.hasNext();) {
                JComboBox jComboBox = (JComboBox)it.next();
                comboPanel.add(jComboBox);
            }
        }
        pack(); 
    }
    
    private NewRecipe newRecipe;
    private JPanel    mainPanel;
    private JPanel    comboPanel;
    private ArrayList coursesArrayList;
    private JLabel    lblInstructions;
    private JButton   btnAddCourse;
    private int       nNumOfCourses;
    private int       nNumOfCombos = 0;
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
