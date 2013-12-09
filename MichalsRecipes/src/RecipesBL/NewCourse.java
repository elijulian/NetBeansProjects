/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesBL;

import DAL.CoursesDAL;
/**
 *
 * @author Jerusalem Live
 */
public class NewCourse {
    
    private String name;

    public NewCourse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public boolean save(){
        CoursesDAL dal = new CoursesDAL(this);
        return dal.save();
    }
}
