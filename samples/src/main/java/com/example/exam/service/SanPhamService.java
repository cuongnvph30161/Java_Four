package com.example.exam.service;

import com.example.exam.HibernateUtil;
import com.example.exam.entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.UUID;

public class SanPhamService {

    public List<SanPham> getAll(){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            Query q = em.createQuery("SELECT sp FROM SanPham sp");
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    public SanPham findById(UUID id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(SanPham.class, id);
        }finally {
            em.close();
        }
    }

    public SanPham add(SanPham sp){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(sp);
            em.getTransaction().commit();
            return sp;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return null;
    }

    public SanPham update(SanPham sp){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(sp);
            em.getTransaction().commit();
            return sp;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return null;
    }

    public boolean deleteById(UUID id){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            SanPham sp = em.find(SanPham.class, id);
            em.remove(sp);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return false;
    }

    public static void main(String[] args) {
        SanPhamService service = new SanPhamService();
        List<SanPham> list = service.getAll();
        for(SanPham sp : list) {
            System.out.println(sp.getMota());
        }
    }
}
