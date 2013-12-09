/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAEntities;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "ING_TO_REC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngToRec.findAll", query = "SELECT i FROM IngToRec i"),
    @NamedQuery(name = "IngToRec.findByIngId", query = "SELECT i FROM IngToRec i WHERE i.ingToRecPK.ingId = :ingId"),
    @NamedQuery(name = "IngToRec.findByRecId", query = "SELECT i FROM IngToRec i WHERE i.ingToRecPK.recId = :recId"),
    @NamedQuery(name = "IngToRec.findByAmount", query = "SELECT i FROM IngToRec i WHERE i.amount = :amount")})
public class IngToRec implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngToRecPK ingToRecPK;
    @Column(name = "AMOUNT")
    private Float amount;

    public IngToRec() {
    }

    public IngToRec(IngToRecPK ingToRecPK) {
        this.ingToRecPK = ingToRecPK;
    }

    public IngToRec(int ingId, int recId) {
        this.ingToRecPK = new IngToRecPK(ingId, recId);
    }

    public IngToRecPK getIngToRecPK() {
        return ingToRecPK;
    }

    public void setIngToRecPK(IngToRecPK ingToRecPK) {
        this.ingToRecPK = ingToRecPK;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingToRecPK != null ? ingToRecPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngToRec)) {
            return false;
        }
        IngToRec other = (IngToRec) object;
        if ((this.ingToRecPK == null && other.ingToRecPK != null) || (this.ingToRecPK != null && !this.ingToRecPK.equals(other.ingToRecPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPAEntities.IngToRec[ ingToRecPK=" + ingToRecPK + " ]";
    }
    
}
