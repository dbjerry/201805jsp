<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="date" value="<%=new Date() %>"/>
	<strong>date :</strong> ${date }<br>
	<strong>formatDate :</strong> <fmt:formatDate value="${date }"/><br>
	<strong>formatDate(pattern) :</strong> <fmt:formatDate value="${date }" pattern="yyyy-MM-dd hh:mm:ss"/><br>
	<strong>type="date" :</strong> <fmt:formatDate value="${date }" type="date"/><br>
	<strong>type="time" :</strong> <fmt:formatDate value="${date }" type="time"/><br>
	<strong>dateStyle(full) :</strong> <fmt:formatDate value="${date }" dateStyle="full"/><br>
	<strong>dateStyle(medium) :</strong> <fmt:formatDate value="${date }" dateStyle="medium"/><br>
	<strong>dateStyle(short) :</strong> <fmt:formatDate value="${date }" dateStyle="short"/><br>
	
	<c:set var="parseDate" value="2018-10-25"/>
	<strong>parseDate :</strong> <fmt:parseDate var="dt" value="${parseDate }" pattern="yyyy-MM-dd"/>
	${dt}
</body>
</html>