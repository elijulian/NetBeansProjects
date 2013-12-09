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
public class IngToRecPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ING_ID")
    private int ingId;
    @Basic(optional = false)
    @Column(name = "REC_ID")
    private int recId;

    public IngToRecPK() {
    }

    public IngToRecPK(int ingId, int recId) {
        this.ingId = ingId;
        this.recId = recId;
    }

    public int getIngId() {
        return ingId;
    }

    public void setIngId(int ingId) {
        this.ingId = ingId;
    }

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ingId;
        hash += (int) recId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngToRecPK)) {
            return false;
        }
        IngToRecPK other = (IngToRecPK) object;
        if (this.ingId != other.ingId) {
            return false;
        }
        if (this.recId != other.recId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPAEntities.IngToRecPK[ ingId=" + ingId + ", recId=" + recId + " ]";
    }
    
}
