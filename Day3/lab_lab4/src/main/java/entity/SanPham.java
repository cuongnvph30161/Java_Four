package entity;

public class SanPham {
    String tensanpham;
    String loaisanpham;
    double dongia;
    boolean conhang;

    public SanPham() {
    }

    public SanPham(String tensanpham, String loaisanpham, double dongia, boolean conhang) {
        this.tensanpham = tensanpham;
        this.loaisanpham = loaisanpham;
        this.dongia = dongia;
        this.conhang = conhang;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getLoaisanpham() {
        return loaisanpham;
    }

    public void setLoaisanpham(String loaisanpham) {
        this.loaisanpham = loaisanpham;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public boolean isConhang() {
        return conhang;
    }

    public void setConhang(boolean conhang) {
        this.conhang = conhang;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "tensanpham='" + tensanpham + '\'' +
                ", loaisanpham='" + loaisanpham + '\'' +
                ", dongia=" + dongia +
                ", conhang=" + conhang +
                '}';
    }
}
