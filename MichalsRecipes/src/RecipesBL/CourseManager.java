/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecipesBL;

import DAL.CoursesDAL;
import java.util.HashMap;
/**
 *
 * @author EliandMichal
 */
public class CourseManager {
    private CoursesDAL dal;

    public CourseManager() {
        dal = new CoursesDAL(null);
    }
    
    public HashMap getAllCoursesHashMap(){
        return dal.getCoursesHashMap();
    }
    
    public String[] getAllCoursesArray(){
        return dal.getAllCourses();
    }
    
    public String getAllCoursesCSV(){
        return dal.getAllCoursesCSV();
    }
    
    public int getCoursesCount(){
        return dal.getCoursesCount();
    }
}
