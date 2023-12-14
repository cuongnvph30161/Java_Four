package com.example.day7;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //TODO: Check database
        if("poly".equals(username) && password.equals("123")){
            req.getSession().setAttribute("username", username);
            String uri = (String) req.getSession().getAttribute("uri");
            if(uri == null) uri = "home";
            resp.sendRedirect(uri); // success
        }else{
            req.setAttribute("error", "Invalid username/password");
            req.getRequestDispatcher("login.jsp")
                    .forward(req, resp); // error
        }
    }
}
