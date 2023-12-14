package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "chieuCao")
    private String chieuCao;

    @Column(name = "canNang")
    private String canNang;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "lopId", referencedColumnName = "id") // chỉ định tên khoá ngoại ở cột hiện tại
    private Lop lop;
    public Student(int id, String ten, String diaChi, String gioiTinh, Lop lop, String chieuCao, String canNang) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.lop = lop;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public String getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(String chieuCao) {
        this.chieuCao = chieuCao;
    }

    public String getCanNang() {
        return canNang;
    }

    public void setCanNang(String canNang) {
        this.canNang = canNang;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", lop=" + lop +
                ", chieuCao='" + chieuCao + '\'' +
                ", canNang='" + canNang + '\'' +
                '}';
    }
}
