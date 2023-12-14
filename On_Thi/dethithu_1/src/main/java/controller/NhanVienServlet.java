package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NhanVienService;

import java.io.IOException;

@WebServlet("/nhan-vien/hien-thi",
        "/nhan-vien/view-add",
        "/nhan-vien/add",
        "/nhan-vien/delete"
)
public class NhanVienServlet extends HttpServlet {
    NhanVienService service = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("nhan-vien/hien-thi")){
            req.setAttribute("list",service.getAll());
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
