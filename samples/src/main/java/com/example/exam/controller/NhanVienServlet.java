package com.example.exam.controller;

import com.example.exam.service.NhanVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({
    "/nhan-vien/hien-thi",
    "/nhan-vien/add",
    "/nhan-vien/update",
    "/nhan-vien/detail",
    "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    NhanVienService service = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/hien-thi")){
            hienThi(req, resp);
        }
    }

    void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", service.getAll());
        req.getRequestDispatcher("/nhan-vien/hien-thi.jsp").forward(req,resp);
    }
}
