package com.example.day3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("staff/form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String name = req.getParameter("name");
        //Boolean gender = Boolean.valueOf(req.getParameter("gender"));
        Employee empl = new Employee();
        try {
            BeanUtils.populate(empl, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("empl", empl);
        req.getRequestDispatcher("staff/result.jsp")
                .forward(req, resp);
    }
}
