package com.example.lab6.test;

import com.example.lab6.HibernateUtil;
import com.example.lab6.entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Test2 {
    public static void main(String [] args) {
        String keyword = "Video";
        String jpql = "SELECT DISTINCT o.video FROM Favorite o "
                + " WHERE o.video.title LIKE :keyword";
        EntityManager em = HibernateUtil.createEntityManager();
        TypedQuery<Video> query = em.createQuery(jpql,Video.class);
        query.setParameter("keyword", "%"+keyword+"%");
        List<Video> list = query.getResultList();
        for(Video v : list) {
            System.out.println(v.getId() + "," + v.getTitle());
        }
    }
}
