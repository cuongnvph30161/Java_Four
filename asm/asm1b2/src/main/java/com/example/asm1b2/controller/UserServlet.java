package com.example.asm1b2.controller;

import com.example.asm1b2.entity.User;
import com.example.asm1b2.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/user",
        "/add",
        "/update", // dùng cho cả việc get và post
        "/delete",
})
public class UserServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("user")) {
            listUser(req, resp);
        } else if (uri.contains("update")) {
            viewUpdate(req, resp);
        } else if (uri.contains("delete")) {
            deleteUser(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            this.addUser(req, resp);

        } else if (uri.contains("update")) {
            this.updateUser(req, resp);
        }
    }

    protected void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listUser", service.getAll());
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }

    protected void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = service.getById(id);
        service.deleteUser(user);
        req.setAttribute("listUser", service.getAll());
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }

    protected void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if(service.checkTrungIdUser(id)){
            req.setAttribute("validateTrungIdUser","Id đã tồn tại");
            req.getRequestDispatcher("add.jsp").forward(req, resp);
        }else {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String fullname = req.getParameter("fullname");
            String country = req.getParameter("country");
            String gender = req.getParameter("gender");
            Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
            User user = new User(id, email, password, fullname, country, gender, admin);
            service.add(user);
            req.setAttribute("listUser", service.getAll());
            req.getRequestDispatcher("/user.jsp").forward(req, resp);
        }
    }

    protected void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("user", service.getById(id));
        req.getRequestDispatcher("update.jsp").forward(req, resp);

    }

    protected void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = service.getById(id);
        if (user != null) {
            user.setEmail(req.getParameter("email"));
            user.setFullname(req.getParameter("fullname"));
            user.setCountry(req.getParameter("country"));
            user.setGender(req.getParameter("gender"));
            user.setAdmin(req.getParameter("admin") != null);
            service.update(user);
            req.setAttribute("listUser", service.getAll());
            req.getRequestDispatcher("user.jsp").forward(req, resp);
        }

    }

}
