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

@Entity
@Table(schema="Michal", name = "MEASUREMENTS")
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "Measurements.findAll", query = "SELECT m FROM Measurements m"),
    @NamedQuery(name = "Measurements.findById", query = "SELECT m FROM Measurements m WHERE m.id = :id"),
    @NamedQuery(name = "Measurements.findSolidAmountById", query = "SELECT m.amountG FROM Measurements m WHERE m.id = :id"),
    @NamedQuery(name = "Measurements.findLiquidAmountById", query = "SELECT m.amountML FROM Measurements m WHERE m.id = :id"),
    @NamedQuery(name = "Measurements.findByName", query = "SELECT m FROM Measurements m WHERE m.name = :name"),
    @NamedQuery(name = "Measurements.findByAmountG", query = "SELECT m FROM Measurements m WHERE m.amountG = :amountG"),
    @NamedQuery(name = "Measurements.findMAXID", query = "SELECT MAX(m.id) FROM Measurements m")})
public class Measurements implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "AMOUNT_G")
    private float amountG;
    @Basic(optional = false)
    @Column(name = "AMOUNT_ML")
    private float amountML;
    

    public Measurements() {
    }

    public Measurements(Integer id) {
        this.id = id;
    }

    public Measurements(Integer id, String name, int amountG) {
        this.id = id;
        this.name = name;
        this.amountG = amountG;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmountG() {
        return amountG;
    }

    public void setAmountG(float amountG) {
        this.amountG = amountG;
    }
    
    public float getAmountML(){
        return amountML;
    }
    
    public void setAmountML(float amountML){
        this.amountML = amountML;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Measurements)) {
            return false;
        }
        Measurements other = (Measurements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPAEntities.Measurements[ id=" + id + " ]";
    }
    
}
