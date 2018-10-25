<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/js/jquery-3.3.1.min.js"></script>
<title>selectLang.jsp</title>
<style type="text/css">
	*{
		font-family: Consolas;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#selectLang").on("change", function(){
			//var o = $("#selectLang option:selected").val();
			var o = $("select[name=lang]").val();
			console.log(o);
			
			$("#lang").val(o);
			$("#frm").submit();
			
		});
	});
</script>
</head>
<body>
<%--
	1. lang 이라고 이름지어진 파라미터로 locale을 설정
	2. 만약 lang 파라미터가 없을 경우 ko를 기본값으로 사용
	3. select box가 변경될 때 해당 언어로 페이지 재요청
	4. select box는 현재 요청된 lang 파라미터 언어값이 선택되어져 있어야 함
		(lang 파라미터가 없을 경우 기본값 ko)
	
	최초 접속 : http://localhost:8081/jstl/fmt/selectLang.jsp
	그 이후 : select box를 변경하여 페이지 재요청
--%>
	<h2>selectLang.jsp</h2>

	<c:set var="lang" value="${param.lang == null ? 'ko' : param.lang}"/>
	
	lang : ${param.lang }<br>
	
	<form id="frm" action="selectLang.jsp">
		<select id="selectLang" name="lang" >
			<option value="ko" ${param.lang == "ko" ? 'selected' : ""}>한국어</option>
			<option value="ja" ${param.lang == "ja" ? 'selected' : ""}>日本語</option>
			<option value="en" ${param.lang == "en" ? 'selected' : ""}>english</option>
		</select>
	</form>
	
	<fmt:setLocale value="${param.lang}"/>
	<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
		<fmt:message key="hello"></fmt:message><br>
		<fmt:message key="visitor">
			<fmt:param value="brown"></fmt:param>
		</fmt:message>
	</fmt:bundle>

</body>
</html>