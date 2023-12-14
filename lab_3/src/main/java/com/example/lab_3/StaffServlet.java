package com.example.lab_3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;


import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/staff/form.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
// Định dạng thời gian nhập vào
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("MM/dd/yyyy");
            ConvertUtils.register(dtc, Date.class);

            Staff staff = new Staff();
// Đọc tham số vào các thuộc tính của bean staff
            BeanUtils.populate(staff, req.getParameterMap());
// Chia sẻ với result.jsp
            req.setAttribute("bean", staff);

        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/staff/result.jsp").forward(req, resp);
    }
}
