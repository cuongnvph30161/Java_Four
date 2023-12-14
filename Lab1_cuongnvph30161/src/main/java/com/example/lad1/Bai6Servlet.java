package com.example.lad1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bai6")
public class Bai6Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1");
        req.getRequestDispatcher("/bai6/form-chu-nhat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("2");
        double rong = Double.valueOf(req.getParameter("rong"));
        double dai = Double.valueOf(req.getParameter("dai"));
        double chuvi = 2 * (dai + rong);
        double dientich = dai * rong;
        req.setAttribute("chuvi", chuvi);
        req.setAttribute("dientich", dientich);
        req.getRequestDispatcher("/bai6/result.jsp").forward(req, resp);

    }
}
