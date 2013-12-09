/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAEntities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jerusalem Live
 */
@Embeddable
public class CourseToRecPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "REC_ID")
    private int recId;
    @Basic(optional = false)
    @Column(name = "COURSE_ID")
    private int courseId;

    public CourseToRecPK() {
    }

    public CourseToRecPK(int recId, int courseId) {
        this.recId = recId;
        this.courseId = courseId;
    }

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) recId;
        hash += (int) courseId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseToRecPK)) {
            return false;
        }
        CourseToRecPK other = (CourseToRecPK) object;
        if (this.recId != other.recId) {
            return false;
        }
        if (this.courseId != other.courseId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPAEntities.CourseToRecPK[ recId=" + recId + ", courseId=" + courseId + " ]";
    }
    
}
