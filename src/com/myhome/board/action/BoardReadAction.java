package com.myhome.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myhome.dao.BoardDao;
import com.myhome.dao.CommentDao;
import com.myhome.dto.BoardDto;
import com.myhome.dto.CommentDto;

public class BoardReadAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = null;
		BoardDao boardDao = BoardDao.getInstance();
		BoardDto boardDto = null;
		int boardNum = Integer.parseInt( request.getParameter("brdNo")); // url에 첨부된 글번호 파라미터 받기
		CommentDao commentDao = CommentDao.getInstance(); // 댓글 dao
		ArrayList<CommentDto> commentList = commentDao.getList(boardNum); // 댓글 리스트 가져오기
		String attName = "brd_" + boardNum; // 새로고침 시 조회 수 증가를 막기위해 세션에 정보 저장
		HttpSession session = request.getSession();
		
		if(session.getAttribute(attName) == null) { // 현재 세션이 이 글을 본적이 없다면 
			boardDao.updateHit(boardNum); // 조회수 1 증가
			session.setAttribute(attName,  "Y"); // attName (예. "brd_22") 을 session의 attribute로 등록 
		}
		boardDto = boardDao.select(boardNum); // DB 조회 + 결과를  Dto에 저장
		request.setAttribute("brdDto", boardDto);
		request.setAttribute("commentList", commentList);
		
		
		actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setNextPath("BoardReadView.do");
		return actionForward;
	}
}
