package service;

import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.List;

public class NhanVienService {
    public List<NhanVien> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = "select nv from NhanVien nv";
            TypedQuery<NhanVien> query = em.createQuery(jpql, NhanVien.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
