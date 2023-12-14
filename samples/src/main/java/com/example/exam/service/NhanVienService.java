package com.example.exam.service;

import com.example.exam.HibernateUtil;
import com.example.exam.entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class NhanVienService {
    public List<NhanVien> getAll(){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            Query q = em.createQuery("SELECT nv FROM NhanVien  nv");
            return q.getResultList();
        }finally {
            em.close();
        }
    }
}
