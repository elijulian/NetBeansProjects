/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Utilities.Globals;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author EliandMichal
 */
public class AbstractDAL {
    private EntityManagerFactory emf;
    private EntityManager eManager;
    private EntityTransaction transaction;
    
    protected void begin(){
        emf = Persistence.createEntityManagerFactory(
                Globals.PU_NAME/*name of Persistence Unit as per <name> tag*/);
        eManager = emf.createEntityManager();
        transaction = eManager.getTransaction();
        transaction.begin();
    }
    
    protected int getNextIDVal(String GET_MAX_ID){
        int nextValInt = (int)getSingleResult(GET_MAX_ID);
        return ++nextValInt;
    }
    
    protected boolean commit(Object rowToCommit){
        try {
            eManager.persist(rowToCommit);
            transaction.commit();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
        
        return true;
    }
    
    protected Object getSingleResult(String namedQuery){
        Query query = eManager.createNamedQuery(namedQuery);
        return query.getSingleResult();
    }
    
    protected Object getSingleResult(
            String namedQuery, 
            String paramName, 
            Object param){
        Query query = eManager.createNamedQuery(namedQuery);
        query.setParameter(paramName, param);
        return query.getSingleResult();
    }
    
    protected Object getSingleResult(
            String namedQuery, 
            String[] paramNames, 
            Object[] params){
        Query query = eManager.createNamedQuery(namedQuery);
        for (int i = 0; i < paramNames.length; i++) {
            query.setParameter(paramNames[i], params[i]);
        }
        return query.getSingleResult();
    }
    
    protected Object getSingleResult(
            String namedQuery,
            Map params){
        for (Map.Entry currEntry : params.entrySet()) {
            Object paramName = currEntry.getKey();
            Object object1 = currEntry.getValue();
            
        }
        return null;
    }
      
    protected List executeQuery (String namedQuery){
        Query query = eManager.createNamedQuery(namedQuery);
        return query.getResultList();
    }
    
    protected List executeQuery (String namedQuery, Object param){
        Query query = eManager.createNamedQuery(namedQuery);
        query.setParameter(0, param);
        return query.getResultList();
    }
    
    protected List executeQuery(
            String namedQuery,
            Object[] params){
        Query query = eManager.createNamedQuery(namedQuery);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.getResultList();
    }
}