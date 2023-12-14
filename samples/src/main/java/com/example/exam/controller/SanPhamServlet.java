package com.example.exam.controller;

import com.example.exam.entity.SanPham;
import com.example.exam.service.SanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet({
    "/san-pham/hien-thi",
    "/san-pham/detail",
    "/san-pham/delete",
    "/san-pham/view-update",
    "/san-pham/add",
    "/san-pham/update"
})
public class SanPhamServlet extends HttpServlet {
    SanPhamService service = new SanPhamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/hien-thi")){
            hienThi(req, resp);
        }
        if(uri.contains("/detail")){
            detail(req, resp);
        }
        if(uri.contains("/view-update")){
            viewUpdate(req, resp);
        }
        if(uri.contains("/delete")){
            delete(req, resp);
        }
    }

    void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", service.getAll());
        req.getRequestDispatcher("/san-pham/hien-thi.jsp").forward(req,resp);
    }

    void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        req.setAttribute("sanpham", service.findById(id));
        req.setAttribute("items", service.getAll());
        req.getRequestDispatcher("/san-pham/hien-thi.jsp").forward(req,resp);
    }

    void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        req.setAttribute("sanpham", service.findById(id));
        req.getRequestDispatcher("/san-pham/view-update.jsp").forward(req,resp);
    }

    void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        service.deleteById(id);
        resp.sendRedirect("hien-thi?message=Da+xoa+thanh+cong");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/add")) {
            add(req, resp);
        }
        if(uri.contains("/update")) {
            update(req, resp);
        }
    }

    void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SanPham sp = new SanPham();
        sp.setNambh(Integer.valueOf(req.getParameter("nambh")));
        sp.setSoluongton(Integer.valueOf(req.getParameter("soluongton")));
        sp.setGianhap(Double.valueOf(req.getParameter("gianhap")));
        sp.setMota(req.getParameter("mota"));
        service.add(sp);
        resp.sendRedirect("hien-thi");
    }

    void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        SanPham sp = service.findById(id);
        sp.setNambh(Integer.valueOf(req.getParameter("nambh")));
        sp.setSoluongton(Integer.valueOf(req.getParameter("soluongton")));
        sp.setGianhap(Double.valueOf(req.getParameter("gianhap")));
        sp.setMota(req.getParameter("mota"));
        service.update(sp);
        resp.sendRedirect("hien-thi");
    }
}
