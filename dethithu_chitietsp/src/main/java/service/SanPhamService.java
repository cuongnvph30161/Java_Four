package service;

import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class SanPhamService {
    public List<SanPham> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        String jqpl = "select sp from SanPham sp";
        TypedQuery<SanPham> query = em.createQuery(jqpl, SanPham.class);
        List<SanPham> list = query.getResultList();
        return list;
    }

    public SanPham getById(UUID id) {
        EntityManager em = HibernateUtil.createEntityManager();
        SanPham sanPham = em.find(SanPham.class, id);
        return sanPham;
    }

    public void add(SanPham sanPham) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(sanPham);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    public void delete(SanPham sanPham) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(sanPham);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    public void update(SanPham sanPham) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(sanPham);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }
}
