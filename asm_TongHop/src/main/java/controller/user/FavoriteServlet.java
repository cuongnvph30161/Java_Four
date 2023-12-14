package controller.user;


import entity.Favorite;
import entity.User;
import entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.FavoriteService;
import service.VideoService;

import java.io.IOException;
import java.util.List;

@WebServlet({"/favorite",
        "/insert-favorite",
        "/delete-favorite"
})
public class FavoriteServlet extends HttpServlet {
    private VideoService service = new VideoService();
    private FavoriteService favoriteService = new FavoriteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("requestURI", req.getRequestURI());
        /* Lấy ra được id của bảng User */
        String username = (String) req.getSession().getAttribute("username");

        if (username == null) {
            resp.sendRedirect("login");
            return;
        }

        /*Lấy ra được title của Video*/
        String keyword = req.getParameter("keyword");
        if (keyword == null) keyword = "%";

        List<Video> items = service.searchFavorite(username, keyword);
        req.setAttribute("listVideo", items);
        req.getRequestDispatcher("favorite.jsp").forward(req, resp);
        String uri = req.getRequestURI();
        if (uri.contains("delete-favorite")) {
            deleteFavorite(req, resp);
        } else if (uri.contains("insert-favorite")) {
            insert(req, resp);
        } else if (uri.contains("delete-favorite")) {
            deleteFavorite(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        String videoId = req.getParameter("id");

        User user = new User();
        user.setId(username);
        Video video = new Video();
        video.setId(videoId);

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setVideo(video);
        favoriteService.insert(favorite);

        if (username == null) {
            resp.sendRedirect("login");
            return;
        }

        /*Lấy ra được title của Video*/
        String keyword = req.getParameter("keyword");
        if (keyword == null) keyword = "%";

        List<Video> items = service.searchFavorite(username, keyword);
        req.setAttribute("listVideo", items);
        req.getRequestDispatcher("favorite.jsp").forward(req, resp);

    }

    protected void deleteFavorite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        String videoId = req.getParameter("id");
        User user = new User();
        user.setId(username);
        Video video = new Video();
        video.setId(videoId);
        favoriteService.delete(username, videoId);

        if (username == null) {
            resp.sendRedirect("login");
            return;
        }

        /*Lấy ra được title của Video*/
        String keyword = req.getParameter("keyword");
        if (keyword == null) keyword = "%";

        List<Video> items = service.searchFavorite(username, keyword);
        req.setAttribute("listVideo", items);
        req.getRequestDispatcher("favorite.jsp").forward(req, resp);

    }

}

