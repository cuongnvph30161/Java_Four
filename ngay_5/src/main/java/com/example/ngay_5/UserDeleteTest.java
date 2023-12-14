package com.example.ngay_5;

import jakarta.persistence.EntityManager;

public class UserDeleteTest {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.createEntityManager();
        User u = em.find(User.class, "1");
        em.getTransaction().begin();
        try {
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
        }
    }
}
