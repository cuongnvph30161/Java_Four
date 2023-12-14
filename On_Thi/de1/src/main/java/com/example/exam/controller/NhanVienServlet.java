package com.example.exam.controller;

import com.example.exam.entity.NhanVien;
import com.example.exam.service.NhanVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@WebServlet({
    "/nhan-vien/hien-thi",
    "/nhan-vien/add",
    "/nhan-vien/detail",
    "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    NhanVienService service = new NhanVienService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }else if(uri.contains("detail")) {
            detail(req, resp);
        }else if(uri.contains("delete")){
            delete(req, resp);
        }
    }

    void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhanVien> list = service.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/nhan-vien/index.jsp")
                .forward(req, resp);
    }

    void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        NhanVien nv = service.getById(id);
        req.setAttribute("nv", nv);
        List<NhanVien> list = service.getAll();
        req.setAttribute("list", list);
        System.out.println("======");
        req.getRequestDispatcher("/nhan-vien/index.jsp")
                .forward(req, resp);
    }

    void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        NhanVien nv = service.getById(id);
        service.delete(nv);
        resp.sendRedirect("hien-thi");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NhanVien nv = new NhanVien();
        nv.setMa(req.getParameter("ma"));
        nv.setTen(req.getParameter("ten"));
        nv.setDiachi(req.getParameter("diachi"));
        nv.setGioitinh(Boolean.valueOf(req.getParameter("gioitinh")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            nv.setNgaysinh(sdf.parse(req.getParameter("ngaysinh")));
        }catch(Exception e){
            e.printStackTrace();
        }
        service.add(nv);
        resp.sendRedirect("hien-thi");
    }
}
