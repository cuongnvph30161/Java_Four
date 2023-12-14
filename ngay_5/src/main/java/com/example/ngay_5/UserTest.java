package com.example.ngay_5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserTest {
    public static void main(String[] args) {
        try {
            EntityManager em = HibernateUtil.createEntityManager();
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            List<User> list = query.getResultList();
            for (User u : list) {
                System.out.println(u.getFullname());
            }
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
