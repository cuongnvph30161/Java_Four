package service;

import entity.Favorite;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.List;


public class UserService {

    public List<User> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        String jqpl = "select u from User u ";
        TypedQuery<User> query = em.createQuery(jqpl, User.class);
        List<User> list = query.getResultList();
        return list;
    }

    public void create(User user) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    public boolean checkUser(String username, String password) {
        EntityManager em = HibernateUtil.createEntityManager();
        String jqpl = "select u from User u where u.id=:username and u.password=:password";
        TypedQuery<User> query = em.createQuery(jqpl, User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = query.getSingleResult();
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    public User getById(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public void deleteUser(User user) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public String checkTrungIdUser(String id) {
        try {
            EntityManager em = HibernateUtil.createEntityManager();
            String jqpl = "SELECT u.id FROM User u WHERE u.id=:id";
            TypedQuery<String> query = em.createQuery(jqpl, String.class);
            query.setParameter("id", id);
            String result = query.getSingleResult();
            em.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User user) {
        EntityManager em = HibernateUtil.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }


}
