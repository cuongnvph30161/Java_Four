package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    ArrayList<String> listName = new ArrayList<>();
    ArrayList<String> listPas = new ArrayList<>();


    public LoginServlet() {
        listName.add("phamanhtuan123");
        listPas.add("tuantienti1");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (name.equals("1") && password.equals("1")) {

            response.sendRedirect("/sinhVien/views");


        } else {

            request.getRequestDispatcher("formLogin.jsp").forward(request, response);
        }

    }
}
