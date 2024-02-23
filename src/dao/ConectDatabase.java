package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectDatabase {
	public static Connection con = null;
	private static ConectDatabase instance = new ConectDatabase();
	
	public static ConectDatabase getInstance() {
		return instance;
	}
	
	public void connect() {


		String url = "jdbc:sqlserver://NGUYENTIENTHANH\\SQLEXPRESS:1433;DatabaseName=QLTC;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String password = "thanh123";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Da ket noi");
			
		} catch(SQLException e) {
			System.out.println("Khong ket noi dc");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void disconnect() {
		if(con != null) {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() {
		return con;
	}
}
