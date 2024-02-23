package model;

import util.Util;

import java.util.Date;

public class ThongTinThu implements IObject{
    private Long id;
    private String giangVienThu;
    private String tenHocVien;
    private String gioiTinh;
    private Date ngaySinh;
    private String monHoc;
    private Date ngayThu;
    private String diaChi;
    private Long soTien;
    private String soDienThoai;
    private String trangThai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGiangVienThu() {
        return giangVienThu;
    }

    public void setGiangVienThu(String giangVienThu) {
        this.giangVienThu = giangVienThu;
    }

    public String getTenHocVien() {
        return tenHocVien;
    }

    public void setTenHocVien(String tenHocVien) {
        this.tenHocVien = tenHocVien;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public Date getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(Date ngayThu) {
        this.ngayThu = ngayThu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Long getSoTien() {
        return soTien;
    }

    public void setSoTien(Long soTien) {
        this.soTien = soTien;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{
            id,
            giangVienThu,
            tenHocVien,
             gioiTinh,
                Util.formatDate(ngaySinh),
             monHoc,
                Util.formatDate(ngayThu),
             diaChi,
                soTien,
             soDienThoai,
             trangThai,
        };
    }
}
