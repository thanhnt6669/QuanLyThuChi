package controller;

import dao.ConectDatabase;
import gui.FrmDangNhap;
import gui.FrmManHinhChinh;

public class Main  {
public static void main(String[] args) {
	
		ConectDatabase.getInstance().connect();
		FrmDangNhap frmDangNhap = new FrmDangNhap();
		frmDangNhap.setVisible(true);
		frmDangNhap.setLocationRelativeTo(null);
//	FrmManHinhChinh frmManHinhChinh = new FrmManHinhChinh();
//	frmManHinhChinh.setVisible(true);
	}
}
