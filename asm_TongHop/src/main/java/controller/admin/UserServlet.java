package controller.admin;

import entity.Favorite;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;

@WebServlet({"/user",
        "/viewadd",
        "/add",
        "/viewUpdate",
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
        } else if (uri.contains("viewadd")) {
            viewadd(req, resp);
        } else if (uri.contains("delete")) {
            deleteUser(req, resp);
        } else if (uri.contains("viewUpdate")) {
            viewUpdate(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            this.addUser(req, resp);
        } else if (uri.contains("add")) {
            addUser(req, resp);
        } else if (uri.contains("update")) {
            updateUser(req, resp);
        }
    }

    protected void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listUser", service.getAll());
        req.getRequestDispatcher("user/user.jsp").forward(req, resp);
    }

    protected void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = service.getById(id);
        service.deleteUser(user);
        resp.sendRedirect("user");
    }

    protected void viewadd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user/add.jsp").forward(req, resp);

    }


    protected void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (service.checkTrungIdUser(id) == null) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String fullname = req.getParameter("fullname");
            Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));

            User user = new User();
            user.setId(id);
            user.setAdmin(admin);
            user.setFullname(fullname);
            user.setEmail(email);
            user.setPassword(password);

            service.create(user);
            resp.sendRedirect("user");
        } else {
            req.setAttribute("validateTrungIdUser", "Id đã tồn tại");
            req.getRequestDispatcher("user/add.jsp").forward(req, resp);
        }

    }

    protected void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("user", service.getById(id));
        req.getRequestDispatcher("user/update.jsp").forward(req, resp);
    }

    protected void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = service.getById(id);
        if (user != null) {
            user.setEmail(req.getParameter("email"));
            user.setFullname(req.getParameter("fullname"));
            user.setAdmin(req.getParameter("admin") != null);
            service.update(user);
            resp.sendRedirect("user");
        }
    }
}



