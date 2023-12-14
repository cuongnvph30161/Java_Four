package com.example.assignment1.controller;

import com.example.assignment1.entity.User;
import com.example.assignment1.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/user", "/update-user"})
public class UserServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/update-user")) {
            viewUpdate(req, resp);
        } else {
            listUser(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/update-user")) {
            updateUser(req, resp);
        } else {
            addUser(req, resp);
        }
    }

    void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", service.getAll());
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }

    void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("user", service.getById(id));
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();
        user.setId(req.getParameter("id"));
        user.setPassword(req.getParameter("password"));
        user.setFullname(req.getParameter("fullname"));
        user.setAdmin(req.getParameter("admin") != null);
        service.add(user);
        resp.sendRedirect("user");
    }

    void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = service.getById(id);
        if (user != null) {
            user.setFullname(req.getParameter("fullname"));
            user.setAdmin(req.getParameter("admin") != null);
            service.update(user);
        }
        resp.sendRedirect("user");
    }


}
