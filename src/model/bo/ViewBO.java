package model.bo;
import model.bean.SinhVien;
import model.dao.ViewDAO;

import java.util.ArrayList;
public class ViewBO {
	ViewDAO viewDAO = new ViewDAO();
	public ArrayList<SinhVien> studentKhoa(String maKhoa)
	{
		return viewDAO.StudentKhoa(maKhoa);
	}
	public ArrayList<SinhVien> allStudent() {
		
		return viewDAO.allStudent();
	}
}
