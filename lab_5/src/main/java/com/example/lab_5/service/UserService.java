package com.example.lab_5.service;

import com.example.lab_5.HibernateUtil;
import com.example.lab_5.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserService {
    public List<User> getALl(){
        EntityManager em = HibernateUtil.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        List<User> list = query.getResultList();
        em.close();
        return list;
    }

    public void create(User u){
        EntityManager em = HibernateUtil.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public User getById(int id) {
        EntityManager em = HibernateUtil.createEntityManager();
        User u = em.find(User.class, id);
        em.close();
        return u;
    }

    public void deleteById(int id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            User user = new User();
            user.setId(id);
            em.remove(user);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public void update(User u) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
