package com.example.kiemtra1.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class ThucVat {
private Integer  id;
private String loaiCay;
private String ten;
private Integer tuoi;
private boolean gioiTinh;
private String khuVuc;

}
