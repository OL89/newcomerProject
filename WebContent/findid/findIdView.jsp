<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp">
	<jsp:param name = "title" value = "Find id" />
</jsp:include>
<form action = "findIdLogic.jsp" method = "post">
	<table border = "1">
		<caption><h3>아이디 찾기</h3></caption>
		<tr>
			<td><input type = "text" name = "user_email" placeholder = "이메일을 입력하세요."></td>
		</tr>
		<tr>
			<td align = "center"><input type = "submit" value = "아이디 찾기"></td>
		</tr>
	</table>
</form>
<jsp:include page="/layout/footer.jsp" />