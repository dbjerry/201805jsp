<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timezone.jsp</title>
</head>
<body>
	<h2>Timezone</h2>
	<c:set var="now" value="<%=new Date() %>"/>
	한국 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
	
	<fmt:timeZone value="Asia/HongKong">
		홍콩 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
	</fmt:timeZone>
	
	<fmt:timeZone value="Asia/Bangkok">
		태국(방콕) : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
	</fmt:timeZone>
	
</body>
</html>