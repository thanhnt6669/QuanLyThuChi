package model;

import java.sql.Date;
import java.util.Vector;

public class GiangVien {
	private int MaGiangVien;
	
	private String TenGiangVien;
	private Date ngaySinh1;
	private String gioiTinh;
	
	private String soDienThoai;
	private DiaChi diaChi;
	

	public int getMaGiangVien() {
		return MaGiangVien;
	}
	public void setMaGiangVien(int MaGiangVien) {
		this.MaGiangVien = MaGiangVien;
	}
	
	public String getTenGiangVien() {
		return TenGiangVien;
	}
	public void setTenGiangVien(String TenGiangVien) {
		this.TenGiangVien = TenGiangVien;
	}
	public Date getNgaySinh() {
		return ngaySinh1;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh1 = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
	
	
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	
	
	public GiangVien(int MaGiangVien, String TenGiangVien, Date ngaySinh, String gioiTinh,
			String soDienThoai, DiaChi diaChi) {
		super();
		this.MaGiangVien = MaGiangVien;
		
		this.TenGiangVien = TenGiangVien;
		this.ngaySinh1 = ngaySinh;
		this.gioiTinh = gioiTinh;
	
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		
		
	}
	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NhanVien [MaGiangVien=" + MaGiangVien +  "TenGiangVien=" + TenGiangVien
				+ ", ngaySinh=" + ngaySinh1 + ", gioiTinh=" + gioiTinh + ", soDienThoai="
				+ soDienThoai + ", diaChi=" + diaChi + "]";
	}
	
	public Vector<Object> toVector() {
		Vector<Object> v = new Vector<>();
		v.add("");
		v.add(MaGiangVien);
		v.add(TenGiangVien);
		v.add(ngaySinh1);
		v.add(gioiTinh);
		
		v.add(soDienThoai);
		
		v.add(diaChi.getMaDiaChi());
		
		
		return v;
	}
}
	
