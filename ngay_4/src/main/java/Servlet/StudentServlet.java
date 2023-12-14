package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("st", new Student("Tèo", 5.0));
        req.setAttribute("list",
                Arrays.asList(
                        new Student("tèo", 5.0);
        new Student("tèo", 5.0);

              );
        req.getRequestDispatcher("student.jsp").forward(req, resp);
    }
}
