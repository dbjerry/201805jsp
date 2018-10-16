<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td {	border : 1px solid pink;
	}
</style>
</head>
<body>
	<h2>jsp</h2>
	<table>
		<%for(int j = 1; j < 10; j ++){%>
			<tr>
			<%for(int i = 2; i < 10; i ++){%>
				<td><%=i %> * <%=j %> = <%=i*j%> </td>
			<%} %>
			</tr>		
		<%} %>
	</table>
	<br>
	<h2>core</h2>
	<table>
		<c:forEach begin="1" end="9" var="j">
			<tr>
				<c:forEach begin="2" end="9" var="i">
					<td>${i}&nbsp;*&nbsp;${j}&nbsp;=&nbsp;${i*j}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>


