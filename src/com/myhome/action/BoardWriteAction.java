package com.myhome.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myhome.dao.BoardDao;
import com.myhome.dto.BoardDto;

public class BoardWriteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String writer = null;
		String nickname = null;
		BoardDto dto = null;
		BoardDao dao = null;
		boolean result = false;
		ActionForward actionForward = new ActionForward(); // 다음 목적지가 어디인지
		HttpSession session = request.getSession(); // session 얻어오기
		
		request.setCharacterEncoding("UTF-8");
		writer = (String)session.getAttribute("currentId");
		nickname = (String)session.getAttribute("currentNickname");
		
		if(writer != null) {
			dto = new BoardDto();
			dto.setTitle( request.getParameter("board_title"));
			dto.setContent( request.getParameter("board_content"));
			dto.setWriter(writer);
			dto.setNickname(nickname);
			
			dao = BoardDao.getInstance();
			result = dao.insert(dto);
		}
		request.setAttribute("state", "write");
		request.setAttribute("result", result);
		actionForward.setNextPath("Result.do"); // 결과페이지로 이동(write의 결과 true/false라는 파라미터도 전달)
		actionForward.setRedirect(false);
		return actionForward;
	}
}
