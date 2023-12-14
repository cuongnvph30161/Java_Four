package com.example.UDM_Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//đăng xuất người dùng bằng cookie

@WebServlet("/member")
public class MemberAreaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "destroy":
                req.getSession().invalidate();
                resp.sendRedirect(req.getContextPath() + "/SiteController?action=login");

                break;
            case "memberArea":
                req.getRequestDispatcher("memberArea.jsp").forward(req, resp);
            default:
                break;
        }
    }
}
