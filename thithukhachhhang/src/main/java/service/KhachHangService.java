package service;

import entity.KhachHang;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class KhachHangService {

    public List<KhachHang> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        String jqpl = "select kh from KhachHang kh";
        TypedQuery<KhachHang> query = em.createQuery(jqpl, KhachHang.class);
        List<KhachHang> list = query.getResultList();
        return list;
    }

    public String validateCheckTrungMa(String ma) {
        EntityManager em = HibernateUtil.createEntityManager();
        String jqpl = "select kh.ma from KhachHang kh where kh.ma=:ma";
        TypedQuery<String> query = em.createQuery(jqpl, String.class);
        query.setParameter("ma", ma);
        String maTrung = query.getSingleResult();
        return maTrung;
    }

    public void add(KhachHang khachHang) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();

            em.persist(khachHang);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void delete(KhachHang khachHang) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(khachHang);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(KhachHang khachHang) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(khachHang);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public KhachHang getById(UUID id) {
        EntityManager em = HibernateUtil.createEntityManager();
        KhachHang khachHang = em.find(KhachHang.class, id);
        em.close();
        return khachHang;

    }
}
