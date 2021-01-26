package model.bo;

import model.dao.CheckLoginDAO;

public class CheckLoginBO {
	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	public boolean isValidUser(String userName, String passWord)
	{
		return checkLoginDAO.isExistUser(userName,passWord);
	}
}
