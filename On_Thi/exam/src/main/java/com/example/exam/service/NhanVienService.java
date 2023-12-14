package com.example.exam.service;

import com.example.exam.HibernateUtil;
import com.example.exam.entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class NhanVienService {
    public List<NhanVien> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        String jqpl = "select nv from NhanVien nv ";
        TypedQuery<NhanVien> query = em.createQuery(jqpl, NhanVien.class);
        List<NhanVien> list = query.getResultList();
        return list;
    }

    public NhanVien getById(UUID id) {
        EntityManager em = HibernateUtil.createEntityManager();
        NhanVien nhanVien = em.find(NhanVien.class, id);
        return nhanVien;
    }

    public void delete(NhanVien nhanVien) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(nhanVien);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addNhanVien(NhanVien nhanVien) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(nhanVien);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        NhanVienService nhanVienService = new NhanVienService();
        List<NhanVien> nhanViens = nhanVienService.getAll();
        nhanViens.forEach(nhanVien -> System.out.println("log"+" "+nhanVien));
    }
}
