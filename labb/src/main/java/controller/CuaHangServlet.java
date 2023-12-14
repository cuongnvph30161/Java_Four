package controller;

import entity.CuaHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CuaHangService;

import java.io.IOException;

@WebServlet({"/hienthi-cuahang",
        "/view-create",
        "/create",
        "/delete"
})
public class CuaHangServlet extends HttpServlet {
    CuaHangService service = new CuaHangService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hienthi-cuahang")) {
            req.setAttribute("list", service.getAll());
            req.getRequestDispatcher("hienthi.jsp").forward(req, resp);
        } else if (uri.contains("view-create")) {
            viewCreate(req, resp);
        } else if (uri.contains("delete")) {
            delete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("create")) {
            create(req, resp);
        }
    }

    protected void viewCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("create.jsp").forward(req, resp);
    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean flag = false;
        String ma = req.getParameter("ma");

        if (ma == null || ma.isEmpty()) {
            req.setAttribute("errorMa", "Mã không được rỗng");
            req.setAttribute("maValue", ma);
            flag = true;
        }

        String ten = req.getParameter("ten");
        if (ten.equals("")) {
            req.setAttribute("errorTen", "Không được rỗng Tên");
            req.setAttribute("tenValue", ten);
            flag = true;
            req.getRequestDispatcher("create.jsp").forward(req,resp);
        }
        String diaChi = req.getParameter("diachi");
        if (diaChi.equals("")) {
            req.setAttribute("errorDiaChi", "Không được rỗng Địa Chỉ");
            req.setAttribute("diaChiValue", diaChi);
            flag = true;
        }

        if (flag) {
            req.getRequestDispatcher("create.jsp").forward(req, resp);
            return;
        }
        String thanhPho = req.getParameter("thanhpho");
        String quocGia = req.getParameter("quocgia");
        CuaHang cuaHang = new CuaHang();
        cuaHang.setMa(ma);
        cuaHang.setTen(ten);
        cuaHang.setDiachi(diaChi);
        cuaHang.setQuocgia(quocGia);
        cuaHang.setThanhpho(thanhPho);
        service.create(cuaHang);
        resp.sendRedirect("hienthi-cuahang");


    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.delete(id);
        resp.sendRedirect("hienthi-cuahang");
    }


}
