package controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.KhoaBO;
import model.bo.DeleteBO;
import model.bean.Khoa;
import model.bean.SinhVien;
import model.bo.DeleteBO;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{
	DeleteBO deleteBO = new DeleteBO();
	KhoaBO khoaBO = new KhoaBO();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String destination = null;
			String maSV = request.getParameter("maSV");
			SinhVien sinhVien = deleteBO.findStudentById(maSV);
			ArrayList<Khoa> khoaArray = null;
			destination = "/Delete.jsp";
			khoaArray = khoaBO.getKhoa();
			request.setAttribute("khoaArray", khoaArray);
			request.setAttribute("sinhVien", sinhVien);
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);
		} catch (Exception e) {}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String maSV = request.getParameter("maSV");
			deleteBO.deleteStudent(maSV);
			response.sendRedirect("ViewServlet");
		} catch (Exception e) {
		}
	}
}
