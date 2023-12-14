package com.example.exam.controller;

import com.example.exam.service.KhachHangService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({
    "/khach-hang/hien-thi",
    "/khach-hang/add",
    "/khach-hang/update",
    "/khach-hang/detail",
    "/khach-hang/delete",
})
public class KhachHangServlet extends HttpServlet {
    KhachHangService service = new KhachHangService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/hien-thi")){
            hienThi(req, resp);
        }
    }

    void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", service.getAll());
        req.getRequestDispatcher("/khach-hang/hien-thi.jsp").forward(req,resp);
    }
}
