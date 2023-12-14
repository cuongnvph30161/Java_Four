package controller;

import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NhanVienService;

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
        "/nhan-vien/view-update",
        "/nhan-vien/update",
        "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienService service = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("nhan-vien/hien-thi")) {
            hienthi(req, resp);
        } else if (uri.contains("delete")) {
            delete(req, resp);
        } else if (uri.contains("detail")) {
            detail(req, resp);
        } else if (uri.contains("view-update")) {
            viewUpdate(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            add(req, resp);
        } else if (uri.contains("update")) {
            update(req, resp);
        }
    }

    protected void hienthi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhanVien> list = service.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("nhanvien.jsp").forward(req, resp);
    }

    protected void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        NhanVien nhanVien = service.getById(id);
        req.setAttribute("nv", nhanVien);
        hienthi(req, resp);
    }

    protected void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        NhanVien nhanVien = service.getById(id);
        req.setAttribute("nv", nhanVien);
        req.getRequestDispatcher("view-update.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        NhanVien nhanVien = service.getById(id);
        service.delete(nhanVien);
        req.setAttribute("message", "xoa thanh cong");
        hienthi(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UUID id = UUID.fromString(req.getParameter("id"));
        NhanVien nhanVien = service.getById(id);
        String ten = req.getParameter("ten");
        String ngaysinhStr = req.getParameter("ngaysinh");
        String ma = req.getParameter("ma");
        String diachi = req.getParameter("diachi");
        Boolean gioitinh = Boolean.parseBoolean(req.getParameter("gioitinh"));
        boolean flag = false;

        if (ten.isEmpty()) {
            req.setAttribute("errorTen", "Ten khong duoc rong");
            flag = true;
        }

        if (ngaysinhStr.isEmpty()) {
            req.setAttribute("errorNgaySinh", "Ngay sinh khong duoc rong");
            flag = true;
        }

        if (ma.isEmpty()) {
            req.setAttribute("errorMa", "Ma khong duoc rong");
            flag = true;
        }


        if(flag){
            hienthi(req,resp);
            return;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date ngaysinhDate = simpleDateFormat.parse(ngaysinhStr);
            nhanVien.setNgaysinh(ngaysinhDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nhanVien.setDiachi(diachi);
        nhanVien.setGioitinh(gioitinh);
        nhanVien.setMa(ma);
        nhanVien.setTen(ten);
        service.update(nhanVien);
        hienthi(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NhanVien nhanVien = new NhanVien();
        String ten = req.getParameter("ten");
        String ngaysinhStr = req.getParameter("ngaysinh");
        String ma = req.getParameter("ma");
        String diachi = req.getParameter("diachi");
        Boolean gioitinh = Boolean.parseBoolean(req.getParameter("gioitinh"));

        boolean flag = false;

        if (ten.isEmpty()) {
            req.setAttribute("errorTen", "Ten khong duoc rong");
            flag = true;
        }

        if (ngaysinhStr.isEmpty()) {
            req.setAttribute("errorNgaySinh", "Ngay sinh khong duoc rong");
            flag = true;
        }

        if (ma.isEmpty()) {
            req.setAttribute("errorMa", "Ma khong duoc rong");
            flag = true;
        }


        if(flag){
            hienthi(req,resp);
            return;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date ngaysinhDate = simpleDateFormat.parse(ngaysinhStr);
            nhanVien.setNgaysinh(ngaysinhDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nhanVien.setDiachi(diachi);
        nhanVien.setGioitinh(gioitinh);
        nhanVien.setMa(ma);
        nhanVien.setTen(ten);
        System.out.println("=================" + " " + nhanVien);
        service.add(nhanVien);
        req.setAttribute("message", "them thanh cong");
        hienthi(req, resp);
    }
}
