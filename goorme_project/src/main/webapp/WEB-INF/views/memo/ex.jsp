<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		box-sizing: border-box;
		margin:0;
		padding:0;
	}	
	.infowindow-background{
		background-color: #aaa;	
		border-radius:8px;
		width:240px;
		height: 120px;
		margin:30px;
		padding:10px 8px;
	}
	
	.infowindow-info{
		display: flex;
		border-bottom: 1px solid black;
	}
	.infowindow-info img{
		width: 20px;
		height: 20px;
		overflow: hidden;
		border-radius: 50%;
	}
	
	.infowindow-head{
		margin-top:5px;
		border-bottom: 1px solid black;
	}
	
	.infowindow-body div{
		width:224px;
		height: 60px;
		overflow: hidden;
	}
	
</style>
</head>
<body>
	<div class="infowindow-background">
		<div class="infowindow-info">
			<img src="${rootPath}/static/image/x(1).png"/>
			<div class="infowindow-author">작성자</div>
			<div class="infowindow-count">10번째 구름</div>
		</div>
		<div class="infowindow-head">
			<div>제목</div>
		</div>
		<div class="infowindow-body">
			<div>메모메메메멩ㄴㅁㅇㅁㄴㄹㅈㄹㅈㄹㅈㄹㅈㄻㅊㄴ윤ㅁㅍ렂ㅍ첲ㅁㄴ츤ㅁfwfffffffffffffffffffffffffffffffffffffffffffffffffffff
			메모메메메멩ㄴㅁㅇㅁㄴㄹㅈㄹㅈㄹㅈㄹㅈㄻㅊㄴ윤ㅁㅍ렂ㅍ첲ㅁㄴ츤ㅁfwfffffffffffffffffffffffffffffffffffffffffffffffffffff</div>
		</div>
	</div>

</body>
</html>