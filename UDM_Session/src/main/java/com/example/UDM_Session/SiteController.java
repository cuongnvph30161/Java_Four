package com.example.UDM_Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        // lấy ra tên action
        String action = req.getParameter("action");
        switch (action) {
            case "login":
                req.getRequestDispatcher("login.jsp").forward(req, rsp);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "loginSubmit":
                authenticate(req, resp);
                break;
            default:
                break;
        }
    }

    protected void authenticate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("studyeasy") && password.equals("Love")) {
            // vô hiệu hoá session nếu có
            req.getSession().invalidate();
            // Tạo 1 Session mới
            HttpSession newSession = req.getSession(true);
            // sau 500s không sử dụng thì session sẽ hết hiệu lực
            newSession.setMaxInactiveInterval(500);
            newSession.setAttribute("username", username);
//             Cookie  cUsername = new Cookie("username",username);
//             resp.addCookie(cUsername);
            resp.sendRedirect(req.getContextPath() + "/member?action=memberArea");
        } else {
            resp.sendRedirect(req.getContextPath() + "/SiteController?action=login");
        }
    }
}
