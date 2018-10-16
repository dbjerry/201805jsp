<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lotto.jsp</title>

</head>
<body>
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jerry";
		String pass = "java";
		
		conn = DriverManager.getConnection(url, user, pass);
		stmt = conn.createStatement();
		String sql = "SELECT * FROM jspstudent WHERE no = (SELECT round(dbms_random.value(1,19)) FROM dual)";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
%>
<canvas id="myCanvas" width="400" height="400" style="border: 1px solid #000000"></canvas>
</body>
<script type="text/javascript">
	//ctx.fillStyle = "#FF0000";	//	빨간 사각형
	//ctx.fillRect(0, 0, 150, 75);	//	사각형 좌표
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	ctx.beginPath();
	ctx.arc(100, 100, 100, 0, 2*Math.PI);
	ctx.stroke();
	ctx.font = "60px Arial";
// 	ctx.fillText("브라운", 10, 120);
	ctx.fillText("<%=rs.getString("name") %>", 10, 120);
	ctx.closePat();
	
</script>
<%
		}
	}catch(SQLException e){
		e.printStackTrace();
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}finally{
		if(rs != null){try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }}
		if(stmt != null){try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		if(conn != null){try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
	}
%>
</html>