package gui;


import java.awt.Color;

import java.awt.Font;
import java.awt.event.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.ConectDatabase;
//import dao.KhachHangDAO;
import dao.ThongTinCaNhanDAO;
//import model.KhachHang;
import dao.ThongTinThuDAO;
import model.HocVien;
import model.IObject;
import model.ThongTinThu;
import util.Util;

import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import java.awt.SystemColor;


public class FrmQuanLyThu extends JFrame implements ActionListener {

	private ThongTinThuDAO thongTinThuDAO = new ThongTinThuDAO();

    private JTextField txtTenHocVien;
    private JTextField txtDiaChi;
    private JTextField txtSoTien;
    public static JPanel pnlTabXemQuanLyThu;
    public static JPanel pnlChucNang;
    private JComboBox cboGioiTinh;
    private JTextField txtSoDienThoai;
    private DefaultTableModel model;
    public static JTable tbQLT;
    private JTextField txtGiangVienThu;
    private JDateChooser dateNgaySinh;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnTimKiem;
    private JButton btnTaoMoi;
    private JButton btnThoat;
    ThongTinCaNhanDAO ttDao = new ThongTinCaNhanDAO();

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

    public FrmQuanLyThu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1337, 737);
        setLocationRelativeTo(null);
        //setVisible(true);
        pnlTabXemQuanLyThu = new JPanel();
        getContentPane().add(pnlTabXemQuanLyThu);


        pnlTabXemQuanLyThu.setLayout(null);

        JPanel pnlChucNang = new JPanel();
        pnlChucNang.setLayout(null);
        pnlChucNang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "C\u00E1c ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        pnlChucNang.setBackground(SystemColor.controlHighlight);
        pnlChucNang.setBounds(10, 559, 1232, 61);
        pnlTabXemQuanLyThu.add(pnlChucNang);

        btnThem = new JButton("Thêm");
        btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnThem.setBounds(128, 16, 160, 35);
        pnlChucNang.add(btnThem);

        btnSua = new JButton("Sửa");
        btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnSua.setBounds(298, 15, 160, 35);
        pnlChucNang.add(btnSua);

        btnXoa = new JButton("Xóa");
        btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnXoa.setBounds(468, 15, 160, 35);
        pnlChucNang.add(btnXoa);

        btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnTimKiem.setBounds(644, 15, 160, 35);
        pnlChucNang.add(btnTimKiem);

        btnTaoMoi = new JButton("Tạo mới");
        btnTaoMoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnTaoMoi.setBounds(817, 15, 160, 35);
        pnlChucNang.add(btnTaoMoi);

        btnThoat = new JButton("Thoát");
        btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnThoat.setBounds(987, 16, 160, 35);
        pnlChucNang.add(btnThoat);


        JPanel pnlThongTinHocVien = new JPanel();
        pnlThongTinHocVien.setLayout(null);
        pnlThongTinHocVien.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin h\u1ECDc vi\u00EAn", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
        pnlThongTinHocVien.setBackground(SystemColor.controlHighlight);
        pnlThongTinHocVien.setBounds(10, 65, 1232, 218);
        pnlTabXemQuanLyThu.add(pnlThongTinHocVien);

        JPanel pnlThongTinCoBan = new JPanel();
        pnlThongTinCoBan.setLayout(null);
        pnlThongTinCoBan.setForeground(Color.BLACK);
        pnlThongTinCoBan.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
                "Thông tin cơ bản", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlThongTinCoBan.setBackground(SystemColor.controlHighlight);
        pnlThongTinCoBan.setBounds(10, 22, 1217, 185);
        pnlThongTinHocVien.add(pnlThongTinCoBan);

        JLabel lblGiangVienThu = new JLabel("Giảng viên thu:");
        lblGiangVienThu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblGiangVienThu.setBounds(62, 25, 143, 20);
        pnlThongTinCoBan.add(lblGiangVienThu);

        JLabel lblTenHocVien = new JLabel("Tên học viên:");
        lblTenHocVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblTenHocVien.setBounds(62, 56, 131, 23);
        pnlThongTinCoBan.add(lblTenHocVien);

        txtTenHocVien = new JTextField();
        txtTenHocVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txtTenHocVien.setToolTipText("Nhập họ");
        txtTenHocVien.setColumns(10);
        txtTenHocVien.setBounds(251, 56, 283, 20);
        pnlThongTinCoBan.add(txtTenHocVien);

        JLabel lblDiaChi = new JLabel("Địa chỉ :");
        lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblDiaChi.setBounds(685, 57, 149, 20);
        pnlThongTinCoBan.add(lblDiaChi);

        txtDiaChi = new JTextField();
        txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txtDiaChi.setToolTipText("Nhập tên");
        txtDiaChi.setColumns(10);
        txtDiaChi.setBounds(811, 57, 400, 20);
        pnlThongTinCoBan.add(txtDiaChi);

        JLabel lblGioiTinh = new JLabel("Giới tính:");
        lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblGioiTinh.setBounds(62, 90, 150, 17);
        pnlThongTinCoBan.add(lblGioiTinh);

        cboGioiTinh = new JComboBox();
        cboGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        cboGioiTinh.setModel(new DefaultComboBoxModel(new String[]{"Nam", "Nu", "Khác"}));
        cboGioiTinh.setToolTipText("Chọn giới tính");
        cboGioiTinh.setBounds(251, 87, 82, 23);
        pnlThongTinCoBan.add(cboGioiTinh);

        JLabel lblSoTien = new JLabel("Số tiền:");
        lblSoTien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblSoTien.setBounds(685, 87, 149, 23);
        pnlThongTinCoBan.add(lblSoTien);

        txtSoTien = new JTextField();
        txtSoTien.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSoTien.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
                    e.consume();
                }
            }
        });
        txtSoTien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txtSoTien.setToolTipText("Nhập chứng minh nhân dân");
        txtSoTien.setColumns(10);
        txtSoTien.setBounds(811, 88, 222, 20);
        pnlThongTinCoBan.add(txtSoTien);

        JLabel lblNgaySinh = new JLabel("Ngày Sinh :");
        lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNgaySinh.setBounds(62, 123, 143, 19);
        pnlThongTinCoBan.add(lblNgaySinh);

        dateNgaySinh = new JDateChooser();
        dateNgaySinh.setBounds(251, 121, 267, 25);
        pnlThongTinCoBan.add(dateNgaySinh);
        dateNgaySinh.setLocale(Locale.forLanguageTag("vi-VN"));
        dateNgaySinh.setDateFormatString("dd/MM/yyyy");

        JPanel pnlTitle = new JPanel();
        pnlTitle.setBackground(SystemColor.controlHighlight);
        pnlTitle.setBounds(10, 11, 1232, 43);
        pnlTabXemQuanLyThu.add(pnlTitle);
        pnlTitle.setLayout(null);

        JLabel lblTitle = new JLabel("THÔNG TIN THU PHÍ");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblTitle.setForeground(Color.RED);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(115, 11, 985, 35);
        pnlTitle.add(lblTitle);

        txtSoDienThoai = new JTextField();
        txtSoDienThoai.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
                    e.consume();
                }
            }
        });
        txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txtSoDienThoai.setToolTipText("Nhập chứng minh nhân dân");
        txtSoDienThoai.setText((String) null);
        txtSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSoDienThoai.setColumns(10);
        txtSoDienThoai.setBounds(811, 121, 172, 20);
        pnlThongTinCoBan.add(txtSoDienThoai);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        JLabel lblSDT = new JLabel("Số điện thoại :");
        lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblSDT.setBounds(685, 121, 149, 23);
        pnlThongTinCoBan.add(lblSDT);

        JLabel lblNgyThu = new JLabel("Ngày thu:");
        lblNgyThu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNgyThu.setBounds(685, 30, 143, 19);
        pnlThongTinCoBan.add(lblNgyThu);

        JLabel lblMonHoc = new JLabel("Môn học:");
        lblMonHoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblMonHoc.setBounds(62, 153, 131, 23);
        pnlThongTinCoBan.add(lblMonHoc);

        txtGiangVienThu = new JTextField();
        txtGiangVienThu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txtGiangVienThu.setBounds(251, 27, 283, 20);
        pnlThongTinCoBan.add(txtGiangVienThu);
        txtGiangVienThu.setColumns(10);

        JDateChooser dateNgayThu = new JDateChooser();
        dateNgayThu.setLocale(new Locale("vi", "VN"));
        dateNgayThu.setDateFormatString("dd/MM/yyyy");
        dateNgayThu.setBounds(811, 25, 267, 25);
        pnlThongTinCoBan.add(dateNgayThu);

        JComboBox cboMonHoc = new JComboBox();
        cboMonHoc.setModel(new DefaultComboBoxModel(new String[]{"Toan", "Ly", "Hoa", "Anh", "Van"}));
        cboMonHoc.setToolTipText("Chọn giới tính");
        cboMonHoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        cboMonHoc.setBounds(251, 155, 82, 23);
        pnlThongTinCoBan.add(cboMonHoc);

        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblTrangThai.setBounds(685, 155, 96, 17);
        pnlThongTinCoBan.add(lblTrangThai);

        JComboBox cboTrangThai = new JComboBox();
        cboTrangThai.setModel(new DefaultComboBoxModel(new String[]{"Da nop", "Chua nop"}));
        cboTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        cboTrangThai.setBounds(811, 152, 82, 23);
        pnlThongTinCoBan.add(cboTrangThai);


        JPanel pnlDanhSachThu = new JPanel();
        pnlDanhSachThu.setForeground(new Color(0, 0, 0));
        pnlDanhSachThu.setBackground(SystemColor.controlHighlight);
        pnlDanhSachThu.setLayout(null);
        pnlDanhSachThu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch thu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        pnlDanhSachThu.setBounds(10, 294, 1232, 254);
        pnlTabXemQuanLyThu.add(pnlDanhSachThu);


        JScrollPane tbThongTinThu = new JScrollPane();
        tbThongTinThu.setBounds(10, 21, 1215, 222);
        pnlDanhSachThu.add(tbThongTinThu);

        String[] tb = new String[]{"TT", "Giảng viên thu", "Tên học viên", "Giới Tính", "Ngày Sinh", "Môn học", "Ngày thu", "Địa Chỉ", "Số tiền", "Số điện thoại", "Trạng thái"};
        model = new DefaultTableModel(tb, 0);
        tbQLT = new JTable(model);
        tbQLT.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        tbQLT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tbThongTinThu.setViewportView(tbQLT);

        loadDataToTabel(thongTinThuDAO.getAll(), tbQLT);

        btnThem.addActionListener((e) -> {
			ThongTinThu thongTinThu = new ThongTinThu();
			thongTinThu.setGiangVienThu(txtGiangVienThu.getText());
			thongTinThu.setTenHocVien(txtTenHocVien.getText());
			thongTinThu.setGioiTinh(cboGioiTinh.getSelectedItem().toString());
			thongTinThu.setNgaySinh(dateNgaySinh.getDate());
			thongTinThu.setMonHoc(cboMonHoc.getSelectedItem().toString());
			thongTinThu.setNgayThu(dateNgayThu.getDate());
			thongTinThu.setDiaChi(txtDiaChi.getText());
			thongTinThu.setSoTien(Long.valueOf(txtSoTien.getText()));
			thongTinThu.setSoDienThoai(txtSoDienThoai.getText());
			thongTinThu.setTrangThai(cboTrangThai.getSelectedItem().toString());
			thongTinThuDAO.save(thongTinThu);
            loadDataToTabel(thongTinThuDAO.getAll(), tbQLT);
		});

        btnSua.addActionListener((e) -> {
            ThongTinThu thongTinThu = new ThongTinThu();
            thongTinThu.setId(Long.valueOf(tbQLT.getValueAt(rowChoose, 0).toString()));
            thongTinThu.setGiangVienThu(txtGiangVienThu.getText());
            thongTinThu.setTenHocVien(txtTenHocVien.getText());
            thongTinThu.setGioiTinh(cboGioiTinh.getSelectedItem().toString());
            thongTinThu.setNgaySinh(dateNgaySinh.getDate());
            thongTinThu.setMonHoc(cboMonHoc.getSelectedItem().toString());
            thongTinThu.setNgayThu(dateNgayThu.getDate());
            thongTinThu.setDiaChi(txtDiaChi.getText());
            thongTinThu.setSoTien(Long.valueOf(txtSoTien.getText()));
            thongTinThu.setSoDienThoai(txtSoDienThoai.getText());
            thongTinThu.setTrangThai(cboTrangThai.getSelectedItem().toString());
            thongTinThuDAO.save(thongTinThu);
            loadDataToTabel(thongTinThuDAO.getAll(), tbQLT);
        });

        btnTaoMoi.addActionListener((e) -> {
            txtGiangVienThu.setText("");
            txtTenHocVien.setText("");
            txtDiaChi.setText("");
            txtSoTien.setText("");
            txtSoDienThoai.setText("");
            dateNgayThu.setCalendar(null);
            dateNgaySinh.setCalendar(null);
        });

        btnThoat.addActionListener((e) -> {
            System.exit(0);
        });

        tbQLT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowChoose = tbQLT.getSelectedRow();

                 txtGiangVienThu.setText(tbQLT.getValueAt(rowChoose, 1).toString());
                txtTenHocVien.setText(tbQLT.getValueAt(rowChoose, 2).toString());
                cboGioiTinh.setSelectedIndex(tbQLT.getValueAt(rowChoose, 3).toString().length() == 2? 1 : 0);
                dateNgaySinh.setDate(Util.toDate(tbQLT.getValueAt(rowChoose, 4).toString()));
                dateNgayThu.setDate(Util.toDate(tbQLT.getValueAt(rowChoose, 6).toString()));
                txtDiaChi.setText(tbQLT.getValueAt(rowChoose, 7).toString());
                txtSoTien.setText(tbQLT.getValueAt(rowChoose, 8).toString());
                txtSoDienThoai.setText(tbQLT.getValueAt(rowChoose, 9).toString());
                cboTrangThai.setSelectedIndex(tbQLT.getValueAt(rowChoose, 10).toString().startsWith("C")? 1 : 0);
            }
        });

        btnXoa.addActionListener((e) -> {
            thongTinThuDAO.delete(Long.valueOf(tbQLT.getValueAt(rowChoose, 0).toString()));
            loadDataToTabel(thongTinThuDAO.getAll(), tbQLT);
            txtGiangVienThu.setText("");
            txtTenHocVien.setText("");
            txtDiaChi.setText("");
            txtSoTien.setText("");
            txtSoDienThoai.setText("");
            dateNgayThu.setCalendar(null);
            dateNgaySinh.setCalendar(null);
        });

    }
//	public static void main(String[] args) {
//		FrmXemThongTinCaNhan frmQuanLyNhanVien = new FrmXemThongTinCaNhan();
//		frmQuanLyNhanVien.setVisible(true);
//	}


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}