package com.example.asm1b2.controller;

import com.example.asm1b2.entity.Video;
import com.example.asm1b2.service.MovieService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@MultipartConfig
@WebServlet({
        "/movie",
        "/viewadd",
        "/add",
        "/update",
        "/view-update",
        "/delete"
})
public class MovieServlet extends HttpServlet {
    private MovieService service = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("viewadd")) {
            viewAddMovie(req, resp);
        } else if (uri.contains("movie")) {
            listMovie(req, resp);
        } else if (uri.contains("view-update")) {
            viewUpdateMovie(req, resp);
        } else {
            deleteMovie(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("update")) {
            updateMovie(req, resp);
        } else if (uri.contains("add")) {
            addMovie(req, resp);
        }
    }

    protected void listMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listMovie", service.getAll());
        req.getRequestDispatcher("movie.jsp").forward(req, resp);
    }

    protected void viewAddMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    protected void viewUpdateMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("movie", service.getById(id));
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    protected void addMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
       if(service.checkTrungIdMovie(id)){
           req.setAttribute("validateTrungIdMovie","Id đã tồn tại");
           req.getRequestDispatcher("add.jsp").forward(req, resp);


       }else{

           String title = req.getParameter("title");
           String description = req.getParameter("description");
           boolean active = Boolean.parseBoolean(req.getParameter("active"));
           String image = req.getParameter("image");
           Video movie = new Video(id, title, description, active, image);
           service.addMovie(movie);
           req.setAttribute("listMovie", service.getAll());
           req.getRequestDispatcher("movie.jsp").forward(req, resp);
       }

    }

    protected void updateMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Video movie = service.getById(id);
        if (movie != null) {
            movie.setTitle(req.getParameter("title"));
            movie.setDescription(req.getParameter("description"));
            movie.setActive(Boolean.parseBoolean(req.getParameter("active")));
            movie.setImage(req.getParameter("image"));
            service.update(movie);
            req.setAttribute("listMovie", service.getAll());
            req.getRequestDispatcher("movie.jsp").forward(req, resp);
        }
    }

    protected void deleteMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Video movie = service.getById(id);
        service.deleteMovie(movie);
        req.setAttribute("listMovie", service.getAll());
        req.getRequestDispatcher("movie.jsp").forward(req, resp);
    }

}
