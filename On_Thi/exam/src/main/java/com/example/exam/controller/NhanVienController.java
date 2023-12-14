package com.example.exam.controller;

import com.example.exam.entity.NhanVien;
import com.example.exam.service.NhanVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/detail",
        "/nhan-vien/delete",
})
public class NhanVienController extends HttpServlet {
    private NhanVienService service = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("nhan-vien/hien-thi")) {
            hienthi(req, resp);
        } else if (uri.contains("detail")) {
            detail(req, resp);
        } else if (uri.contains("delete")) {
            delete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            add(req, resp);
        }
    }

    protected void hienthi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhanVien> list = service.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/nhan-vien/nhanvien.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        NhanVien nhanVien = service.getById(id);
        service.delete(nhanVien);
        req.setAttribute("message", "da xoa thanh cong");
        hienthi(req,resp);

    }

    protected void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        NhanVien nhanVien = service.getById(id);
        req.setAttribute("nv", nhanVien);
        req.setAttribute("list", service.getAll());
        req.getRequestDispatcher("/nhan-vien/nhanvien.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NhanVien nhanVien = new NhanVien();
        Boolean flag = false;
        String ma = req.getParameter("ma");
        if (ma.isEmpty()) {
            req.setAttribute("errorMa", "Không được rỗng Mã");
            flag = true;
        }

        String diachi = req.getParameter("diachi");

        String ten = req.getParameter("ten");
        if (ten.isEmpty()) {
            req.setAttribute("errorTen", "Không được rỗng Tên");
            flag = true;
        }
        String ngaysinh = req.getParameter("ngaysinh");
        if (ngaysinh.isEmpty()) {
            req.setAttribute("errorNgaySinh", "Không được rỗng Ngày sinh");
            flag = true;
        }

        Boolean gioitinh = Boolean.parseBoolean(req.getParameter("gioitinh"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            nhanVien.setNgaysinh(simpleDateFormat.parse(ngaysinh));
        } catch (ParseException e) {
            e.printStackTrace();
        }



        if (flag) {
            hienthi(req, resp);
            return;
        }
        nhanVien.setDiachi(diachi);
        nhanVien.setMa(ma);
        nhanVien.setTen(ten);
        nhanVien.setGioitinh(gioitinh);
        service.addNhanVien(nhanVien);
        req.setAttribute("message", "da them thanh cong");
        hienthi(req,resp);
    }

}
