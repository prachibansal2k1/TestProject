<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>WELCOME</h2>
<form action="up" method="post">
Username:<input type="text" name="username" value="<%=request.getAttribute("user") %>"><br><br>
Email:<input type="text" name="email" value="<%=request.getAttribute("email") %>"><br><br>
Address:<input type="text" name="address" value="<%=request.getAttribute("add") %>"><br><br>
Password:<input type="text" name="password" value="<%=request.getAttribute("pass") %>"><br><br>
<input type="submit" value="update">
</form>
</body>
</html>
</body>
</html>