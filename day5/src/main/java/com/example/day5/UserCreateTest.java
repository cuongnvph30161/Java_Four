package com.example.day5;

import jakarta.persistence.EntityManager;

public class UserCreateTest {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.createEntityManager();
        User u = new User();
        u.setId("nvc");
        u.setPassword("789");
        u.setFullname("Nguyen Van C");
        u.setEmail("nvc@gmail.com");
        u.setAdmin(false);
        em.getTransaction().begin();
        try {
            em.persist(u);      // create
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        em.close();
    }
}
