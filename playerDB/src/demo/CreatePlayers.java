/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jerusalem Live
 */
public class CreatePlayers {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("playerDBPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();

        Player p1 = new Player();
        p1.setId(5);
        p1.setFirstname("Ian");
        p1.setJerseynumber(30);
        p1.setLastname("Thorpe");
        p1.setLastspokenwords("I am in the best form");
        em.persist(p1);

        Player p2 = new Player();
        p2.setId(6);
        p2.setFirstname("Deigo");
        p2.setJerseynumber(40);
        p2.setLastname("Maradona");
        p2.setLastspokenwords("I will be back");
        em.persist(p2);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
