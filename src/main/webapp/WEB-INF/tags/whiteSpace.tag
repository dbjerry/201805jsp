<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="length" type="String" required="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach begin="1" end="${length == null ? 11 : length}">&nbsp;&nbsp;</c:forEach>
