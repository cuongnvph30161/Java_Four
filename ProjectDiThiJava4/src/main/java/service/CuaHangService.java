package service;

import entity.CuaHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class CuaHangService {
    public List<CuaHang> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        String jqpl = "select ch from CuaHang ch";
        TypedQuery<CuaHang> query = em.createQuery(jqpl, CuaHang.class);
        List<CuaHang> list = query.getResultList();
        return list;
    }

    public void add(CuaHang cuaHang) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cuaHang);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public CuaHang getById(UUID id) {
        EntityManager em = HibernateUtil.createEntityManager();
        CuaHang cuaHang = em.find(CuaHang.class, id);
        return cuaHang;
    }
    public void delete(CuaHang cuaHang) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
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
