package service;

import entity.CuaHang;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.List;

public class CuaHangService {
    public List<CuaHang> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        TypedQuery<CuaHang> query = em.createQuery("select ch from CuaHang ch ", CuaHang.class);
        List<CuaHang> list = query.getResultList();
        em.close();
        return list;
    }

    public void create(CuaHang cuaHang) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cuaHang);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            CuaHang cuaHang = new CuaHang();
            cuaHang.setId(id);
            em.remove(cuaHang);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
