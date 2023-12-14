package controller;

import entity.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.KhachHangService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/update",
        "/khach-hang/detail",
        "/khach-hang/delete",
        "/khach-hang/view-update",

})
public class KhachHangServlet extends HttpServlet {
    private KhachHangService service = new KhachHangService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("khach-hang/hien-thi")) {
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


    protected void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        KhachHang khachHang = service.getById(id);
        req.setAttribute("kh", khachHang);
        hienthi(req, resp);
    }

    protected void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        KhachHang khachHang = service.getById(id);
        req.setAttribute("kh", khachHang);
        req.getRequestDispatcher("viewUpdate.jsp").forward(req, resp);
    }

    protected void hienthi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<KhachHang> list = service.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("khachhang.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        KhachHang khachHang = service.getById(id);
        service.delete(khachHang);
        hienthi(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UUID id = UUID.fromString(req.getParameter("id"));

        KhachHang khachHang = service.getById(id);
        String ten = req.getParameter("ten");
        String ho = req.getParameter("ho");
        String tendem = req.getParameter("tendem");
        String ngaysinhStr = req.getParameter("ngaysinh");
        String diachi = req.getParameter("diachi");
        String sdt = req.getParameter("sdt");

        khachHang.setHo(ho);
        khachHang.setTen(ten);
        khachHang.setDiachi(diachi);
        khachHang.setTendem(tendem);
        khachHang.setSdt(sdt);
        if (ngaysinhStr != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            try {
                Date ngaysinh = simpleDateFormat.parse(ngaysinhStr);
                khachHang.setNgaysinh(ngaysinh);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        service.update(khachHang);
        hienthi(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KhachHang khachhang = new KhachHang();
        String ten = req.getParameter("ten");
        String ma = req.getParameter("ma");
        String ho = req.getParameter("ho");
        String tendem = req.getParameter("tendem");
        String ngaysinhStr = req.getParameter("ngaysinh");
        String diachi = req.getParameter("diachi");
        String sdt = req.getParameter("sdt");
        boolean flag = false;
        if (ngaysinhStr.isEmpty()) {
            req.setAttribute("errorNgaySinh", "Ngay sinh khong duoc rong");
            flag = true;
        }

        if (ma.isEmpty()) {
            req.setAttribute("errorMa", "Ma khong duoc rong");
            flag = true;
        }

        if (ma.equals(service.validateCheckTrungMa(ma))) {
            req.setAttribute("errorMa", "Ma khong duoc trung");
            flag = true;
        }


        if (ten.isEmpty()) {
            req.setAttribute("errorTen", "Ten khong duoc rong");
            flag = true;
        }
        if (ho.isEmpty()) {
            req.setAttribute("errorHo", "Ho khong duoc rong");
            flag = true;
        }
        if (tendem.isEmpty()) {
            req.setAttribute("errorTenDem", "Ten dem khong duoc rong");
            flag = true;
        }

        if (diachi.isEmpty()) {
            req.setAttribute("errorDiaChi", "Dia chi khong duoc rong");
            flag = true;
        }

        if (sdt.isEmpty()) {
            req.setAttribute("errorSDT", "SDT khong duoc rong");
            flag = true;
        }

        if (flag) {
            hienthi(req, resp);
            return;
        }


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date ngaysinh = simpleDateFormat.parse(ngaysinhStr);
            khachhang.setNgaysinh(ngaysinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        khachhang.setMa(ma);
        khachhang.setHo(ho);
        khachhang.setTen(ten);
        khachhang.setDiachi(diachi);
        khachhang.setTendem(tendem);
        khachhang.setSdt(sdt);
        req.setAttribute("message", "them thanh cong");
        service.add(khachhang);
        hienthi(req, resp);
    }
}
