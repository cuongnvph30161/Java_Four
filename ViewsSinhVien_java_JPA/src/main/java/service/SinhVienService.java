package service;

import entity.SinhVien;
import responsitory.SinhVienResponsitory;

import java.util.ArrayList;

public class SinhVienService {
    SinhVienResponsitory sinhVienResponsitory = new SinhVienResponsitory();

    public ArrayList<SinhVien> getAll() {
        return sinhVienResponsitory.getList();
    }
}
