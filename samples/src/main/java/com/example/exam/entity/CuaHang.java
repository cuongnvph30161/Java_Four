package com.example.exam.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity @Table(name="cuahang")
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String ma;
    String ten;
    String diachi;
    String thanhpho;
    String quocgia;

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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getThanhpho() {
        return thanhpho;
    }

    public void setThanhpho(String thanhpho) {
        this.thanhpho = thanhpho;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }
}
