package controller;

import entity.Favorite;
import entity.User;
import entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bai2Cham2Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bai2")
public class bai2Cham2Servlet extends HttpServlet {
    bai2Cham2Service service = new bai2Cham2Service();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("bai2.1.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        req.setAttribute("key",userId);
        User user = service.finById(userId);
        req.setAttribute("user",user );
        List<Favorite> list = user.getListFavorite();

        List<Video> videoList = new ArrayList<>();
        for (Favorite favorite : list) {
            videoList.add(favorite.getVideo());
        }

        req.setAttribute("list", videoList);
        req.getRequestDispatcher("bai2.1.jsp").forward(req,resp);
    }
}
