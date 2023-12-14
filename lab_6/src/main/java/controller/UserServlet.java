package controller;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;

@WebServlet({"/hien-thi-user",
        "/view-add-user",
        "/add-user",
        "/view-update-user",
        "/update-user",
        "/delete-user"
})
public class UserServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi-user")) {
            req.setAttribute("list", service.getAll());
            req.getRequestDispatcher("user/hienthi.jsp").forward(req, resp);
        } else if (uri.contains("delete")) {
            delete(req, resp);
        } else if (uri.contains("view-add-user")) {
            viewCreate(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add-user")) {
            create(req, resp);
        }
    }


    protected void viewCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user/create.jsp").forward(req, resp);
    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String photo = req.getParameter("photo");
        byte actived = Byte.parseByte(req.getParameter("actived"));
        byte admin = Byte.parseByte(req.getParameter("admin"));

        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setActivated(actived);
        user.setAdmin(admin);
        user.setEmail(email);
        user.setFullname(fullname);
        user.setPhoto(photo);
        System.out.println("log"+" "+user.getId());
        service.create(user);
        resp.sendRedirect("hien-thi-user");

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        service.delete(id);
        resp.sendRedirect("hien-thi-user");
    }
}
