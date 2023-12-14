package bai1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/diemtrungbinh")
public class DiemTrungBinh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/bai1/DiemTrungBinh.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double toan = Double.parseDouble(req.getParameter("toan"));
        double tienganh = Double.parseDouble(req.getParameter("tienganh"));
        double tinhoc = Double.parseDouble(req.getParameter("tinhoc"));
//        req.setAttribute("toan",toan);
//        req.setAttribute("tienganh",tienganh);
//        req.setAttribute("tinhoc",tinhoc);
        double diemtrungbinh = (toan + tienganh + tinhoc) / 3;
        req.setAttribute("diemtrungbinh", diemtrungbinh);
        req.getRequestDispatcher("/bai1/Result.jsp").forward(req, resp);
    }
}
