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
@Table(name = "INGREDIENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingredients.findAll", query = "SELECT i FROM Ingredients i"),
    @NamedQuery(name = "Ingredients.findById", query = "SELECT i FROM Ingredients i WHERE i.id = :id"),
    @NamedQuery(name = "Ingredients.findByName", query = "SELECT i FROM Ingredients i WHERE i.name = :name"),
    @NamedQuery(name = "Ingredients.findByAmountSold", query = "SELECT i FROM Ingredients i WHERE i.amountSold = :amountSold"),
    @NamedQuery(name = "Ingredients.findByIndDivisible", query = "SELECT i FROM Ingredients i WHERE i.indDivisible = :indDivisible"),
    @NamedQuery(name = "Ingredients.findByIndLiquid", query = "SELECT i FROM Ingredients i WHERE i.indLiquid = :indLiquid"),
    @NamedQuery(name = "Ingredients.findMAXID", query = "SELECT max(i.id) FROM Ingredients i")})
public class Ingredients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AMOUNT_SOLD")
    private Integer amountSold;
    @Column(name = "IND_DIVISIBLE")
    private Integer indDivisible;
    @Column(name = "IND_LIQUID")
    private Integer indLiquid;

    public Ingredients() {
    }

    public Ingredients(Integer id) {
        this.id = id;
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

    public Integer getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(Integer amountSold) {
        this.amountSold = amountSold;
    }

    public Integer getIndDivisible() {
        return indDivisible;
    }

    public void setIndDivisible(Integer indDivisible) {
        this.indDivisible = indDivisible;
    }

    public Integer getIndLiquid() {
        return indLiquid;
    }

    public void setIndLiquid(Integer indLiquid) {
        this.indLiquid = indLiquid;
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
        if (!(object instanceof Ingredients)) {
            return false;
        }
        Ingredients other = (Ingredients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPAEntities.Ingredients[ id=" + id + " ]";
    }
    
}
