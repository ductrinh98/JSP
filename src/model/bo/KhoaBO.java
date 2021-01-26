package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Khoa;

import model.dao.KhoaDAO;
public class KhoaBO {
	KhoaDAO khoaDAO = new KhoaDAO();
public ArrayList<Khoa> getKhoa() throws ClassNotFoundException, SQLException{
	return khoaDAO.allKhoa();
}
}
