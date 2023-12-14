package service;

import entity.Lop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.List;

public class LopService {
    public List<Lop> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        TypedQuery<Lop> query = em.createQuery("SELECT u FROM Lop u", Lop.class);
        List<Lop> list = query.getResultList();
        em.close();
        return list;
    }

    public void createLop(Lop lop) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(lop);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Lop getById(int id) {
        EntityManager em = HibernateUtil.createEntityManager();
        Lop lop = em.find(Lop.class, id);
        em.close();
        return lop;
    }

    public void updateLop(Lop lop) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(lop);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleteById(Lop lop) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(lop);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
