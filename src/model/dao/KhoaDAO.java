package model.dao;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Khoa;
public class KhoaDAO {
	public ArrayList<Khoa> allKhoa() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/lap_trinh_mang";
		Connection conn = DriverManager.getConnection(url,"root","");	
		Statement stmt = conn.createStatement();
		String sql = "select * from khoa";
		ArrayList<Khoa> khoaArray = new ArrayList<Khoa>();
		Khoa khoa = null;
		ResultSet rs= stmt.executeQuery(sql);
		while (rs.next()) {
			khoa = new Khoa();
			khoa.setMaKhoa(rs.getString("maKhoa"));
			khoa.setTenKhoa(rs.getString("tenKhoa"));
			khoaArray.add(khoa);
		}
		return khoaArray;
	}
}
