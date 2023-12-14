package service;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        TypedQuery<User> query = em.createQuery("select user from User user", User.class);
        List<User> list = query.getResultList();
        em.close();
        return list;
    }

    public void create(User user) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
          em.getTransaction().rollback();
          e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            User user = getUserById(id);
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public User getUserById(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

}
