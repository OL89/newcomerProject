<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sera's: ${ param.title != null ? param.title : "My WebPage!"}</title>
		<link rel="stylesheet" type="text/css" href="/myhome/layout/layout.css">
	</head>
	<body>
		<div align = "center">
			<div class = "header" align = "center">
			<c:choose>
			<c:when test = "${sessionScope.currentNickname == null }">
			<a href="/myhome/login/loginView.jsp">LOGIN</a> |
			<a href="/myhome/join/joinView.jsp">JOIN</a> |
			</c:when>
			<c:otherwise>
			${sessionScope.currentNickname }님 | 
			<a href="/myhome/logout/logoutLogic.jsp">LOGOUT</a> | 
			<a href="/myhome/mypage/mypageView.jsp">MY PAGE</a> |
			</c:otherwise>
			</c:choose>
			<a href = "/myhome/board/BoardList.do?page=1">BOARD</a> |
			<a href = "/myhome/file/FileList">DOWNLOADS</a>
			</div>
			<div class="main" align="center">
			

