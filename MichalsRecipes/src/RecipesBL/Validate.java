/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesBL;

/**
 *
 * @author Jerusalem Live
 */
public class Validate {
    
    /**
     * Checks that the string received does not contain numbers
     * @param text
     * @return 
     */
    public static boolean text(String text){
        for (char c : text.toCharArray()) {
            if (!Character.isLetter(c)) {
                if(c != ' '){
                return false;
                    
                }
            }
        }
        
        return true;
    }
    
    /**
     * Checks if the String received is a number
     * 
     */
    public static boolean number(String number){
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        
        return true;
    }
}
