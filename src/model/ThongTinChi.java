package model;

import util.Util;

import java.util.Date;

public class ThongTinChi implements IObject{
    private Long id;
    private String giangVien;
    private String nhanVienChi;
    private String gioiTinh;
    private Long soTien;
    private String monGiangDay;
    private Date ngayChi;
    private String soDienThoai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }

    public String getNhanVienChi() {
        return nhanVienChi;
    }

    public void setNhanVienChi(String nhanVienChi) {
        this.nhanVienChi = nhanVienChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Long getSoTien() {
        return soTien;
    }

    public void setSoTien(Long soTien) {
        this.soTien = soTien;
    }

    public String getMonGiangDay() {
        return monGiangDay;
    }

    public void setMonGiangDay(String monGiangDay) {
        this.monGiangDay = monGiangDay;
    }

    public Date getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(Date ngayChi) {
        this.ngayChi = ngayChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public Object[] toObject() {

        return new Object[]{
                id,
                giangVien,
                nhanVienChi,
                gioiTinh,
                soTien,
                monGiangDay,
                Util.formatDate(ngayChi),
                soDienThoai
        };
    }
}
