/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAEntities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jerusalem Live
 */
@Entity
@Table(name = "SOLID_MEASUREMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolidMeasurements.findAll", query = "SELECT s FROM SolidMeasurements s"),
    @NamedQuery(name = "SolidMeasurements.findByIngId", query = "SELECT s FROM SolidMeasurements s WHERE s.ingId = :ingId"),
    @NamedQuery(name = "SolidMeasurements.findByCupG", query = "SELECT s FROM SolidMeasurements s WHERE s.cupG = :cupG"),
    @NamedQuery(name = "SolidMeasurements.findByTbsG", query = "SELECT s FROM SolidMeasurements s WHERE s.tbsG = :tbsG"),
    @NamedQuery(name = "SolidMeasurements.findByTspG", query = "SELECT s FROM SolidMeasurements s WHERE s.tspG = :tspG")})
public class SolidMeasurements implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ING_ID")
    private Integer ingId;
    @Column(name = "CUP_G")
    private Float cupG;
    @Column(name = "TBS_G")
    private Float tbsG;
    @Column(name = "TSP_G")
    private Float tspG;

    public SolidMeasurements() {
    }

    public SolidMeasurements(Integer ingId) {
        this.ingId = ingId;
    }

    public Integer getIngId() {
        return ingId;
    }

    public void setIngId(Integer ingId) {
        this.ingId = ingId;
    }

    public Float getCupG() {
        return cupG;
    }

    public void setCupG(Float cupG) {
        this.cupG = cupG;
    }

    public Float getTbsG() {
        return tbsG;
    }

    public void setTbsG(Float tbsG) {
        this.tbsG = tbsG;
    }

    public Float getTspG() {
        return tspG;
    }

    public void setTspG(Float tspG) {
        this.tspG = tspG;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingId != null ? ingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolidMeasurements)) {
            return false;
        }
        SolidMeasurements other = (SolidMeasurements) object;
        if ((this.ingId == null && other.ingId != null) || (this.ingId != null && !this.ingId.equals(other.ingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.SolidMeasurements[ ingId=" + ingId + " ]";
    }
    
}
