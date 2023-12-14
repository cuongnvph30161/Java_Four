package com.example.exam.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity @Table(name="nhanvien")
public class NhanVien {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    UUID id;
    String ma;
    String ten;
    Boolean gioitinh;

    @Temporal(TemporalType.DATE)
    Date ngaysinh;

    String diachi;

    // getters & setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
