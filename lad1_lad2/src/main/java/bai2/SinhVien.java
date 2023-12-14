package bai2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sinhvien")
public class SinhVien extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/bai2/SinhVien.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten = req.getParameter("ten");
        String gioitinh = req.getParameter("gender");
        String sodienthoai = req.getParameter("sodienthoai");
        String ngaysinh = req.getParameter("ngaysinh");
        String chuyennghanh = req.getParameter("chuyennghanh");
        req.setAttribute("ten", ten);
        req.setAttribute("gioitinh", gioitinh);
        req.setAttribute("sdt", sodienthoai);
        req.setAttribute("ngaysinh", ngaysinh);
        req.setAttribute("chuyennghanh", chuyennghanh);
        req.getRequestDispatcher("/bai2/Result.jsp").forward(req, resp);
    }
}
