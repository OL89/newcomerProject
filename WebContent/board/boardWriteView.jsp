<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp">
	<jsp:param name = "title" value = "Board Write" />
</jsp:include>

<form action = "BoardWrite.do" method = "post">
	<table border ="1">
		<caption><h2>게시글 쓰기</h2></caption>
		<tr>
			<th>제목</th>
			<td align = "center">
				<input type = "text" name = "board_title" size = "72" placeholder = "글 제목을 입력하세요." required>
			</td>
		</tr>
		<tr>
			<td colspan = "2" align = "center">
				<textarea name = "board_content" rows = "20" cols = "80">따뜻한 말 한마디가 모두를 미소짓게 합니다.</textarea>
			</td>			
		</tr>
		<tr>
			<td colspan = "2" align = "center">
				<input type = "submit" value = "글쓰기">
				<input type = "reset" value = "초기화">
			</td>
		</tr>
	</table>
</form>
<jsp:include page="/layout/footer.jsp"/>