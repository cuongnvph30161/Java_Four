package com.example.exam.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity @Table(name="chitietsp")
public class SanPham {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    Integer nambh;
    Integer soluongton;
    Double gianhap;
    String mota;

    // getter && setter (Alt+Insert --> Getter & Setter)

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNambh() {
        return nambh;
    }

    public void setNambh(Integer nambh) {
        this.nambh = nambh;
    }

    public Integer getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(Integer soluongton) {
        this.soluongton = soluongton;
    }

    public Double getGianhap() {
        return gianhap;
    }

    public void setGianhap(Double gianhap) {
        this.gianhap = gianhap;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
