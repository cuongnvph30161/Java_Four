package com.example.lab_lab4;

import entity.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DanhSachService;

import java.io.IOException;

@WebServlet({"/danhsach",
        "/add",})
public class DanhSachServlet extends HttpServlet {
    private DanhSachService ds = new DanhSachService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("danhsach")) {
            listSp(req, resp);
        } else {
            req.getRequestDispatcher("them.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            this.add(req, resp);
        }
    }

    protected void listSp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSanPham", ds.getAll());
        req.getRequestDispatcher("DanhSach.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten = req.getParameter("ten");
        String loai = req.getParameter("loai");
        double dongia = Double.parseDouble(req.getParameter("gia"));
        Boolean conhang = Boolean.parseBoolean(req.getParameter("conhang"));
        SanPham sanPham = new SanPham(ten, loai, dongia, conhang);
        ds.add(sanPham);
        req.setAttribute("listSanPham", ds.getAll());
        req.getRequestDispatcher("DanhSach.jsp").forward(req, resp);
    }
}
