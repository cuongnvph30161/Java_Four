package entity;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "CuaHang")
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String ma;
    private String ten;
    private String thanhpho;
    private String quocgia;
    private String diachi;

    public CuaHang() {
    }

    public CuaHang(UUID id, String ma, String ten, String thanhpho, String quocgia, String diachi) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.thanhpho = thanhpho;
        this.quocgia = quocgia;
        this.diachi = diachi;
    }

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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "CuaHang{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", thanhpho='" + thanhpho + '\'' +
                ", quocgia='" + quocgia + '\'' +
                ", diachi='" + diachi + '\'' +
                '}';
    }
}
