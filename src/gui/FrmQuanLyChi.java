package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.*;

import java.util.List;
import java.util.Locale;
import javax.swing.JRadioButton;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import dao.ThongTinChiDAO;
import model.IObject;
import model.ThongTinChi;
import model.ThongTinThu;
import util.Util;


import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmQuanLyChi extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private ThongTinChiDAO thongTinChiDAO = new ThongTinChiDAO();
	public static JPanel pnlTabXemQuanLyChi ;
	private JTextField txtGiangVien;
	private JTextField txtSoTien;
	private JTable tbl_ThongTinChi;
	private JTextField txtNhanVienChi;
	private JTextField txtTim;
	private JDateChooser dateNgayChi;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnTim;
	private JButton btnThoat;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private JRadioButton radSDT;
	private JRadioButton radTen;
	private DefaultTableModel model;
	private ButtonGroup buttonGroupGioiTinh;
	private JButton btnLamMoi;
	private ButtonGroup buttonGroupTim;
	private JTextField txtSoDienThoai;

	int rowChoose = -1;

	private void loadDataToTabel(List<? extends IObject> list, JTable table){
		((DefaultTableModel)table.getModel()).setRowCount(0);
		for(IObject object: list){
			addRowToTable(object, table);
		}
	}
	private void addRowToTable(IObject object, JTable table){
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.addRow(object.toObject());
	}

	public FrmQuanLyChi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1338, 676);
		setLocationRelativeTo(null);
		
		pnlTabXemQuanLyChi = new JPanel();
		getContentPane().add(pnlTabXemQuanLyChi);
		

		pnlTabXemQuanLyChi.setLayout(null);
		


		JPanel pnlThongTinChi = new JPanel();
		pnlThongTinChi.setBounds(0, 11, 1283, 622);
		pnlTabXemQuanLyChi.add(pnlThongTinChi);
		pnlThongTinChi.setLayout(null);

		JLabel lbl_GiangVien = new JLabel("Giảng viên:");
		lbl_GiangVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_GiangVien.setBounds(99, 76, 78, 21);
		pnlThongTinChi.add(lbl_GiangVien);

		txtGiangVien = new JTextField();
		txtGiangVien.setToolTipText("Tên giảng viên");
		txtGiangVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtGiangVien.setColumns(10);
		txtGiangVien.setBounds(210, 74, 284, 25);
		pnlThongTinChi.add(txtGiangVien);

		JLabel lbl_NgayChi = new JLabel("Ngày chi:");
		lbl_NgayChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_NgayChi.setBounds(661, 150, 89, 26);
		pnlThongTinChi.add(lbl_NgayChi);

		JLabel lbl_SoTien = new JLabel("Số tiền:");
		lbl_SoTien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_SoTien.setBounds(661, 74, 78, 25);
		pnlThongTinChi.add(lbl_SoTien);

		txtSoTien = new JTextField();
		txtSoTien.setToolTipText("Số tiền chi cho giảng viên");
		txtSoTien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtSoTien.setColumns(10);
		txtSoTien.setBounds(769, 74, 199, 25);
		pnlThongTinChi.add(txtSoTien);

		btnThem = new JButton("Thêm");
		
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnThem.setBounds(161, 187, 120, 30);
		pnlThongTinChi.add(btnThem);

		JPanel pnl_ThongTinChi = new JPanel();
		pnl_ThongTinChi.setToolTipText("Danh sách chi tiền");
		pnl_ThongTinChi.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch chi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_ThongTinChi.setBounds(10, 241, 1238, 251);
		pnlThongTinChi.add(pnl_ThongTinChi);
		pnl_ThongTinChi.setLayout(null);

		JScrollPane scr_ThongTinChi = new JScrollPane();
		scr_ThongTinChi.setBounds(10, 22, 1218, 203);
		pnl_ThongTinChi.add(scr_ThongTinChi);

		String[] tb = new String[] { "STT", "Giảng viên", "Nhân viên chi", "Giới tính", "Số tiền", "Môn",  "Ngày chi", "SĐT"};
		model = new DefaultTableModel(tb, 0);
		tbl_ThongTinChi = new JTable(model);
		tbl_ThongTinChi.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tbl_ThongTinChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scr_ThongTinChi.setViewportView(tbl_ThongTinChi);

		JLabel lbl_GioiTinh = new JLabel("Giới Tính:");
		lbl_GioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_GioiTinh.setBounds(109, 150, 68, 26);
		pnlThongTinChi.add(lbl_GioiTinh);

		radNam = new JRadioButton("Nam");
		radNam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radNam.setBounds(205, 155, 63, 21);
		pnlThongTinChi.add(radNam);

		radNu = new JRadioButton("Nữ");
		radNu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radNu.setBounds(283, 155, 63, 21);
		pnlThongTinChi.add(radNu);

		buttonGroupGioiTinh = new ButtonGroup();
		buttonGroupGioiTinh.add(radNam);
		buttonGroupGioiTinh.add(radNu);

		JLabel lbl_ThongTinChi = new JLabel("THÔNG TIN CHI");
		lbl_ThongTinChi.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lbl_ThongTinChi.setForeground(Color.RED);
		lbl_ThongTinChi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ThongTinChi.setBounds(10, 11, 1263, 54);
		pnlThongTinChi.add(lbl_ThongTinChi);

		dateNgayChi = new JDateChooser();
		dateNgayChi.setToolTipText("Ngày chi tiền");
		dateNgayChi.setBounds(769, 150, 296, 25);
		pnlThongTinChi.add(dateNgayChi);
		dateNgayChi.setLocale(Locale.forLanguageTag("vi-VN"));
		dateNgayChi.setDateFormatString("dd/MM/yyyy");

		JLabel lbl_NhanVienChi = new JLabel("Nhân viên chi:");
		lbl_NhanVienChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_NhanVienChi.setBounds(99, 109, 98, 26);
		pnlThongTinChi.add(lbl_NhanVienChi);

		txtNhanVienChi = new JTextField();
		txtNhanVienChi.setToolTipText("Tên nhân viên chi");
		txtNhanVienChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNhanVienChi.setColumns(10);
		txtNhanVienChi.setBounds(210, 110, 284, 25);
		pnlThongTinChi.add(txtNhanVienChi);

		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setIcon(new ImageIcon("Hinh\\empty.png"));
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnXoaRong.setBounds(293, 187, 120, 30);
		pnlThongTinChi.add(btnXoaRong);

		JPanel panel = new JPanel();
		panel.setToolTipText("Các chức năng");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "C\u00E1c ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 503, 982, 100);
		pnlThongTinChi.add(panel);
		panel.setLayout(null);

		radSDT = new JRadioButton("Số điện thoại");
		radSDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radSDT.setBounds(57, 59, 114, 23);
		panel.add(radSDT);

		radTen = new JRadioButton("Tên");
		radTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radTen.setBounds(58, 26, 55, 23);
		panel.add(radTen);

		buttonGroupTim = new ButtonGroup();
		buttonGroupTim.add(radSDT);
		buttonGroupTim.add(radTen);

		JLabel lblNhpThngTin = new JLabel("Nhập thông tin tìm kiếm:");
		lblNhpThngTin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNhpThngTin.setBounds(234, 39, 158, 25);
		panel.add(lblNhpThngTin);

		txtTim = new JTextField();
		txtTim.setBounds(397, 40, 270, 25);
		panel.add(txtTim);
		txtTim.setColumns(10);

		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnTim.setBounds(690, 39, 120, 30);
		panel.add(btnTim);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLamMoi.setBounds(835, 39, 120, 30);
		panel.add(btnLamMoi);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnThoat.setBounds(1094, 581, 120, 30);
		pnlThongTinChi.add(btnThoat);
		
		JLabel lbl_MonGiangDay = new JLabel("Môn giảng dạy:");
		lbl_MonGiangDay.setToolTipText("Môn giảng dạy");
		lbl_MonGiangDay.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_MonGiangDay.setBounds(661, 110, 98, 26);
		pnlThongTinChi.add(lbl_MonGiangDay);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnXoa.setBounds(1094, 544, 120, 30);
		pnlThongTinChi.add(btnXoa);
		
		JLabel lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_SoDienThoai.setBounds(661, 186, 89, 25);
		pnlThongTinChi.add(lbl_SoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setToolTipText("Số điện thoại của giảng viên");
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(769, 186, 248, 25);
		pnlThongTinChi.add(txtSoDienThoai);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSua.setBounds(1094, 503, 120, 30);
		pnlThongTinChi.add(btnSua);
		
		JComboBox cboMonHoc = new JComboBox();
		cboMonHoc.setModel(new DefaultComboBoxModel(new String[] {"Toan", "Ly", "Hoa", "Anh", "Van"}));
		cboMonHoc.setToolTipText("Chọn môn giảng dạy");
		cboMonHoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboMonHoc.setBounds(769, 112, 82, 23);
		pnlThongTinChi.add(cboMonHoc);
	//	btnXoa.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnTim.addActionListener(this);
		btnThoat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		tbl_ThongTinChi.addMouseListener(this);

		loadDataToTabel(thongTinChiDAO.getAll(), tbl_ThongTinChi);

		btnThem.addActionListener((e) -> {
			ThongTinChi thongTinChi = new ThongTinChi();
			thongTinChi.setGiangVien(txtGiangVien.getText());
			thongTinChi.setNhanVienChi(txtNhanVienChi.getText());
			thongTinChi.setGioiTinh(radNam.isSelected()? "Nam" : "Nu");
			thongTinChi.setSoTien(Long.valueOf(txtSoTien.getText()));
			thongTinChi.setMonGiangDay(cboMonHoc.getSelectedItem().toString());
			thongTinChi.setNgayChi(dateNgayChi.getDate());
			thongTinChi.setSoDienThoai(txtSoDienThoai.getText());
			thongTinChiDAO.save(thongTinChi);
			loadDataToTabel(thongTinChiDAO.getAll(), tbl_ThongTinChi);
		});

		btnSua.addActionListener((e) -> {
			ThongTinChi thongTinChi = new ThongTinChi();
			thongTinChi.setId(Long.valueOf(tbl_ThongTinChi.getValueAt(rowChoose, 0).toString()));
			thongTinChi.setGiangVien(txtGiangVien.getText());
			thongTinChi.setNhanVienChi(txtNhanVienChi.getText());
			thongTinChi.setGioiTinh(radNam.isSelected()? "Nam" : "Nu");
			thongTinChi.setSoTien(Long.valueOf(txtSoTien.getText()));
			thongTinChi.setMonGiangDay(cboMonHoc.getSelectedItem().toString());
			thongTinChi.setNgayChi(dateNgayChi.getDate());
			thongTinChi.setSoDienThoai(txtSoDienThoai.getText());
			thongTinChiDAO.save(thongTinChi);
			loadDataToTabel(thongTinChiDAO.getAll(), tbl_ThongTinChi);
		});

		btnXoaRong.addActionListener((e) -> {
			txtGiangVien.setText("");
			txtNhanVienChi.setText("");
			radNam.setSelected(false);
			radNu.setSelected(false);
			txtSoTien.setText("");
			txtSoDienThoai.setText("");
			dateNgayChi.setCalendar(null);
		});

		btnThoat.addActionListener((e) -> {
			System.exit(0);
		});

		btnXoa.addActionListener((e) -> {
			thongTinChiDAO.delete(Long.valueOf(tbl_ThongTinChi.getValueAt(rowChoose, 0).toString()));
			loadDataToTabel(thongTinChiDAO.getAll(), tbl_ThongTinChi);
			txtGiangVien.setText("");
			txtNhanVienChi.setText("");
			radNam.setSelected(false);
			radNu.setSelected(false);
			txtSoTien.setText("");
			txtSoDienThoai.setText("");
			dateNgayChi.setCalendar(null);
		});

		tbl_ThongTinChi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowChoose = tbl_ThongTinChi.getSelectedRow();

				txtGiangVien.setText(tbl_ThongTinChi.getValueAt(rowChoose, 1).toString());
				txtNhanVienChi.setText(tbl_ThongTinChi.getValueAt(rowChoose, 2).toString());
				if(tbl_ThongTinChi.getValueAt(rowChoose, 3).toString().length() == 2){
					radNu.setSelected(true);
					radNam.setSelected(false);
				} else{
					radNam.setSelected(true);
					radNu.setSelected(false);
				}
				dateNgayChi.setDate(Util.toDate(tbl_ThongTinChi.getValueAt(rowChoose, 6).toString()));
				txtSoTien.setText(tbl_ThongTinChi.getValueAt(rowChoose, 4).toString());
				txtSoDienThoai.setText(tbl_ThongTinChi.getValueAt(rowChoose, 7).toString());
			}
		});

		btnLamMoi.addActionListener((e) -> {
			txtTim.setText("");
			radSDT.setSelected(false);
			radTen.setSelected(false);
		});

		btnTim.addActionListener((e) -> {
			if(radSDT.isSelected()){
				loadDataToTabel(thongTinChiDAO.getAllByPhone(txtTim.getText()), tbl_ThongTinChi);
			} else if (radTen.isSelected()){
				loadDataToTabel(thongTinChiDAO.getAllByName(txtTim.getText()), tbl_ThongTinChi);
			}
		});


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
