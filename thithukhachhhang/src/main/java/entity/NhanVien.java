package entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id ;
    private String ma;
    private String ten;
    private Boolean gioitinh;
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    private String diachi;

    public NhanVien() {
    }

    public NhanVien(UUID id, String ma, String ten, Boolean gioitinh, Date ngaysinh, String diachi) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
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

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", diachi='" + diachi + '\'' +
                '}';
    }
}
