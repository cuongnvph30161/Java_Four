package controller.user;


import entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.VideoService;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private VideoService service = new VideoService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        System.out.println("log keyword home "+" "+keyword);
        if(keyword == null) keyword = "%";
        System.out.println("In home, keyword=" + keyword);
        List<Video> items = service.search(keyword);
        req.setAttribute("requestURI", req.getRequestURI());
        req.setAttribute("listVideo", items);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
