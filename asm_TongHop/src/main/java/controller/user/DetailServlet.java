package controller.user;


import entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.VideoService;

import java.io.IOException;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
private  VideoService service = new VideoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Video video = service.getById(id);
        req.setAttribute("video", video);
        req.getRequestDispatcher("/detail.jsp").forward(req, resp);
    }
}
