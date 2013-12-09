/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesUI;

import Utilities.Globals;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jerusalem Live
 */
public class GeneralUI {
    public static JPanel createImagePanel(){
        JPanel imagePanel = new JPanel();
        ImageIcon image = new ImageIcon(Globals.SIDE_IMAGE);
        JLabel lblImage = new JLabel(image);
        imagePanel.add(lblImage);
        return imagePanel;
    }
}