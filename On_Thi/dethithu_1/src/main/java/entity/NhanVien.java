package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id ;

    @Column(name = "MaNV")
    private String manv;

    @Column(name = "HoTen")
    private String hoten;

    @Column(name = "DiaChi")
    private String diachi;

    @Column(name = "GioiTinh")
    private boolean gioitinh;

}
