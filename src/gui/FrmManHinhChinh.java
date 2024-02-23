package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import java.awt.Frame;

public class FrmManHinhChinh extends JFrame implements ActionListener,MenuListener {

	private JPanel contentPane;
	
	//private FrmBaoCaoThongKe frmBaoCaoThongKe = new FrmBaoCaoThongKe();
	private FrmQuanLyThu frmQuanLyThu = new FrmQuanLyThu();
	private FrmQuanLyChi frmQuanLyChi = new FrmQuanLyChi();
	public static JTabbedPane tabbedPane;
	private JMenuBar menuBar;
	private JMenuItem mntmDangXuat;
	private JMenu mnExit;
	
	public FrmManHinhChinh() {
		
		
		setTitle("QUẢN LÝ THU CHI TRUNG TÂM ĐÀO TẠO");
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1320, 747);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setExtendedState(Frame.MAXIMIZED_HORIZ);
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
	
		
		
		
		mnExit = new JMenu("Exit");
		mnExit.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnExit.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				Object chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?");
				if(chon.equals(0)) {
					System.exit(0);
				}
			}
		});
		
		menuBar.add(mnExit);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.WHITE);
		toolBar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		toolBar.setFloatable(false);
		toolBar.setEnabled(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		
		JMenuBar menuQuanLyThu = new JMenuBar();
		toolBar.add(menuQuanLyThu);
		
		JMenu mnQuanLyThu = new JMenu("QUẢN LÝ THU PHÍ        ");
		mnQuanLyThu.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(frmQuanLyThu.pnlTabXemQuanLyThu);
			}
		});
		
		mnQuanLyThu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuQuanLyThu.add(mnQuanLyThu);
		
		mnQuanLyThu.setMnemonic(KeyEvent.VK_F10);
		
		JMenuBar menuQuanLyChi = new JMenuBar();
		toolBar.add(menuQuanLyChi);
		
		JMenu mnQuanLyChi = new JMenu("QUẢN LÝ CHI         ");
		mnQuanLyChi.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(frmQuanLyChi.pnlTabXemQuanLyChi);
			}
		});
		
		mnQuanLyChi.setMnemonic(KeyEvent.VK_F10);
		mnQuanLyChi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuQuanLyChi.add(mnQuanLyChi);
		
		JMenuBar menuThongKe = new JMenuBar();
		toolBar.add(menuThongKe);
		
		JMenu mnThongKe = new JMenu("THỐNG KÊ                                                                                                                                                               ");
		mnThongKe.setMnemonic(KeyEvent.VK_F10);
		mnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuThongKe.add(mnThongKe);
		
		JMenuBar menuDangNhap = new JMenuBar();
		toolBar.add(menuDangNhap);
		
		JMenu mnDangNhap_DangXuat = new JMenu("");
		mnDangNhap_DangXuat.setIcon(new ImageIcon("C:\\Users\\PC\\Downloads\\icons8-logout-16.png"));
		mnDangNhap_DangXuat.setMnemonic(KeyEvent.VK_F11);
		mnDangNhap_DangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuDangNhap.add(mnDangNhap_DangXuat);
		
		mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mnDangNhap_DangXuat.add(mntmDangXuat);
		mntmDangXuat.addActionListener(this);
		
		tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.indexOfTabComponent(frmQuanLyThu);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
//		if(e.getActionCommand().equals(mnThongTinCaNhan)) {
//			
//			tabbedPane.remove(tabbedPane.getSelectedComponent());
//			frmQuanLyThu = new FrmQuanLyThu();
//			tabbedPane.add(frmQuanLyThu.pnlTabXemThongTinCaNhan);
//			
//		}
		
		 if(obj.equals(mntmDangXuat)) {
			this.setVisible(false);
			FrmDangNhap.TrangThaiDangNhap = false;
			FrmDangNhap frmDangNhap = new FrmDangNhap();
			frmDangNhap.setVisible(true);
			
			
		}
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
}
