package com.myhome.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file/FileList")
public class FileList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 자료실 목록 만들기
		String storagePath = request.getServletContext().getRealPath("/storage");
		File storageDirectory = new File(storagePath); // storage 디렉토리를 File 객체화 
		File[] files = storageDirectory.listFiles();
		request.setAttribute("files", files); // 파일 목록 배열을 애트리뷰트로 추가
		
		request.getRequestDispatcher("fileListView.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
