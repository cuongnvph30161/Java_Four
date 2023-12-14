package service;

import entity.Favorite;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;
import entity.Favorite;

import java.lang.reflect.Type;

public class FavoriteService {

    public void insert(Favorite favorite) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(favorite);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    public void delete(String username, String VideoId) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            Favorite favorite = getFavoriteByUserNameAndIdVideo(username, VideoId);
            em.remove(favorite);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    public Favorite getFavoriteByUserNameAndIdVideo(String username, String VideoId) {
        EntityManager em = HibernateUtil.createEntityManager();
        String jqpl = "select f from Favorite f where f.user.id=:username and f.video.id=:VideoId";
        TypedQuery<Favorite> query = em.createQuery(jqpl, Favorite.class);
        query.setParameter("username", username);
        query.setParameter("VideoId", VideoId);
        Favorite favorite = query.getSingleResult();
        return favorite;
    }

}
