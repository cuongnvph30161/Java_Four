package com.example.ngay_5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
        }
    }
}
