package com.example.luyentap_jpa_2.service;

import com.example.luyentap_jpa_2.HibernateUtil;
import com.example.luyentap_jpa_2.entity.CuaHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CuaHangService {
    public List<CuaHang> getAll(){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = "SELECT ch FROM CuaHang ch";
            TypedQuery<CuaHang> query = em.createQuery(jpql, CuaHang.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }
    public static void main(String[] args){
        CuaHangService service = new CuaHangService();
        for(CuaHang ch : service.getAll())
        {
            System.out.println(ch.getTen());
        }
    }
}
