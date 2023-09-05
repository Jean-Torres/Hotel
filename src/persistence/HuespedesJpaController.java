/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Huespedes;
import persistence.exceptions.NonexistentEntityException;

/**
 *
 * @author jean torres
 */
public class HuespedesJpaController implements Serializable {

    public HuespedesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public HuespedesJpaController() {
        emf = Persistence.createEntityManagerFactory("Hotel_Alura");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Huespedes huespedes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(huespedes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Huespedes huespedes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            huespedes = em.merge(huespedes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = huespedes.getId();
                if (findHuespedes(id) == null) {
                    throw new NonexistentEntityException("The huespedes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Huespedes huespedes;
            try {
                huespedes = em.getReference(Huespedes.class, id);
                huespedes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The huespedes with id " + id + " no longer exists.", enfe);
            }
            em.remove(huespedes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Huespedes> findHuespedesEntities() {
        return findHuespedesEntities(true, -1, -1);
    }

    public List<Huespedes> findHuespedesEntities(int maxResults, int firstResult) {
        return findHuespedesEntities(false, maxResults, firstResult);
    }

    private List<Huespedes> findHuespedesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Huespedes.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Huespedes findHuespedes(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Huespedes.class, id);
        } finally {
            em.close();
        }
    }

    public int getHuespedesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Huespedes> rt = cq.from(Huespedes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
