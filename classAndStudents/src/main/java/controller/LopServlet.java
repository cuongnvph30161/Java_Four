package controller;

import entity.Lop;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.LopService;

import java.io.IOException;

@WebServlet({
        "/lophoc",
        "/view-create",
        "/create",
        "/view-update",
        "/update",
        "/delete"
})
public class LopServlet extends HttpServlet {
    LopService service = new LopService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        req.setAttribute("listLopHoc", service.getAll());

        if (uri.contains("lophoc")) {
            req.getRequestDispatcher("lop/hienthi.jsp").forward(req, resp);
        } else if (uri.contains("view-create")) {
            viewCreate(req, resp);
        } else if (uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if (uri.contains("delete")) {
            delete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("create")) {
            create(req, resp);
        } else if (uri.contains("update")) {
            updateLop(req, resp);
        }
    }

    protected void viewCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("lop/add.jsp").forward(req, resp);
    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Lop lop = new Lop();
        lop.setTenLop(req.getParameter("tenLop"));
        service.createLop(lop);
        resp.sendRedirect("lophoc");
    }

    protected void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("lophoc", service.getById(id));
        req.getRequestDispatcher("lop/update.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
       Lop lop = service.getById(id);
        service.deleteById(lop);
        resp.sendRedirect("lophoc");
    }

    protected void updateLop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Lop lop = service.getById(Integer.parseInt(req.getParameter("id")));
        lop.setTenLop(req.getParameter("tenLop"));
        service.updateLop(lop);
        resp.sendRedirect("lophoc");
    }
}
