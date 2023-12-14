package com.example.day5;

import jakarta.persistence.EntityManager;

public class UserDeleteTest {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.createEntityManager();
        User u = em.find(User.class, "nvc"); // get by id
        em.getTransaction().begin();
        try {
            em.remove(u);      // delete
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        em.close();
    }
}
