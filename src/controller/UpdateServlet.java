package controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.KhoaBO;
import model.bo.UpdateBO;
import model.bean.Khoa;
import model.bean.SinhVien;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet{
	UpdateBO updateBO = new UpdateBO();
	KhoaBO khoaBO = new KhoaBO();
	SinhVien sinhVien = null;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String destination = null;
			String maSV = request.getParameter("maSV");
			SinhVien sinhVien = UpdateBO.timKiemSinhVien(maSV);
			ArrayList<Khoa> khoaArray = null;
			destination = "/Update.jsp";
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
			SinhVien sinhVien = new SinhVien();
			sinhVien.setMaSV(Integer.parseInt(request.getParameter("maSV")));
			sinhVien.setHoTen(request.getParameter("hoTen"));
			sinhVien.setGioiTinhs(request.getParameter("gioiTinh"));
			sinhVien.setKhoa(request.getParameter("maKhoa"));
			UpdateBO.updateSinhVien(sinhVien);
			response.sendRedirect("ViewServlet");
		} catch (Exception e) {}
	}
}
