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
	.infowindow-background{
		background-color: black;
		
	}
	
</style>
</head>
<body>
	<div class="infowindow-backgound">
		<div class="infowindow-info">
			<div>author</div>
			<div>title</div>
		</div>
		<div>
			<img src="${rootPath}/static/image/(x).png"/>
		</div>
		<div>
			<div>메모메메메멩ㄴㅁㅇㅁㄴㄹㅈㄹㅈㄹㅈㄹㅈㄻㅊㄴ윤ㅁㅍ렂ㅍ첲ㅁㄴ츤ㅁ</div>
		</div>
	</div>

</body>
</html>