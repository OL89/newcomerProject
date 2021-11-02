package com.myhome.board.action;

public class ActionForward { // 페이지의 다음 실행 페이지가 어디인지 
	private boolean isRedirect; // true : redirect 할 것이다. false : forward 할 것이다. 
	private String nextPath; 	// 다음 경로
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getNextPath() {
		return nextPath;
	}
	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}
}
