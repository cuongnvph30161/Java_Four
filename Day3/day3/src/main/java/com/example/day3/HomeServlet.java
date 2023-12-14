package com.example.day3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("username");
        String username = "";
        for (Cookie c : req.getCookies()) {
            if (c.getName().equals("un")) {
                username = c.getValue();
            }
        }
        resp.getWriter().println("<b>Hello " + username + "</b>");
    }
}
