package com.example.exam.service;

import com.example.exam.HibernateUtil;
import com.example.exam.entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.UUID;

public class NhanVienService {
    public List<NhanVien> getAll(){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = "SELECT v FROM NhanVien v";
            Query q = em.createQuery(jpql);
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    public void add(NhanVien nv) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(nv); // persist/merge/remove
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public NhanVien getById(UUID id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(NhanVien.class, id);
        }finally {
            em.close();
        }
    }

    public void delete(NhanVien nv) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(nv); // persist/merge/remove
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public static void main(String[] args){
        NhanVienService service = new NhanVienService();
        for(NhanVien nv : service.getAll()){
            System.out.println(nv.getTen());
        }
    }
}
