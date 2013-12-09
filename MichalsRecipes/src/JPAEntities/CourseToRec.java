/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAEntities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jerusalem Live
 */
@Entity
@Table(name = "COURSE_TO_REC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseToRec.findAll", query = "SELECT c FROM CourseToRec c"),
    @NamedQuery(name = "CourseToRec.findByRecId", query = "SELECT c FROM CourseToRec c WHERE c.courseToRecPK.recId = :recId"),
    @NamedQuery(name = "CourseToRec.findByCourseId", query = "SELECT c FROM CourseToRec c WHERE c.courseToRecPK.courseId = :courseId")})
public class CourseToRec implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CourseToRecPK courseToRecPK;

    public CourseToRec() {
    }

    public CourseToRec(CourseToRecPK courseToRecPK) {
        this.courseToRecPK = courseToRecPK;
    }

    public CourseToRec(int recId, int courseId) {
        this.courseToRecPK = new CourseToRecPK(recId, courseId);
    }

    public CourseToRecPK getCourseToRecPK() {
        return courseToRecPK;
    }

    public void setCourseToRecPK(CourseToRecPK courseToRecPK) {
        this.courseToRecPK = courseToRecPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseToRecPK != null ? courseToRecPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseToRec)) {
            return false;
        }
        CourseToRec other = (CourseToRec) object;
        if ((this.courseToRecPK == null && other.courseToRecPK != null) || (this.courseToRecPK != null && !this.courseToRecPK.equals(other.courseToRecPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPAEntities.CourseToRec[ courseToRecPK=" + courseToRecPK + " ]";
    }
    
}
