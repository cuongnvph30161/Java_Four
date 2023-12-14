package service;

import entity.User;
import entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class VideoService {
    public List<Video> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        String jqpl = "select v from Video v";
        TypedQuery<Video> query = em.createQuery(jqpl, Video.class);
        List<Video> list = query.getResultList();
        return list;
    }

    public void createVideo(Video video) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            System.out.println("Video Service"+" "+video);
            em.persist(video);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }


    public Video getById(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        Video video = em.find(Video.class, id);
        em.close();
        return video;
    }

    public void deleteVideo(Video video) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(video);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Video> search(String keyword) {
        EntityManager em =  HibernateUtil.createEntityManager();
        String jqpl = "select u from Video u where u.title like :keyword";
        TypedQuery<Video> query = em.createQuery(jqpl,Video.class);
        query.setParameter("keyword",'%'+keyword+'%');
        List<Video> list = query.getResultList();
        return list;
    }

    public List<Video> searchFavorite(String userId, String keyword) {
        EntityManager em = HibernateUtil.createEntityManager();
        String jpql = "SELECT f.video FROM Favorite f JOIN f.video v JOIN f.user u WHERE u.id = :userId AND v.title LIKE :keyword";
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        query.setParameter("userId", userId);
        query.setParameter("keyword", "%" + keyword + "%");
        List<Video> favoriteVideos = query.getResultList();
        em.close();
        return favoriteVideos;
    }

    public String checkTrungIdVideo(String id) {
        try {
            EntityManager em = HibernateUtil.createEntityManager();
            String jqpl = "SELECT v.id FROM Video v WHERE v.id=:id";
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

    public void update(Video video) {
        EntityManager em = HibernateUtil.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(video);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
