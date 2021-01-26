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
<script language="javaScript">	
function Back() {
    window.history.back()
}
	</script>
</head>
<body>
<%ArrayList<Khoa> khoaArray = (ArrayList<Khoa>)request.getAttribute("khoaArray");%>
<form method="post" action="InsertServlet">
	<table align="center">

		<tr>
			<th colspan="3">Them moi sinh vien</th>
		</tr>
		
		<tr>
			<th>MaSV</th>
			<td><input type="text" name="maSV"></td>
		</tr>
		<tr>
			<th>Hoten</th>
			<td><input type="text" name="hoTen"></td>
		</tr>
		<tr>
			<th>GioiTinh</th>
			<td align="center">Nam <input type="radio" name="gioiTinh" value="Nam" ></td>
			<td align="center">Nu <input type="radio" name="gioiTinh" value="Nu" ></td>
		</tr>
		<tr>
		<td>	<select name="maKhoa">
				<% for (int i = 0; i < khoaArray.size(); i++) { %>
					   		<option value=<%=khoaArray.get(i).getMaKhoa() %>><%=khoaArray.get(i).getTenKhoa() %></option>
				<%} %>
			</select>
			</td>
		<tr>
		<td></td>
		<td align="center"><input type="submit" name="insert" value="them moi"></td>
		<td><input type="button" name="back" value="quay lai" onClick= Back()></td>
			
		</tr>
	</table>
</form>
</body>
</html>