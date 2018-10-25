<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="length" type="Integer" required="false"%>
<%@ attribute name="color" type="String" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br>
<font color="${color}">

<c:forEach begin="1" end="${length == null ? 20 : length}">=</c:forEach>
logging

<c:forEach begin="1" end="${length == null ? 20 : length}">=</c:forEach>

</font><br>

