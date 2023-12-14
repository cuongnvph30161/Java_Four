package bai2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dang-ky")
public class DangKyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/bai2/Bai2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dangNhap = req.getParameter("dangnhap");
        String matKhau = req.getParameter("matkhau");
        String gioiTinh = (req.getParameter("gender"));
        String married = (req.getParameter("married"));
        String quocTich = req.getParameter("country");
        String ghiChu = req.getParameter("notes");
        req.setAttribute("dangnhap", dangNhap);
        req.setAttribute("matkhau", matKhau);
        req.setAttribute("gioitinh", gioiTinh);
        req.setAttribute("married", married);
        req.setAttribute("quoctich", quocTich);
        req.setAttribute("ghichu", ghiChu);
        req.getRequestDispatcher("/bai2/result.jsp").forward(req, resp);
    }
}
