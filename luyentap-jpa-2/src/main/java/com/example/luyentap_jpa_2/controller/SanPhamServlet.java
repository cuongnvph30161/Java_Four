package com.example.luyentap_jpa_2.controller;

import com.example.luyentap_jpa_2.entity.SanPham;
import com.example.luyentap_jpa_2.service.SanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet({
    "/san-pham/hien-thi",
    "/san-pham/delete",
    "/san-pham/detail",
    "/san-pham/add",
})
public class SanPhamServlet extends HttpServlet {
    SanPhamService service = new SanPhamService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id != null){
            SanPham sp = service.findById(UUID.fromString(id));
            req.setAttribute("sp", sp);
        }
        List<SanPham> list = service.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/san-pham/index.jsp")
                .forward(req, resp);
    }
}
