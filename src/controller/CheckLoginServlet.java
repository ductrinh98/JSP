package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.CheckLoginBO;

@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	
protected void doPost(HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException{
	String destination = null;
	HttpSession session = request.getSession();
	String userName = request.getParameter("userName");
	String passWord = request.getParameter("passWord");
	CheckLoginBO checkLoginBO = new CheckLoginBO();

	if(checkLoginBO.isValidUser(userName,passWord))
	{
		session.setAttribute("userName", userName);
		destination ="/Welcome.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	} else {
		destination ="/Login.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
	}
}
