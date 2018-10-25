<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bundle.jsp</title>
<style type="text/css">
	*{
		font-family: Consolas;
	}
</style>
</head>
<body>
	<h2>기본 로케일</h2>
	<!-- 확장자는 작성하지않고 파일명까지만 작성 -->
	<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
		<fmt:message key="hello"></fmt:message><br>
		<fmt:message key="visitor">
			<fmt:param value="brown"></fmt:param>
		</fmt:message>
	</fmt:bundle>
	
	<h2>변경 로케일 : ja(japen)</h2>
	<fmt:setLocale value="ja"/>
	<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
		<fmt:message key="hello"></fmt:message><br>
		<fmt:message key="visitor">
			<fmt:param value="brown"></fmt:param>
		</fmt:message>
	</fmt:bundle>
	
	<h2>변경 로케일 : en(english)</h2>
	<fmt:setLocale value="en"/>
	<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
		<fmt:message key="hello"></fmt:message><br>
		<fmt:message key="visitor">
			<fmt:param value="brown"></fmt:param>
		</fmt:message>
	</fmt:bundle>
	
	<h2>setBundle</h2>
	<fmt:setBundle basename="kr.or.ddit.resource.msg.msg" var="msg"/>
	<fmt:message key="hello" bundle="${msg }"></fmt:message><br>
	<fmt:message key="visitor" bundle="${msg }">
		<fmt:param value="brown"></fmt:param>
	</fmt:message>
</body>
</html>