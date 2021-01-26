package model.bo;

import java.sql.SQLException;

import model.bean.SinhVien;
import model.dao.UpdateDAO;

public class UpdateBO {
	static UpdateDAO updateDAO = new UpdateDAO();
	public static void updateSinhVien(SinhVien sinhVien) throws ClassNotFoundException, SQLException {
		updateDAO.UpdateSinhVien(sinhVien);
	}

	public static SinhVien timKiemSinhVien(String maSV) throws ClassNotFoundException, SQLException {
	
		return updateDAO.findStudentById(maSV);
	}

}
