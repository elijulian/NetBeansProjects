/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import JPAEntities.Courses;
import RecipesBL.NewCourse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jerusalem Live
 */
public class CoursesDAL extends AbstractDAL{
    public static final String FIND_MAX = "Courses.findMAXID";
    public static final String FIND_ALL = "Courses.findAll";
    public static final String COUNT    = "Courses.GetTotalCount";
    private NewCourse newCourse;

    public CoursesDAL(NewCourse newCourse) {
        this.newCourse = newCourse;
        begin();
    }
    
    public String[] getAllCourses(){
        List allCourses = executeQuery(FIND_ALL);
        StringBuffer coursesCSV = new StringBuffer("");
        
        for (Iterator it = allCourses.iterator(); it.hasNext();) {
            Courses courses = (Courses)it.next();
            coursesCSV.append(courses.getName());
            coursesCSV.append(", ");
        }
        String[] coursesArray = coursesCSV.toString().split(", ");
        return coursesArray;
    }
    
    public String getAllCoursesCSV(){
        List allCourses = executeQuery(FIND_ALL);
        StringBuffer coursesCSV = new StringBuffer("");
        
        for (Iterator it = allCourses.iterator(); it.hasNext();) {
            Courses courses = (Courses)it.next();
            coursesCSV.append(courses.getName());
            coursesCSV.append(",");
        }
        return coursesCSV.toString();
    }
    
    public HashMap getCoursesHashMap(){
        List allCourses = executeQuery(FIND_ALL);
        HashMap coursesMap = new HashMap();
        
        for (Iterator it = allCourses.iterator(); it.hasNext();) {
            Courses courses = (Courses)it.next();
            coursesMap.put(courses.getName(),
                           courses.getId());
        }
        
        return coursesMap;
    }
    
    public boolean save(){
        Courses courses = new Courses();
        
        courses.setId(getNextIDVal(FIND_MAX));
        courses.setName(newCourse.getName());
        
        return super.commit(courses);
    }
    
    public int getCoursesCount(){
        return Integer.parseInt(getSingleResult(COUNT).toString());
    }
}
