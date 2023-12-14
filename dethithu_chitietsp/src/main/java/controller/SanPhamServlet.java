package controller;

import entity.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SanPhamService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/detail",
        "/san-pham/delete",
        "/san-pham/view-update",
        "/san-pham/update",
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamService service = new SanPhamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("san-pham/hien-thi")) {
            hienthi(req, resp);
        } else if (uri.contains("delete")) {
            delete(req, resp);
        } else if (uri.contains("detail")) {
            detail(req, resp);
        } else if (uri.contains("view-update")) {
            viewUpdate(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            add(req, resp);
        } else if (uri.contains("update")) {
            update(req, resp);
        }
    }

    protected void hienthi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SanPham> list = service.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("chitietsanpham.jsp").forward(req, resp);
    }

    protected void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        req.setAttribute("sanpham", service.getById(id));
        System.out.println("oooooooooooooooo" + " " + service.getById(id));
        hienthi(req, resp);

    }

    protected void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        req.setAttribute("sanpham", service.getById(id));
        req.getRequestDispatcher("view-update.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        SanPham sanPham = service.getById(id);
        System.out.println("====================="+" "+sanPham);
        int namBH = Integer.parseInt(req.getParameter("nambh"));
        int soluongton = Integer.parseInt(req.getParameter("soluongton"));
        double gianhap = Double.parseDouble(req.getParameter("gianhap"));
        String mota = req.getParameter("mota");


        sanPham.setGianhap(gianhap);
        System.out.println("logggggggggggggggggggggg"+" "+sanPham.getGianhap());
        sanPham.setMota(mota);
        sanPham.setNambh(namBH);
        sanPham.setSoluongton(soluongton);
        service.update(sanPham);
        req.setAttribute("message", "Update  thành công");
        hienthi(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        SanPham sanPham = service.getById(id);
        service.delete(sanPham);
        req.setAttribute("message", "Xoá thành công");
        hienthi(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SanPham sanPham = new SanPham();
        boolean flag = false;
        String namBHStr = req.getParameter("nambh");
        int namBH = Integer.parseInt(namBHStr);

        String soluongtonStr = req.getParameter("soluongton");
        if (soluongtonStr.isEmpty()) {
            req.setAttribute("errorSoLuongTon", "So luong ton khong duoc rong");
            flag = true;
        } else {
            try {
                int soluongton = Integer.parseInt(soluongtonStr);

                if (soluongton < 0) {
                    req.setAttribute("errorSoLuongTon", "so luong ton  phai >0");
                    flag = true;
                }
                sanPham.setSoluongton(soluongton);
            } catch (NumberFormatException e) {
                req.setAttribute("errorSoLuongTon", "so luong ton  phai la so");
                flag = true;
            }

        }


        String gianhapStr = req.getParameter("gianhap");
        if (gianhapStr.isEmpty()) {
            req.setAttribute("errorGiaNhap", "Gia Nhap khong duoc rong");
            flag = true;
        }

        String mota = req.getParameter("mota");
        if (mota.isEmpty()) {
            req.setAttribute("errorMota", "Mo ta khong duoc rong");
            flag = true;
        }

        if (flag) {
            hienthi(req, resp);
            return;
        }

        double gianhap = Double.parseDouble(gianhapStr);
        sanPham.setGianhap(gianhap);
        sanPham.setMota(mota);
        sanPham.setNambh(namBH);
        service.add(sanPham);
        req.setAttribute("message", "Thêm thành công");
        hienthi(req, resp);
    }

}
