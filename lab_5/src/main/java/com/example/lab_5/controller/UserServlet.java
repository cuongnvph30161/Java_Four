package com.example.lab_5.controller;

import com.example.lab_5.entity.User;
import com.example.lab_5.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/user",
        "/view-create",
        "/create",
        "/view-update",
        "/update",
        "/delete",
})

public class UserServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        req.setAttribute("list", service.getALl());
        if (uri.contains("view-create")) {
            viewCreate(req, resp);
        } else if (uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if (uri.contains("delete")) {
            delete(req, resp);
        } else if (uri.contains("user")) {
            req.getRequestDispatcher("user.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("create")) {
            createUser(req, resp);
        } else if (uri.contains("update")) {
            update(req, resp);
        }
    }

    protected void viewCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("form.jsp").forward(req, resp);
    }

    protected void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("user", service.getById(id));
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    protected void createUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u = new User();
//        u.setId(Integer.parseInt(req.getParameter("id")));
        u.setPassword(req.getParameter("password"));
        u.setFullname(req.getParameter("fullname"));
        u.setEmail(req.getParameter("email"));
        u.setAdmin(req.getParameter("admin") != null);
        System.out.println("Log id"+" "+u.getId());
        service.create(u);
        resp.sendRedirect("user");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User u = service.getById(Integer.parseInt(req.getParameter("id")));
        u.setPassword(req.getParameter("password"));
        u.setFullname(req.getParameter("fullname"));
        u.setEmail(req.getParameter("email"));
        u.setAdmin(req.getParameter("admin") != null);
        service.update(u);
        resp.sendRedirect("user");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteById(id);
        resp.sendRedirect("user");

    }

}
