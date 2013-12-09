/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import RecipesUI.StartScreen;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jerusalem Live
 */
public class MainClass {
    public static void main(String[] args){
         try {
                // Set System L&F
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException | 
               ClassNotFoundException | 
               InstantiationException | 
               IllegalAccessException e) {
           // handle exception
        }
        
        StartScreen startScreen = new StartScreen();
        startScreen.setVisible(true);
    }
}
