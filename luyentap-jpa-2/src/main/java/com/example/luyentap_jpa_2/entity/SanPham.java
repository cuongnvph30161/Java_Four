package com.example.luyentap_jpa_2.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="chitietsp")
public class SanPham {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    UUID id;
    Integer nambh;
    String mota;
    Integer soluongton;
    Double gianhap;

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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
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
}
