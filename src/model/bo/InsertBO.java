package model.bo;

import java.sql.SQLException;

import model.bean.SinhVien;
import model.dao.InsertDAO;

public class InsertBO {
	InsertDAO insertDAO = new InsertDAO();
	public boolean isIdExisting(String maSV) throws ClassNotFoundException, SQLException {
		return insertDAO.checkExistingMaSV(maSV);
	}
	public void InsertSinhVien(SinhVien sinhVien) throws ClassNotFoundException, SQLException {
		 insertDAO.insertSinhVien(sinhVien);
	}
}
