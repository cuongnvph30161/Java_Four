package com.example.luyentap_jpa_2.service;

import com.example.luyentap_jpa_2.HibernateUtil;
import com.example.luyentap_jpa_2.entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import java.util.UUID;

public class SanPhamService {
    public List<SanPham> getAll(){
        EntityManager em = HibernateUtil.createEntityManager();
        try{
            String jpql = "SELECT sp FROM SanPham sp";
            Query query = em.createQuery(jpql);
            return query.getResultList();
        }finally {
            em.close();
        }
    }

    public SanPham findById(UUID id) {
        EntityManager em = HibernateUtil.createEntityManager();
        SanPham sp = em.find(SanPham.class, id);
        em.close();
        return sp;
    }
    public static void main(String[] args) {
        SanPhamService service = new SanPhamService();
        for(SanPham sp: service.getAll()){
            System.out.println(sp.getId());
        }
    }
}