package servlet;

import entity.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.SinhVienService;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "sinhVienServlet", value = "/sinhVien/views")
public class sinhVienServlet extends HttpServlet {
    SinhVienService sinhVienService = new SinhVienService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/views")) {
            this.getList(request, response);

        }
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SinhVien> list = sinhVienService.getAll();
        request.setAttribute("listSinhVien",list);
        request.getRequestDispatcher("/viewsSinhVien.jsp").forward(request, response);
    }


}
