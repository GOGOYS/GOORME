<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>

<style>
body {
	background-color: #45AFFF;
}

.container {
	position: fixed;
	top: 40%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 400px;
	height: 500px;
}

.logo-img img {
	width: 100%;
	margin: 0 auto;
}

.btn{
	width: 80%;
	margin: 0 auto;
	margin-top: 40px;
	display: flex;
	justify-content:center;
}

.btn a {
	text-decoration: none;
	color: #fff;
	background-color: #186D94;
	padding: 8px 20px;
	border-radius: 8px;
}
.btn a:first-child {
	margin-right: 12px;
}

.btn a:hover {
	background-color: #fff;
	color:#186D94;
	font-weight: 900;
}
</style>
</head>
<body>

	<div class="container">
		<div class="logo-img">
			<img src="${rootPath}/static/image/logoWhite.png">
		</div>
		<div class="btn">
			<c:if test="${empty USER}">
				<a href="${rootPath}/user/join">회원가입</a>
				<a href="${rootPath}/user/login">로그인</a>
			</c:if>
			<c:if test="${not empty USER}">
				<a href="${rootPath}/memo/map">리스트 보기</a>
				<a href="${rootPath}/user/logout">로그아웃</a>
			</c:if>
		</div>
	</div>


</body>
</html>