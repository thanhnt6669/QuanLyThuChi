package model;

import java.sql.Date;
import java.util.Vector;

public class HocVien {
	private int MaHocVien;
	
	private String TenHocVien;
	private Date ngaySinh1;
	private String gioiTinh;
	
	private String soDienThoai;
	private DiaChi diaChi;
	

	public int getMaHocVien() {
		return MaHocVien;
	}
	public void setMaHocVien(int MaHocVien) {
		this.MaHocVien = MaHocVien;
	}
	
	public String getTenHocVien() {
		return TenHocVien;
	}
	public void setTenHocVien(String TenHocVien) {
		this.TenHocVien = TenHocVien;
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
	
	
	public HocVien(int MaHocVien, String TenHocVien, Date ngaySinh, String gioiTinh,
			String soDienThoai, DiaChi diaChi) {
		super();
		this.MaHocVien = MaHocVien;
		
		this.TenHocVien = TenHocVien;
		this.ngaySinh1 = ngaySinh;
		this.gioiTinh = gioiTinh;
	
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		
		
	}
	public HocVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NhanVien [MaHocVien=" + MaHocVien +  "TenHocVien=" + TenHocVien
				+ ", ngaySinh=" + ngaySinh1 + ", gioiTinh=" + gioiTinh + ", soDienThoai="
				+ soDienThoai + ", diaChi=" + diaChi + "]";
	}
	
	public Vector<Object> toVector() {
		Vector<Object> v = new Vector<>();
		v.add("");
		v.add(MaHocVien);
		v.add(TenHocVien);
		v.add(ngaySinh1);
		v.add(gioiTinh);
		
		v.add(soDienThoai);
		
		v.add(diaChi.getMaDiaChi());
		
		
		return v;
	}
}
	
