package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ten")
    private String hoTen;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @ManyToOne()
    @JoinColumn(name = "lop")
    private LopHoc lop;

    @Column(name = "chieuCao")
    private String chieuCao;

    @Column(name = "canNang")
    private String canNang;

}
