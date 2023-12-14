package com.example.kiemtra1.servlet;

import com.example.kiemtra1.model.ThucVat;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ThucVatServlet", value = {"/thuc-vat/hien-thi-tat-ca",
        "/thuc-vat/remove"}
)
public class ThucVatServlet extends HttpServlet {

    ArrayList<ThucVat> listThucVat = new ArrayList<>();

    public ThucVatServlet() {
        listThucVat.add(new ThucVat(1, "Cây ăn quả", "Táo", 3, true, "Đồng Bằng"));
        listThucVat.add(new ThucVat(1, "Cây ăn quả", "Cam", 4, true, "Trung du miền núi"));
        listThucVat.add(new ThucVat(1, "Cây ăn quả", "Sầu riêng", 5, false, "miền nam"));
        listThucVat.add(new ThucVat(1, "Cây ăn quả", "Xoài", 7, true, "Bắc giang"));
        listThucVat.add(new ThucVat(1, "Cây ăn quả", "Mít", 10, false, "miền bắc"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi-tat-ca")) {
            request.setAttribute("listThucVat", listThucVat);
            request.getRequestDispatcher("/hienThi.jsp").forward(request, response);
        }
        if (uri.contains("/remove")) {
            this.delete(request, response);
            request.setAttribute("listThucVat", listThucVat);
        }
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vitri = Integer.parseInt(request.getParameter("vitri"));
        listThucVat.remove(vitri);
        response.sendRedirect("/thuc-vat/hien-thi-tat-ca");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
