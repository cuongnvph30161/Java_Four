package com.example.exam.controller;

import com.example.exam.service.CuaHangService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({
    "/cua-hang/hien-thi",
    "/cua-hang/add",
    "/cua-hang/update",
    "/cua-hang/detail",
    "/cua-hang/delete",
})
public class CuaHangServlet extends HttpServlet {
    CuaHangService service = new CuaHangService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/hien-thi")){
            hienThi(req, resp);
        }
    }

    void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", service.getAll());
        req.getRequestDispatcher("/cua-hang/hien-thi.jsp").forward(req, resp);
    }
}
