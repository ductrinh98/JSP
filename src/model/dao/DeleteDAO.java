package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import model.bean.SinhVien;

public class DeleteDAO {
	
	public void deleteStudent(String maSV) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/lap_trinh_mang";
		Connection conn = DriverManager.getConnection(url,"root","");
		Statement stmt = (Statement) conn.createStatement();
		String sql = "delete from sinhvien where maSV='" + maSV + "'";
		stmt.executeUpdate(sql);
	}

	public SinhVien findStudentById(String maSV) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/lap_trinh_mang";
		Connection conn = DriverManager.getConnection(url,"root","");
		Statement stmt= (Statement) conn.createStatement();  
		String sql = "select * from sinhvien where maSV='" + maSV + "'";
		SinhVien sinhVien = null;
		ResultSet rs= stmt.executeQuery(sql);
		if (rs.next()) {
			sinhVien = new SinhVien();
			sinhVien.setMaSV(rs.getInt("maSV"));
			sinhVien.setHoTen(rs.getString("hoTen"));
			sinhVien.setGioiTinhb(rs.getBoolean("gioiTinh"));
			sinhVien.setKhoa(rs.getString("maKhoa"));
		}
		return sinhVien;
	}
	
}
