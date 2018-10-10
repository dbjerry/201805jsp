<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mulResult.jsp</title>
</head>
<body>
	mulResult.jsp
	
	<h2>parameter</h2>
	
	param1 : <%=session.getAttribute("param1") %> <br>
	param2 : <%=session.getAttribute("param2") %> <br>
	mul : <%=session.getAttribute("mul") %> <br>
</body>
</html>