package com.example.exam.service;

import com.example.exam.JPAUtil;
import com.example.exam.entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class KhachHangService {

    public List<KhachHang> getAll(){
        EntityManager em = JPAUtil.createEntityManager();
        try{
            Query q = em.createQuery("SELECT kh FROM KhachHang kh");
            return q.getResultList();
        }finally {
            em.close();
        }
    }
}
