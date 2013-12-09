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
@Table(name = "RECIPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipes.findAll", query = "SELECT r FROM Recipes r"),
    @NamedQuery(name = "Recipes.findById", query = "SELECT r FROM Recipes r WHERE r.id = :id"),
    @NamedQuery(name = "Recipes.findByName", query = "SELECT r FROM Recipes r WHERE r.name = :name"),
    @NamedQuery(name = "Recipes.findByNumOfPortions", query = "SELECT r FROM Recipes r WHERE r.numOfPortions = :numOfPortions"),
    @NamedQuery(name = "Recipes.findByDirections", query = "SELECT r FROM Recipes r WHERE r.directions = :directions"),
    @NamedQuery(name = "Recipes.findMAXID", query = "SELECT max(i.id) FROM Ingredients i")})
public class Recipes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "NUM_OF_PORTIONS")
    private Integer numOfPortions;
    @Column(name = "DIRECTIONS")
    private String directions;

    public Recipes() {
    }

    public Recipes(Integer id) {
        this.id = id;
    }

    public Recipes(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Integer getNumOfPortions() {
        return numOfPortions;
    }

    public void setNumOfPortions(Integer numOfPortions) {
        this.numOfPortions = numOfPortions;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
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
        if (!(object instanceof Recipes)) {
            return false;
        }
        Recipes other = (Recipes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPAEntities.Recipes[ id=" + id + " ]";
    }
    
}
