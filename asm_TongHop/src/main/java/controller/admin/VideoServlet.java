package controller.admin;

import entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.VideoService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet({
        "/video",
        "/view-addVideo",
        "/addVideo",
        "/updateVideo",
        "/view-updateVideo",
        "/deleteVideo",
        "/viewItem"

})

public class VideoServlet extends HttpServlet {
    private VideoService service = new VideoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("video")) {
            listVideo(req, resp);
        } else if (uri.contains("view-addVideo")) {
            viewAddVideo(req, resp);
        } else if (uri.contains("deleteVideo")) {
            deleteVideo(req, resp);
        }else if(uri.contains("viewItem")){
            listVideoLenItem(req,resp);
        }else if(uri.contains("view-updateVideo")){
            viewUpdateMovie(req,resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("addVideo")) {
            System.out.println("1");
            addVideo(req, resp);
        }else if(uri.contains("updateVideo")){
            updateVideo(req,resp);
        }
    }

    protected void listVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listVideo", service.getAll());
        req.getRequestDispatcher("video/video.jsp").forward(req, resp);
    }

    protected void listVideoLenItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listVideo",service.getAll());
        req.getRequestDispatcher("items.jsp").forward(req,resp);
    }

    protected void viewAddVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("video/add.jsp").forward(req, resp);
    }

    protected void viewUpdateMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("video", service.getById(id));
        req.getRequestDispatcher("/video/update.jsp").forward(req, resp);
    }

    protected void updateVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Video video = service.getById(id);
        if (video != null) {
            video.setTitle(req.getParameter("title"));
            video.setDescription(req.getParameter("description"));
            video.setActive(Boolean.parseBoolean(req.getParameter("active")));
            video.setPoster(req.getParameter("image"));
            service.update(video);
            resp.sendRedirect("video");

        }
    }

    protected void addVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (service.checkTrungIdVideo(id) == null) {
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            boolean active = Boolean.parseBoolean(req.getParameter("active"));
            String poster = req.getParameter("image");

            Video video = new Video();
            video.setId(id);
            video.setActive(active);
            video.setDescription(description);
            video.setTitle(title);
            video.setPoster(poster);
            service.createVideo(video);
            resp.sendRedirect("video");
        } else {
            req.setAttribute("validateTrungIdVideo", "Id đã tồn tại");
            req.getRequestDispatcher("video/add.jsp").forward(req, resp);
        }

    }




    protected void deleteVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Video video = service.getById(id);
        service.deleteVideo(video);
        resp.sendRedirect("video");
    }

}
