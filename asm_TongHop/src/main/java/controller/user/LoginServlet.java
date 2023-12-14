package controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
 private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/account/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        /// kiểm tra xem tài khoản hoặc mật khẩu tồn tại không
        if(service.checkUser(username, password)){
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("home");
            return;
        }
        req.setAttribute("message", "Incorrect username/password");
        req.getRequestDispatcher("/account/login.jsp").forward(req, resp);
    }
}
