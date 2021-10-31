<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp">
	<jsp:param name = "title" value = "Login" />
</jsp:include>
<c:choose>
	<c:when test = "${ sessionScope.currentNickname != null }">
		<h3>환영합니다, ${ sessionScope.currentNickname }님!</h3><br>
		<h6><a href='/myhome/signout/signoutView.jsp'>회원 탈퇴</a></h6>
	</c:when>
	<c:otherwise>
		<h3>아이디 혹은 비밀번호를 확인해주세요.</h3>
	</c:otherwise>
</c:choose>
<input type = "button" value = "메인으로" onclick = "location.href='/myhome/index.jsp'">
<jsp:include page="/layout/footer.jsp"/>