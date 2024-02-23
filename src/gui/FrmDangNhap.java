package gui;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import gui.FrmManHinhChinh;
import dao.ConectDatabase;
import model.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrmDangNhap extends JFrame  implements ActionListener,KeyListener{

	private JPanel contentPane;
	private JTextField txtUser;
	private JLabel lblUser;
	private JTextField txtPass;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JButton btnReset;
	private JLabel lblMessLoiUser;
	private JLabel lblTitle;
	public static TaiKhoan taiKhoan ;
	public static boolean TrangThaiDangNhap = false;
	private String TenTaiKhoan = "admin";
	private String MatKhau = "admin";
	/**
	 * Create the frame.
	 */
	public FrmDangNhap() {

		
		
		
		setBackground(new Color(153, 153, 255));
		setTitle("Đăng nhập");
		setBounds(100, 100, 578, 339);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 226, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtUser = new JTextField();
		txtUser.setForeground(new Color(51, 0, 51));
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtUser.setBackground(new Color(255, 255, 255));
		txtUser.setBounds(189, 83, 204, 25);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		lblUser = new JLabel("UserName:");
		lblUser.setBackground(Color.LIGHT_GRAY);
		lblUser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUser.setBounds(101, 84, 88, 25);
		contentPane.add(lblUser);

		txtPass = new JPasswordField();
		txtPass.setBackground(new Color(255, 255, 255));
		txtPass.setBounds(189, 144, 204, 25);
		txtPass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(txtPass);
		txtPass.setColumns(10);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPassword.setBounds(108, 145, 81, 25);
		contentPane.add(lblPassword);

		btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(0, 255, 0));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogin.setBounds(137, 193, 107, 32);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);
		

		btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setBackground(new Color(255, 128, 64));
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReset.setBounds(275, 193, 107, 32);
		contentPane.add(btnReset);
		btnReset.addActionListener(this);

		lblMessLoiUser = new JLabel("");
		lblMessLoiUser.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMessLoiUser.setForeground(Color.RED);
		lblMessLoiUser.setBounds(240, 112, 298, 21);
		contentPane.add(lblMessLoiUser);
		
		lblTitle = new JLabel("PHẦN MỀM QUẢN LÝ THU CHI");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setOpaque(true);
		lblTitle.setBackground(new Color(0, 0, 128));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitle.setBounds(0, 0, 564, 46);
		contentPane.add(lblTitle);
		
		JLabel lbloTo = new JLabel("TRUNG TÂM ĐÀO TẠO CHẤT LƯỢNG CAO ");
		lbloTo.setHorizontalAlignment(SwingConstants.CENTER);
		lbloTo.setOpaque(true);
		lbloTo.setForeground(Color.WHITE);
		lbloTo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbloTo.setBackground(new Color(0, 0, 128));
		lbloTo.setBounds(0, 256, 564, 46);
		contentPane.add(lbloTo);
		
		
		txtUser.requestFocus();
		this.addKeyListener(this);
		
	}
	
	public boolean KiemTraDuLieu() {
		String tenUser = txtUser.getText();
		// ten dang nhap phai la chu hoac so va khong co ki tu dac biet co toi da tu 5-20 ki tu
		boolean match = tenUser.matches("[a-zA-z0-9 ]{3,20}");
		if(match!=true) {
			lblMessLoiUser.setText("Lỗi: Tên đăng Nhập(Không Chứa Ký Tự Đặc Biệt,Tối Thiểu 3-20 Ký Tự)");
			return false;
		}
		else
			return true;
	}
	public void loadTaiKhoan(String tenDangNhap,String matKhau) {
		try {
			ConectDatabase.getInstance();
			Connection con = ConectDatabase.getConnection();
			PreparedStatement stmt = null;
			String sql  = "select t.TenTaiKhoan,t.MatKhau\r\n" + 
					"from TaiKhoan t \r\n" + 
					"where t.TenTaiKhoan=? and t.MatKhau=?";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1,tenDangNhap);
			stmt.setString(2, matKhau);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ten = rs.getString(1);
				String mk = rs.getString(2);
				taiKhoan  = new TaiKhoan(ten, mk);
			}
		} catch (Exception e) {
			// TODO: handle exception 
		}
	}
	public boolean kiemTraDangNhap(String tenDangNhap,String matKhau) {
		if(tenDangNhap.equalsIgnoreCase(TenTaiKhoan) && matKhau.equalsIgnoreCase(MatKhau)) {
			TrangThaiDangNhap = true ;
			return true;
		}
		return false;
	}
	public void logIn() {
		try {
			if(KiemTraDuLieu()) {
				String tenDN = txtUser.getText();
				String matKhau = txtPass.getText();
				loadTaiKhoan(tenDN, matKhau);
				if(kiemTraDangNhap(tenDN, matKhau) && TrangThaiDangNhap==true) {
					JOptionPane.showMessageDialog(this,"Đăng nhập thành công.");
					FrmManHinhChinh frmManHinhChinh = new FrmManHinhChinh();
					frmManHinhChinh.setVisible(true);
					//FrmQuanLyThu frmQuanLyThu = new FrmQuanLyThu();
					//frmQuanLyThu.setVisible(true);
					this.setVisible(false);
				}
				
				else 
					JOptionPane.showMessageDialog(this,"Tên Đăng Nhập, Hoặc Mật Khẩu Sai.");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null,e2);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Login")) {
			logIn();
		} 
		if(e.getActionCommand().equals("Reset")) {
			txtUser.setText("");
			txtPass.setText("");
			lblMessLoiUser.setText("");
			txtUser.requestFocus();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			logIn();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			logIn();
		}
	}

}