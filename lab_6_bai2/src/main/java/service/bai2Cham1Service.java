package service;

import entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.List;

public class bai2Cham1Service {

    public List<Video> getVideoByTitle(String keyword) {
        EntityManager em = HibernateUtil.createEntityManager();
        String jpql = "SELECT DISTINCT o.video FROM Favorite o "
                + " WHERE o.video.title LIKE :keyword";

        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        query.setParameter("keyword", "%" + keyword + "%");
        List<Video> list = query.getResultList();
        return list;
    }
}
