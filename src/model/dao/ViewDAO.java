package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.SinhVien;

public class ViewDAO {
	private Statement getStatement() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/lap_trinh_mang";
		Connection conn = DriverManager.getConnection(url,"root","");
		return conn.createStatement();
	}

	public ArrayList<SinhVien> StudentKhoa(String maKhoa) {
		try {
			System.out.println(maKhoa);
			Statement stmt = getStatement();
			String sql = "select * from sinhvien, khoa where sinhvien.maKhoa= khoa.maKhoa and khoa.maKhoa='" + maKhoa + "'";
			ResultSet rs= stmt.executeQuery(sql);
			ArrayList<SinhVien> arraySinhVien = null;
				arraySinhVien =	new ArrayList<SinhVien>();
			SinhVien sinhVien = null;
			while(rs.next()) {			
				sinhVien = new SinhVien();
				sinhVien.setMaSV(rs.getInt("maSV"));
				sinhVien.setHoTen(rs.getString("hoTen"));
				sinhVien.setGioiTinhb(rs.getBoolean("gioiTinh"));
				sinhVien.setKhoa(rs.getString("tenKhoa"));
				arraySinhVien.add(sinhVien);
				System.out.println(arraySinhVien.size());	
			} 
			return arraySinhVien;
			} catch (Exception e) {
			System.out.println("SQLException caught: " + e.getMessage());
			}
		return null;
	}
	public ArrayList<SinhVien> allStudent() {
		try {
			ArrayList<SinhVien> arraySinhvien = new ArrayList<SinhVien>();
			Statement stmt = getStatement();
			String sql = "select * from sinhvien, khoa where sinhvien.maKhoa = khoa.maKhoa";
			ResultSet rs= stmt.executeQuery(sql);
			SinhVien sinhVien = null;
			while(rs.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMaSV(rs.getInt("maSV"));
				sinhVien.setHoTen(rs.getString("hoTen"));
				sinhVien.setGioiTinhb(rs.getBoolean("gioiTinh"));
				sinhVien.setKhoa(rs.getString("tenKhoa"));
				arraySinhvien.add(sinhVien);
			} 
			return arraySinhvien;
			} catch (Exception e) {
			System.out.println("SQLException caught: " + e.getMessage());
			}
		return null;
	}
}
