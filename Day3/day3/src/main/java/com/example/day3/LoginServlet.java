package com.example.day3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("poly") && password.equals("123")) {
            Cookie c = new Cookie("un", username);
            c.setMaxAge(24 * 3600); // 1 day
            resp.addCookie(c);
            resp.sendRedirect("home");
        } else {
            req.setAttribute("err", "User/pass incorrect");
            req.getRequestDispatcher("login.jsp")
                    .forward(req, resp);
        }
    }
}
