<%@ page language="java" contentType="text/html; charset = UTF-8" pageEncoding = "UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<title>LOGIN SCREEN</title>
	<meta charset="utf-8" http-equiv="content-Type" content="text/html">
</head>

<body>
	
	<form action="CheckLoginServlet" method="post">	
	<table>
	<tr>
	<th>UserName: <input type="text" name="userName"></th>
	<th>PassWord: <input type="passWord" name="passWord"></th>
	</tr>
	<tr>
	<th align ="right"><input type="submit" name="submit" value="Dang Nhap"></th>
	<td align ="left"><input type="reset" name="Cancel" value="Huy"></td>	
	</tr>
	</table>			
	</form>
</body>
</html>