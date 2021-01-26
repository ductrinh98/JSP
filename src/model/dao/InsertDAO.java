package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import model.bean.SinhVien;

public class InsertDAO {

	public boolean checkExistingMaSV(String maSV) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/lap_trinh_mang";
		Connection conn = DriverManager.getConnection(url,"root","");
		Statement stmt= (Statement) conn.createStatement();  
		String sql = "select * from sinhvien where maSV='" + maSV + "'";
		ResultSet rs= stmt.executeQuery(sql);
		if (rs.next()) return true;
		return false;
	}

	public void insertSinhVien(SinhVien sinhVien) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/lap_trinh_mang";
		Connection conn = DriverManager.getConnection(url,"root","");
		Statement stmt= (Statement) conn.createStatement();
		String sql = "insert into sinhvien(maSV, hoTen, gioiTinh, maKhoa) values('" 
				+ sinhVien.getMaSV() + "','" + sinhVien.getHoTen() + "','" 
				+ (sinhVien.isGioiTinh()?"1":"0") + "','" + sinhVien.getKhoa() + "')";
		stmt.executeUpdate(sql);
	}
}
