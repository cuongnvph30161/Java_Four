package entity;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "ChiTietSP")

public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Integer nambh;
    private Integer soluongton;
    private Double gianhap;
    private String mota;

    public SanPham() {
    }

    public SanPham(UUID id, Integer nambh, Integer soluongton, Double gianhap, String mota) {
        this.id = id;
        this.nambh = nambh;
        this.soluongton = soluongton;
        this.gianhap = gianhap;
        this.mota = mota;
    }

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

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", nambh=" + nambh +
                ", soluongton=" + soluongton +
                ", gianhap=" + gianhap +
                ", mota='" + mota + '\'' +
                '}';
    }
}
