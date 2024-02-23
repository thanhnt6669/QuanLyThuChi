package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import model.DiaChi;
import model.HoaDon;
import model.HocVien;
import model.GiangVien;
import gui.FrmQuanLyThu;
import dao.ConectDatabase;

public class ThongTinCaNhanDAO {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable tbQLT;
	public ThongTinCaNhanDAO() {
		// TODO Auto-generated constructor stub
		ConectDatabase.getInstance().connect();
	}
	
//	public static ResultSet ThucThiLenhSelect() {
//		try {
//			ConectDatabase.getInstance();
//			con = ConectDatabase.getConnection();
//			String CauLenhSQL = "SELECT gv.TenGiangVien, hv.TenHocVien, hv.GioiTinh, hv.NgaySinh, hd.MonHoc, hd.NgayThu, hv.MaDiaChi, hd.SoTien, hv.SoDienThoai, hd.TrangThai\r\n"
//					+ "FROM GiangVien	gv\r\n"
//					+ "	INNER JOIN HoaDon	hd	ON	gv.MaGiangVien	=	hd.MaGiangVien\r\n"
//					+ "	INNER JOIN HocVien	hv	ON	hd.MaHocVien	=	hv.MaHocVien\r\n"
//					+ "	INNER JOIN DiaChi	dc	ON	hv.MaDiaChi		=	dc.MaDiaChi";
//			
//			pst = con.prepareStatement(CauLenhSQL);
//			rs = pst.executeQuery();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//		
//	}
//	public List<HocVien> getAllHocVien() throws Exception {
//		List<HocVien> result = null;
//		HocVien hv;
//		try {
//			con = ConectDatabase.getInstance().getConnection();
//			String sql = "SELECT gv.TenGiangVien, hv.TenHocVien, hv.GioiTinh, hv.NgaySinh, hd.MonHoc, hd.NgayThu, hv.MaDiaChi, hd.SoTien, hv.SoDienThoai, hd.TrangThai\r\n"
//					+ "FROM GiangVien	gv\r\n"
//					+ "	INNER JOIN HoaDon	hd	ON	gv.MaGiangVien	=	hd.MaGiangVien\r\n"
//					+ "	INNER JOIN HocVien	hv	ON	hd.MaHocVien	=	hv.MaHocVien\r\n"
//					+ "	INNER JOIN DiaChi	dc	ON	hv.MaDiaChi		=	dc.MaDiaChi";
//			pst = con.prepareStatement(sql);
//			rs = pst.executeQuery();
//			result = new ArrayList<>();
//			while (rs.next()) {
//				String tenGV = rs.getString("TenGiangVien");
//				String TenHocVien = rs.getString("TenHocVien");
//				String gioiTinh = rs.getString("GioiTinh");
//				Date ngaySinh = rs.getDate("NgaySinh");
//				String monHoc = rs.getString("MonHoc");
//				Date ngayThu = rs.getDate("NgayThu");
//				int maDiaChi = rs.getInt("MaDiaChi");
//				Float soTien = rs.getFloat("SoTien");
//				String soDT = rs.getString("SoDienThoai");
//				String trangThai = rs.getString("TrangThai");
//				
//				DiaChi diaChi = new DiaChi();
//				diaChi.setMaDiaChi(maDiaChi);
//				hv = new HocVien(maDiaChi, TenHocVien, ngayThu, trangThai, trangThai, diaChi);
//				result.add(hv);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}

public void DoDuLieuVaoTable() {
	
	try {
	ResultSet rs = pst.executeQuery("SELECT gv.TenGiangVien, hv.TenHocVien, hv.GioiTinh, hv.NgaySinh, hd.MonHoc, hd.NgayThu, hv.MaDiaChi, hd.SoTien, hv.SoDienThoai, hd.TrangThai\r\n"
			+ "FROM GiangVien	gv\r\n"
			+ "	INNER JOIN HoaDon	hd	ON	gv.MaGiangVien	=	hd.MaGiangVien\r\n"
			+ "	INNER JOIN HocVien	hv	ON	hd.MaHocVien	=	hv.MaHocVien\r\n"
			+ "	INNER JOIN DiaChi	dc	ON	hv.MaDiaChi		=	dc.MaDiaChi");
	
	DefaultTableModel model = (DefaultTableModel) tbQLT.getModel();
	
		while(rs.next()) {
			Object obj[] = {tbQLT.getRowCount() +1 ,rs.getString("TenGiangVien"), rs.getString("TeHocVien"),rs.getString("GioiTinh"),rs.getDate("NgaySinh"),
					rs.getString("MonHoc"), rs.getString("MonHoc"), rs.getDate("NgayThu"), 	rs.getInt("MaDiaChi"), rs.getFloat("SoTien"),
					rs.getString("SoDienThoai"), rs.getString("TrangThai")};
			model.addRow(obj);
//			obj[0] = tbQLT.getRowCount() + 1; //STT
//			obj[1] = rs.getString("TenGiangVien");
//			obj[2] = rs.getString("TeHocVien");
//			obj[3] = rs.getString("GioiTinh");
//			obj[4] = rs.getDate("NgaySinh");
//			obj[5] = rs.getString("MonHoc");
//			obj[6] = rs.getDate("NgayThu");
//			obj[7] = rs.getInt("MaDiaChi");
//			obj[8] = rs.getFloat("SoTien");
//			obj[9] = rs.getString("SoDienThoai");
//			obj[10] = rs.getString("TrangThai");
			
			
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}
}
}