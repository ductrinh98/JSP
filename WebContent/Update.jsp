<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.bean.Khoa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.SinhVien"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function Back() {
    window.history.back()
}
</script>
</head>
<body>

<%SinhVien sinhVien = (SinhVien)request.getAttribute("sinhVien");
ArrayList<Khoa> khoaArray = (ArrayList<Khoa>)request.getAttribute("khoaArray");%>
	<h1>Sua thong tinh Sinh Vien</h1>
		<p>Sua sinh Vien: <%= sinhVien.getHoTen() %></p>
		<form method="post" action="UpdateServlet">
			<table>
				<tr>
					<td>Ma SV</td>
					<td>
						<input type="text" name="maSV" readonly value="<%= sinhVien.getMaSV()%>">
					</td>
				</tr>
				<tr>
					<td>HoTen</td>
					<td>
						<input type="text" name="hoTen" value="<%= sinhVien.getHoTen()%>">
					</td>
				</tr>
				<tr>
					<td>GioiTinh</td>
					<td>
						<input type="radio" name="gioiTinh" value="Nam" 
						<% if (sinhVien.getGioiTinh(sinhVien.isGioiTinh()).equalsIgnoreCase("Nam")) out.print("checked");%> >Nam
						<input type="radio" name="gioiTinh" value="Nu"
						 <% if (sinhVien.getGioiTinh(sinhVien.isGioiTinh()).equalsIgnoreCase("Nu")) out.print("checked");%> >Nu
					</td>
				</tr>
				<tr>
					<td>Khoa</td>
					<td>
						<select name="maKhoa">
					   	<% for (int i = 0; i < khoaArray.size(); i++) {
					   		if (khoaArray.get(i).getMaKhoa().equals(sinhVien.getKhoa())) { %>
					   		<option selected="selected" value=<%=khoaArray.get(i).getMaKhoa() %>><%=khoaArray.get(i).getTenKhoa() %></option>
					   		<%} else {%>
					   		<option value=<%=khoaArray.get(i).getMaKhoa() %>><%=khoaArray.get(i).getTenKhoa() %></option>
					   		<%}} %>
					   	</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Luu Lai" />
						<input type="button" value="Quay Lai" onclick="Back()"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</body>
</html>