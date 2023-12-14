package service;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.List;

public class bai2Cham3Service {
    public List<User> getUserByVideoId(String videoId){
        EntityManager em = HibernateUtil.createEntityManager();
        String jpql = "select favorite.user from Favorite favorite where favorite.video.id = :videoId ";
        TypedQuery<User> query  = em.createQuery(jpql,User.class);
        query.setParameter("videoId",videoId);
        List<User> list = query.getResultList();
        return list;
    }

}
