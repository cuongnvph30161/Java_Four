package com.example.exam.service;

import com.example.exam.HibernateUtil;
import com.example.exam.entity.CuaHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CuaHangService {
    public List<CuaHang> getAll(){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            Query q = em.createQuery("SELECT c FROM CuaHang c");
            return q.getResultList();
        }finally {
            em.close();
        }
    }
}
