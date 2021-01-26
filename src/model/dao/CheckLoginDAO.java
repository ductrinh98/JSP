package model.dao;

import java.sql.*;

public class CheckLoginDAO {
	
	
	public boolean isExistUser(String userName,String passWord)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/lap_trinh_mang";
			Connection conn = DriverManager.getConnection(url,"root","");
			Statement stmt=conn.createStatement();  
			String sql = "select * from account where userName='" + userName +
					"' and passWord='" + passWord + "'";
			ResultSet rs= stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			} 
			} catch (Exception e) {
			System.out.println("SQLException caught: " + e.getMessage());
			}
		return false;
	}		
}
