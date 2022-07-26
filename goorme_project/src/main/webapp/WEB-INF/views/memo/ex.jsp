<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<style>
	*{
		box-sizing: border-box;
		margin:0;
		padding:0;
	}	
	.infowindow-background{
		background-color: #aaa;	
		border-radius:8px;
		width:260px;
		height: 108px;
		margin:30px;
		padding:12px 16px;
	}
	
	.infowindow-info{
		display: flex;
		padding-bottom: 3px;
		border-bottom: 1px solid black;
	}
	.infowindow-info img{
		width: 20px;
		height: 20px;
		overflow: hidden;
		border-radius: 50%;
		margin-right:4px;
	}
	.infowindow-author{
		margin-right: auto;
	}
	
	.infowindow-head{
		display: flex;
	}
	
	.infowindow-title{
		margin-top:5px;
	 	font-size: 20px;
	}
	
	.infowindow-body div{
		width:224px;
		height: 40px;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
	}
	
	.infowindow-count{
		font-size: 10px;
		margin-left:auto;
		margin-top:14px;
	}
	
</style>
</head>
<body>
	<div class="infowindow-background">
		<div class="infowindow-info">
			<img src="${rootPath}/static/image/x(1).png"/>
			<div class="infowindow-author">작성자</div>
			<i class="fa-solid fa-heart"></i>
		</div>
		<div class="infowindow-head">
			<div class="infowindow-title">제목</div>
			<div class="infowindow-count">10번째 구름</div>
		</div>
		<div class="infowindow-body">
			<div>메모</div>
		</div>
	</div>
</body>
</html>