<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
request.getLocalAddr() :	<strong><%=request.getLocalAddr() %></strong><br>
request.getRemoteAddr() :	<strong><%=request.getRemoteAddr() %></strong> <br>
request.getContentLength() :	<strong><%=request.getContentLength() %></strong><br>
request.getCharacterEncoding() :	<strong><%=request.getCharacterEncoding() %></strong><br>
request.getContentType():	<strong><%=request.getContentType() %></strong><br>
request.getProtocol():	<strong><%=request.getProtocol() %></strong><br>
request.getMethod():	<strong><%=request.getMethod()%></strong><br>
request.getRequestURI():	<strong><%=request.getRequestURI()%></strong><br>
request.getContextPath():	<strong><%=request.getContextPath()%></strong><br>
request.getServerName():	<strong><%=request.getServerName()%></strong><br>
request.getServerPort():	<strong><%=request.getServerPort()%></strong><br>
	
	
</body>
</html>





