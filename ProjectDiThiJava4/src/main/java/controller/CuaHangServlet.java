package controller;

import entity.CuaHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CuaHangService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/cua-hang/hien-thi",
        "/cua-hang/delete",
        "/cua-hang/add",
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangService service = new CuaHangService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("cua-hang/hien-thi")) {
            hienthi(req, resp);
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
        List<CuaHang> list = service.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("cuahang.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        CuaHang cuaHang = service.getById(id);
        service.delete(cuaHang);
        req.setAttribute("message","Xoá thành công");
        hienthi(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       CuaHang cuaHang = new CuaHang();
        String ma = req.getParameter("ma");
        String thanhpho = req.getParameter("thanhpho");
        String quocgia = req.getParameter("quocgia");
        String ten = req.getParameter("ten");
        String diachi = req.getParameter("diachi");

        boolean flag= false;
        if(ma.isEmpty()){
            req.setAttribute("errorMa","Mã không được trống");
            flag=true;
        }
        if(ten.isEmpty()){
            req.setAttribute("errorTen","Tên không được trống");
            flag=true;
        }
        if(diachi.isEmpty()){
            req.setAttribute("errorDiaChi","Địa chỉ không được trống");
            flag=true;
        }

        if(flag){
            hienthi(req,resp);
            return;
        }
        cuaHang.setMa(ma);
        cuaHang.setTen(ten);
        cuaHang.setThanhpho(thanhpho);
        cuaHang.setQuocgia(quocgia);
        cuaHang.setDiachi(diachi);
        service.add(cuaHang);
        req.setAttribute("message","Thêm thành công");
        hienthi(req,resp);
    }
}
