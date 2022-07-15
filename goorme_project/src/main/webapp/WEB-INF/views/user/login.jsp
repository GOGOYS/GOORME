<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<style>
	* {
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	
	html{
		width: 100vw;
		height: 100vh;
	}
	
	body{
		width: 100%;
		height: 100%;
		display:  flex;
		justify-content: center;
		align-items: center;
	}
	
	form{
		width: 50%;
		text-align: center;
	}
	
	input{
		padding: 1rem;
		width: 100%;
	}
</style>
</head>
<body>
	<div class="login-box">
		<div>
			<h1>로그인</h1>	
			<c:if test="${LOGIN_MESSAAGE == 'USER_ID FAIL' }">
			<p>아이디가 틀립니다</p>
			</c:if>
			<c:if test="${LOGIN_MESSAAGE == 'USER_PASSWORD FAIL' }">
			<p>비밀번호가 틀립니다</p>
			</c:if>
		</div>	
		<form method="POST">
			<input class="userid" name="u_userid" placeholder="USERNAME">
			<input class="password" name="u_password" placeholder="PASSWORD">
			<button class="btn_login">로그인</button>
		</form>
	</div>
</body>
<script>
	const userid = document.querySelector("input.userid");
	const password = document.querySelector("input.password");
	const btn_login = document.querySelector("input.btn_login");
	
	btn_login.eventListener("click",()=>{
		if(userid.value == ""){
			alret("ID를 입력하세요");
			userid.focus();
			return false;
		}
		
		if(password.value == ""){
			alret("PASSWORD를 입력하세요");
			password.focus();
			return false;
		}
		
		btn_login.submit();
	})
	
	
</script>
</html>