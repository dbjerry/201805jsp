<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sumResult.jsp</title>
</head>
<body>
	sumResult.jsp
	
	<h2>parameter</h2>
	
	start : <%=session.getAttribute("start") %> <br>
	end : <%=session.getAttribute("end") %> <br>
	sum : <%=session.getAttribute("sum") %> <br>
</body>
</html>