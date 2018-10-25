<%@tag import="java.sql.SQLException"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Connection"%>
<%@tag import="java.sql.PreparedStatement"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="code" required="true"%>
code : ${code}<br>
<%
	String code = (String)jspContext.getAttribute("code");

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jerry";
		String pass = "java";
		
		conn = DriverManager.getConnection(url, user, pass);
		
		String sql = "SELECT prod_id, prod_name FROM prod WHERE prod_lgu = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, code);
		
		rs = pstmt.executeQuery();
		
		out.write("<select>");
		while(rs.next()){
			out.write("<option id=\"" + rs.getString("prod_id") + "\">" + rs.getString("prod_name") + "</option>");
		}
		out.write("</select>");
		
		conn.close();
		
	}catch(SQLException e){
		e.printStackTrace();
	
	}

%>