package com.example.lab5.controller;

import com.example.lab5.entity.User;
import com.example.lab5.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/user", "/create", "/update", "/delete", "/edit"})
public class UserServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", service.getAll());
        String id = req.getParameter("id");
        if(id != null){
            req.setAttribute("user", service.getById(id));
        }
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("create")){
            create(req, resp);
        }else if(uri.contains("update")){
            update(req, resp);
        }else if(uri.contains("delete")){
            delete(req, resp);
        }
    }

    void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u = new User();
        u.setId(req.getParameter("id"));
        u.setPassword(req.getParameter("password"));
        u.setFullname(req.getParameter("fullname"));
        u.setEmail(req.getParameter("email"));
        u.setAdmin(req.getParameter("admin") != null);
        service.create(u);
        resp.sendRedirect("user");
    }
    void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u = service.getById(req.getParameter("id"));
        u.setPassword(req.getParameter("password"));
        u.setFullname(req.getParameter("fullname"));
        u.setEmail(req.getParameter("email"));
        u.setAdmin(req.getParameter("admin") != null);
        service.update(u);
        resp.sendRedirect("user");
    }
    void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        service.deleteById(id);
        resp.sendRedirect("user");
    }
}
