package com.myhome.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myhome.dao.MemberDao;
import com.myhome.dto.MemberDto;
@WebServlet("/join/joinLogic.jsp")
public class Join extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터를 꺼내서 그것들을
		// => DB의 member 테이블의 레코드로 추가 (회원 등록)
		// => 결과페이지(joinResultView.jsp)로 페이지 이동 
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("user_id");
		String password = request.getParameter("user_password");
		String email = request.getParameter("user_email1") + "@" + request.getParameter("user_email2");
		String nickname = request.getParameter("user_nickname");
		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPassword(password);
		dto.setEmail(email);
		dto.setNickname(nickname);
		MemberDao dao = new MemberDao();
		boolean result = dao.insert(dto);
		response.sendRedirect("joinResultView.jsp?result="+result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
