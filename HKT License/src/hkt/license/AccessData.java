/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hkt.license;

import hkt.license.entity.Key;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import org.eclipse.persistence.jpa.JpaEntityManager;

/**
 *
 * @author longnt
 */
public class AccessData {

    private static AccessData accessData;

    public static AccessData getInstance() {
        if (accessData == null) {
            accessData = new AccessData();
        }
        return accessData;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JDBCTestPU");
    private EntityManager em = emf.createEntityManager();
    private Class typeClass = Key.class;

    public boolean insert(Key obj) {

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            return true;
        } catch (RollbackException e) {
            JOptionPane.showMessageDialog(null, "Mã đã tồn tại!\n"
                    + "Hãy chọn mã khác!");
            return false;
        } catch (EntityExistsException entityExistsException) {
            JOptionPane.showMessageDialog(null, "Mã đã tồn tại!\n"
                    + "Hãy chọn mã khác!");
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public boolean update(Key obj) {

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.getEntityManagerFactory().getCache().evictAll();
            em.merge(obj);
            ((JpaEntityManager) em.getDelegate()).getServerSession().getIdentityMapAccessor().initializeAllIdentityMaps();
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public boolean delete(Key obj) {

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(em.find(typeClass, obj.getId()));
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public boolean deleteById(long id) {
        if (emf == null || typeClass == null) {
            return false;
        }
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(em.find(typeClass, id));
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public Key getById(long id) {
        return getByObjectId(id);
    }

    public Key getByObjectId(long id) {
        if (emf == null || typeClass == null) {
            return null;
        }
        try {
            em = emf.createEntityManager();
            Key obj = (Key) em.find(typeClass, id);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    
     public Key getByKeyMachine(String keyMachine) {
        if (emf == null || typeClass == null) {
            return null;
        }
        try {
            em = emf.createEntityManager();
            Key obj = (Key) em.find(typeClass, keyMachine);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
     
    public List<Key> select(String fieldName, String wordSearch) {
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl "
                + "where tbl." + fieldName + " = '" + wordSearch + "'";
        return (List<Key>) queryList(queryString);
    }

    public List<Key> selectAll() {
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl ";
        return (List<Key>) queryList(queryString);
    }

    public List<Key> queryList(String query) {
        try {
            em = emf.createEntityManager();
            em.getEntityManagerFactory().getCache().evictAll();
            List<Key> list = em.createQuery(query).getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return (List<Key>) new ArrayList<Key>();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
