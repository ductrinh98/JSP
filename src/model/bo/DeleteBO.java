package model.bo;

import java.sql.SQLException;

import model.bean.SinhVien;
import model.dao.DeleteDAO;

public class DeleteBO {
		DeleteDAO deleteDAO = new DeleteDAO();
	public void deleteStudent(String maSV) throws ClassNotFoundException, SQLException {
		deleteDAO.deleteStudent(maSV);
	}
	public SinhVien findStudentById(String maSV) throws ClassNotFoundException, SQLException {
		
		return deleteDAO.findStudentById(maSV);
	}
}
