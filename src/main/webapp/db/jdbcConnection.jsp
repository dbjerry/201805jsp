<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jdbcConnection.jsp</title>
</head>
<body>
	<%
	/*
	 * 데이터베이스 처리 순서
	 * 1) 드라이버 로딩
	 * 2) 해당 DB에 접속
	 * 3) 질의(SQL명령) 수행
	 * 4) 질의 결과를 받고 처리
	 * 5) 종료(사용했던 자원을 반납)
	 */

	/* DB작업에 필요한 객체변수 선언 */
	Connection conn = null;

	try {
		/**
		 * 1) 드라이버 로딩
		 * 	- Class.forName()을 이용
		 */
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		/**
		 * 2) 해당 DB에 접속
		 * 	- DriverManager.getConnection()을 이용하고
		 *	    접속이 성공하면 Connection객체가 생성
		 */
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SYS as sysdba";	//	등록된 사용자 ID
		String pass = "java";	//	등록된 사용자 패스워드

		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 30; i++){
			conn = DriverManager.getConnection(url, user, pass);
			out.println("schema : " + conn.getSchema() + "<br>");
			try { conn.close(); } catch (Exception e){}
		}
		long endTime = System.currentTimeMillis();
		
		out.println("endTime - startTime : " + ((double)(endTime - startTime)/1000) + "sec");
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}finally{
		
		/* 6) 사용한 자원을 반납 */
		if(conn != null){try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		
	}
	
	%>
</body>
</html>