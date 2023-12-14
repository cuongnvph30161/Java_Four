package service;

import entity.Favorite;
import entity.User;
import jakarta.persistence.EntityManager;
import utility.HibernateUtil;

import java.util.List;

public class bai2Cham2Service {
    User user = new User();

    public User finById(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }



}
