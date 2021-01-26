package controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Khoa;
import model.bean.SinhVien;
import model.bo.InsertBO;
import model.bo.KhoaBO;
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	KhoaBO khoaBO = new KhoaBO();
	InsertBO insertBO = new InsertBO();
	ArrayList<Khoa> khoaArray = new ArrayList<Khoa>();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			ArrayList<Khoa> khoaArray = null;
			khoaArray = khoaBO.getKhoa();
			request.setAttribute("khoaArray", khoaArray);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Insert.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Khoa> khoaArray = null;
			khoaArray = khoaBO.getKhoa();
			request.setAttribute("khoaArray", khoaArray);
			String destination = null;
			String maSV = request.getParameter("maSV");
			
			if (insertBO.isIdExisting(maSV)){
				destination = "/Insert.jsp";
				request.setAttribute("idExisting", true);
				RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
				dispatcher.forward(request, response);
			} else {
				SinhVien sinhVien = new SinhVien();
				sinhVien.setMaSV(Integer.parseInt(maSV));
				sinhVien.setHoTen(request.getParameter("hoTen"));
				System.out.println(request.getParameter("gioiTinh"));
				sinhVien.setGioiTinhs(request.getParameter("gioiTinh"));
				System.out.println(sinhVien.isGioiTinh());
				sinhVien.setKhoa(request.getParameter("maKhoa"));
				insertBO.InsertSinhVien(sinhVien);
				response.sendRedirect("ViewServlet");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
