package com.example.day5;

import jakarta.persistence.EntityManager;

public class UserUpdateTest {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.createEntityManager();
        User u = em.find(User.class, "nva"); // get by id
        u.setFullname("Nguyễn Văn An");
        em.getTransaction().begin();
        try {
            em.merge(u);      // update
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        em.close();
    }
}
