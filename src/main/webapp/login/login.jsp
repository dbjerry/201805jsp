<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form action="/dditLogin" method="post" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">ID </label>
        <input type="text" name="userId" id="inputEmail" class="form-control" placeholder="Email address" required autofocus value="brown">
        <label for="inputPassword" class="sr-only">Password </label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required value="brownpass">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
	
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <link href="/css/login.css/" rel="stylesheet"> -->
<!-- <link href="/css/bootstrap.css/" rel="stylesheet"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<div class="container"> -->
<%-- 		<%--
<%-- 			브라우저 주소줄에 입력한경우 : get
<%-- 			form 태그의 method 속성 : get/post
<%-- 	 	--%>
 		<!-- <form action="/login/loginProcess.jsp" method="post"> -->
<!-- 		<form class="form-signin" action="/dditLogin" method="post"> -->
<!-- 			<h2 class="form-signin-heading">Please sign in</h2> -->
<!-- 			<label for="inputId" class="sr-only">USER ID</label> -->
<!-- 			<input type="text" id="inputId" class="form-control" name="userId" value="brown"> <br> -->
 			<!-- 사용자 아이디 : <input type="text" name="userId" value="샐리"> <br> -->
<!-- 			<label for="inputPassword" class="sr-only">Password</label> -->
<!-- 			<input type="password" id="inputPassword" class="form-control" name="password" value="pass1234"> -->
<!-- 			<br> <input type="submit" value="로그인"> -->
<!-- 		</form> -->

<!-- 	</div> -->
<!-- </body> -->
<!-- </html> -->

