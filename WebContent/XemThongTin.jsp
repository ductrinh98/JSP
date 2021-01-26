<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.Khoa"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style> 
a.Button {
  color: 242729;
  border-style: solid;
  border-width : 0.1px 0.1px 0.1px 0.1px;
  text-decoration : none;
  padding: 2px;
  border-color: #000000;
  background-color: #E4E6E8;
  
}
</style>
</head>
<body>
<% 
	ArrayList<Khoa> khoaArray = (ArrayList<Khoa>)request.getAttribute("khoaArray");
	ArrayList<SinhVien> sinhVienArray = (ArrayList<SinhVien>)request.getAttribute("SinhVienArray");
%>
<form name="formsearch" action="ViewServlet"  >
	<table align="center">
		<tr>
			<td>
				<select name="maKhoa">
 					<% for(int i = 0; i < khoaArray.size(); i++){ %>
   					<option value=<%=khoaArray.get(i).getMaKhoa() %>><%=khoaArray.get(i).getTenKhoa() %></option>
   					<% } %>
   					<option value="tatCa">Tat Ca</option>
				</select>	
							
			</td>
			<td><input type="submit" name="xem" value="xem"></td>
			<td ><a href="InsertServlet" class="Button">them moi</a></td>
		</tr>
	</table>
</form>
<table class="table">
        	<% if (sinhVienArray.size() > 0) {%>
        	<tr>
                <th class="row">MaSV</th>
                <th class="row">HoTen</th>
                <th class="row">GioiTinh</th>
                <th class="row">Khoa</th>
                <th class="row">Edit</th>
                <th class="row">Delete</th>
            </tr>
        	<% for (int i = 0; i < sinhVienArray.size(); i++) { %>
            <tr>
                <td class="row"><%= sinhVienArray.get(i).getMaSV()%></td>
                <td class="row"><%= sinhVienArray.get(i).getHoTen()%></td>
                <td class="row"><%= sinhVienArray.get(i).getGioiTinh(sinhVienArray.get(i).isGioiTinh())%></td>
                <td class="row"><%= sinhVienArray.get(i).getKhoa() %></td>
                <td class="row">
                	<a href="UpdateServlet?maSV=<%= sinhVienArray.get(i).getMaSV()%>">sua</a>
                </td>
                <td>
                	<a href="DeleteServlet?maSV=<%= sinhVienArray.get(i).getMaSV()%>">xoa</a>
                </td>
            </tr>
            <% }} %>
            
        </table>
</body>
</html>