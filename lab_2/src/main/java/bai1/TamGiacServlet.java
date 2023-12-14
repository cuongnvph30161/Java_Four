package bai1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 3 link url
@WebServlet({"/tam-giac",
        "/dien-tich",
        "/chu-vi"
})
public class TamGiacServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Bai1.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double a = Double.parseDouble(req.getParameter("a"));
        double b = Double.parseDouble(req.getParameter("b"));
        double c = Double.parseDouble(req.getParameter("c"));
        double chuVi = (a + b + c);
        double dienTich = Math.sqrt(chuVi * (a + b - c) * (a + c - b) * (b + c - a)) / 4;
        String uri = req.getRequestURI();
        System.out.println("URI" + " " + uri);
        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            if (uri.contains("/dien-tich")) {
                req.setAttribute("message", "Diện tích tam giác:" + " " + dienTich);
            } else {
                req.setAttribute("message", "Chu vi tam giác:" + " " + chuVi);
            }
        } else {
            req.setAttribute("message", "Không thoả mãn là 1 tam giác");
        }
        req.getRequestDispatcher("Bai1.jsp").forward(req, resp);
    }
}
