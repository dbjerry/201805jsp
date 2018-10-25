<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>logging.jsp</title>
<style type="text/css">
	*{
		font-family: Consolas;
	}
	h2{
		color: powderblue;
	}
</style>
</head>
<body>
	<h2>select box</h2>
	<tags:code code="P201"/>

	<h2>logging tag</h2>
	<tags:loggingTag/>
		<c:forEach var="i" begin="1" end="10">
			${i }<br>
		</c:forEach>
	<tags:loggingTag/>
	
	<h2>color logging tag</h2>
	<tags:colorLogging color="powderblue"/><br>
	
		<c:forEach var="i" begin="1" end="10">
			<tags:whiteSpace/>${i }<br>
		</c:forEach>
	<tags:colorLogging color="pink"/>
	
</body>
</html>