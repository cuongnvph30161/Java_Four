package controller;

import entity.Lop;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import utility.HibernateUtil;

import java.io.IOException;

@WebServlet({"/hien-thi",
        "/view-create-student",
        "/create-student",
        "/view-update-student",
        "/update-student",
        "/delete-student"
})
public class StudentServlet extends HttpServlet {
    StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        req.setAttribute("listStudents", service.getAll());
        if (uri.contains("hien-thi")) {
            req.getRequestDispatcher("student/hienthi.jsp").forward(req, resp);
        } else if (uri.contains("view-create")) {
            viewCreate(req, resp);
        } else if (uri.contains("view-update-student")) {
            viewUpdate(req, resp);
        } else if (uri.contains("delete-student")) {
            delete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("create")) {
            create(req, resp);
        } else if (uri.contains("update-student")) {
            update(req, resp);
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteById(id);
        resp.sendRedirect("hien-thi");
    }

    protected void viewCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("student/add.jsp").forward(req, resp);
    }

    protected void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("LOg Id" + " " + id);
        req.setAttribute("student", service.getStudentById(id));
        req.getRequestDispatcher("student/update.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = service.getStudentById(Integer.parseInt(req.getParameter("id")));
        System.out.println("Ep Kieu" + " " + Integer.parseInt(req.getParameter("id")));
        student.setTen(req.getParameter("tensinhvien"));

        Lop lop = new Lop();
        int id = service.getLopIdByName(req.getParameter("tenLop"));
        lop.setId(id);
        student.setLop(lop);

        student.setGioiTinh(req.getParameter("gioiTinh "));
        student.setDiaChi(req.getParameter("diachi"));
        student.setChieuCao(req.getParameter("chieucao"));
        student.setCanNang(req.getParameter("cannang"));
        service.update(student);
        resp.sendRedirect("hien-thi");

    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tenSinhVien = req.getParameter("tensinhvien");
        String tenLop = req.getParameter("tenLop");
        String diaChi = req.getParameter("diachi");
        String gioiTinh = req.getParameter("gioitinh");
        String chieuCao = req.getParameter("chieucao");
        String canNang = req.getParameter("cannang");

        Lop lop = new Lop();
        int lopId = service.getLopIdByName(tenLop);
        lop.setId(lopId);

        Student student = new Student();
        student.setTen(tenSinhVien);
        student.setCanNang(canNang);
        student.setChieuCao(chieuCao);
        student.setDiaChi(diaChi);
        student.setGioiTinh(gioiTinh);
        student.setLop(lop);
        service.create(student);
        resp.sendRedirect("hien-thi");
    }

}
