package com.example.day2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signup.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        String status = req.getParameter("status");
        String country = req.getParameter("country");
        req.setAttribute("username", username);
        req.setAttribute("gender", gender);
        req.setAttribute("status", status);
        req.setAttribute("country", country);
        req.getRequestDispatcher("user_info.jsp")
                .forward(req, resp);
    }
}
