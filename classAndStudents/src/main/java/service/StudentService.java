package service;

import entity.Lop;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public List<Student> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        TypedQuery<Student> query = em.createQuery("select student from Student student join student.lop lop ", Student.class);
        List<Student> list = query.getResultList();
        em.close();
        return list;
    }

    public void create(Student student) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally { //  dù có hay không xảy ra ngoại lệ nó vẫn chạy
            em.close();
        }
    }

    public Student getStudentById(int id) { // lấy ra 1 Object Student
        EntityManager em = HibernateUtil.createEntityManager();// cho phép crud và truy vấn 1 thực thể
        Student student = em.find(Student.class, id);
        System.out.println("Log student" + " " + student);
        em.close();
        return student;
    }

    public int getLopIdByName(String tenLop) { // lấy ra id lớp
        EntityManager em = HibernateUtil.createEntityManager();

        try {
            TypedQuery<Integer> query = em.createQuery("SELECT l.id FROM Lop l WHERE l.tenLop = :tenLop", Integer.class);
            query.setParameter("tenLop", tenLop);
            int id = query.getSingleResult();
            return id;
        } catch (NoResultException e) {
            // Xử lý trường hợp không tìm thấy kết quả (tùy chọn)
            return -1; // hoặc một giá trị thích hợp để biểu thị không tìm thấy
        } finally {
            em.close();
        }
    }


    public void update(Student student) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleteById(int id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            Student student = getStudentById(id);
            em.remove(student);
            em.getTransaction().commit();
        } catch (Exception e) {

            e.printStackTrace();
            em.getTransaction().rollback();

            em.close();
        } finally {
            em.close();
        }
    }

}
