package service;

import entity.SanPham;

import java.util.ArrayList;
import java.util.List;

public class DanhSachService {
    List<SanPham> list = new ArrayList<>();

    public DanhSachService() {
        list.add(new SanPham("Iphone11", "Iphone", 10000, true));
    }

    public List<SanPham> getAll() {
        return list;
    }

    public void add(SanPham sanPham) {
        list.add(sanPham);

    }
}
