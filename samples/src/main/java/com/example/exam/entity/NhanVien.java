package com.example.exam.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity @Table(name="nhanvien")
public class NhanVien {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String ma;
    String ten;
    String gioitinh;
    String diachi;

    // getter && setter (Alt+Insert --> Getter & Setter)

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

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
