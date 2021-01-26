package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bo.KhoaBO;
import model.bean.Khoa;
import model.bean.SinhVien;
import model.bo.ViewBO;
	@WebServlet("/ViewServlet")
	public class ViewServlet extends HttpServlet
	{
		private static final long serialVersionUID = 1L;
		KhoaBO khoaBO = new KhoaBO();
		ViewBO viewBO = new ViewBO();		
		protected void doGet(HttpServletRequest request, 
							HttpServletResponse response) throws ServletException, IOException
		{
			processRequest(request, response);
		}
		
	protected void doPost(HttpServletRequest request,
							HttpServletResponse response) throws ServletException, IOException{		
		processRequest(request, response);	
		}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Khoa> khoaArray = null;
			ArrayList<SinhVien> sinhVienArray = null;
			String maKhoa = request.getParameter("maKhoa");
			if (maKhoa==null||maKhoa.equalsIgnoreCase("tatCa")) {
				sinhVienArray= viewBO.allStudent();
			} else {
				sinhVienArray = viewBO.studentKhoa(maKhoa);
			}
			khoaArray = khoaBO.getKhoa();
			request.setAttribute("khoaArray", khoaArray);
			request.setAttribute("SinhVienArray", sinhVienArray);
			String destination = null;
				destination ="/XemThongTin.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	}
