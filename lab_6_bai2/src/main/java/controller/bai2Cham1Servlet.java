package controller;

import entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bai2Cham1Service;
import utility.HibernateUtil;

import java.io.IOException;
import java.util.List;

@WebServlet("/bai2-1")
public class bai2Cham1Servlet extends HttpServlet {
    bai2Cham1Service service = new bai2Cham1Service();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        req.setAttribute("key",keyword);
        if(keyword== null){
            keyword="";
        }
        req.setAttribute("list",service.getVideoByTitle(keyword));
        req.getRequestDispatcher("bai2.2.jsp").forward(req,resp);
    }
}
