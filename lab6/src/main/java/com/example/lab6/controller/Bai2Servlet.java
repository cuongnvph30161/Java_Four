package com.example.lab6.controller;

import com.example.lab6.HibernateUtil;
import com.example.lab6.entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/bai2")
public class Bai2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        if(keyword==null) keyword = "";

        String jpql = "SELECT DISTINCT o.video FROM Favorite o "
                + " WHERE o.video.title LIKE :keyword";

        EntityManager em = HibernateUtil.createEntityManager();
        TypedQuery<Video> query = em.createQuery(jpql,Video.class);
        query.setParameter("keyword", "%"+keyword+"%");
        List<Video> list = query.getResultList();

        req.setAttribute("list", list);
        req.getRequestDispatcher("bai2.jsp").forward(req, resp);
    }
}
