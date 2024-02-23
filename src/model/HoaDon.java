package model;

import java.util.Date;

public class HoaDon {
	private String maHoaDon;
	
	private String maGiangVien;
	private String maHocVien;
	private String monHoc;
	private Date ngayThu;
	private Float soTien;
	private String trangThai;
	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaGiangVien() {
		return maGiangVien;
	}

	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}

	public String getMaHocVien() {
		return maHocVien;
	}

	public void setMaHocVien(String maHocVien) {
		this.maHocVien = maHocVien;
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

	public Float getSoTien() {
		return soTien;
	}

	public void setSoTien(Float soTien) {
		this.soTien = soTien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public HoaDon(String maHoaDon, String maGiangVien, String maHocVien, String monHoc, Date ngayThu, Float soTien,
			String trangThai) {
		super();
		this.maHoaDon = maHoaDon;
		this.maGiangVien = maGiangVien;
		this.maHocVien = maHocVien;
		this.monHoc = monHoc;
		this.ngayThu = ngayThu;
		this.soTien = soTien;
		this.trangThai = trangThai;
	}
	public HoaDon() {
		super();
	}
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maGiangVien=" + maGiangVien + ", maHocVien=" + maHocVien
				+ ", monHoc=" + monHoc + ", ngayThu=" + ngayThu + ", soTien=" + soTien + ", trangThai=" + trangThai
				+ "]";
	}

}
