package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bai2Cham3Service;

import java.io.IOException;

@WebServlet("/bai2-3")
public class bai2Cham3Servlet extends HttpServlet {
    bai2Cham3Service service = new bai2Cham3Service();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("bai2.3.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String videoId = req.getParameter("videoId");
        req.setAttribute("list", service.getUserByVideoId(videoId));
        System.out.println("LOG" + " " + service.getUserByVideoId(videoId));
        req.getRequestDispatcher("bai2.3.jsp").forward(req, resp);
    }

}
