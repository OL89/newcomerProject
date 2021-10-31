<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:include page = "/layout/header.jsp" >
	<jsp:param name = "title" value = "Mypage"/>
</jsp:include>

<form action = "mypageLogic.jsp" method = "post">
	<h2>내 정보 보기</h2>
	PW
	<input type = "password" name = "user_password" 
	       placeholder = "${currentNickname }님의 비밀번호" required>
	<br>
	<input type = "submit" value = "내 정보 보기">
</form>

<jsp:include page = "/layout/footer.jsp"/>