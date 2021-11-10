package com.myhome.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/file/Upload")
public class Upload extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName1 = null;
		String fileName2 = null;
		File file1 = null;
		File file2 = null;
		long fileSize1 = 0;
		long fileSize2 = 0;
		
		
		String realPath = request.getServletContext().getRealPath("/storage");
		System.out.println("storage 폴더의 실제 경로 = " + realPath);

		
		
		
		MultipartRequest mr = new MultipartRequest(
									request, 		
									realPath, 		
									5 * 1024 * 1024, 
									"UTF-8", 		
									new DefaultFileRenamePolicy() 
								);

		
		String originalFileName1 = mr.getOriginalFileName("user_file1");
		String originalFileName2 = mr.getOriginalFileName("user_file2");
		
		System.out.println("originalFileName1 : " + originalFileName1);
		System.out.println("originalFileName2 : " + originalFileName2);
		if (originalFileName1 != null) {
			
			fileName1 = mr.getFilesystemName("user_file1");
			
			
			file1 = mr.getFile("user_file1");
			
			
			fileSize1 = file1.length();
		}

		if (originalFileName2 != null) {
			
			fileName2 = mr.getFilesystemName("user_file2");
			
			
			file2 = mr.getFile("user_file2");
			
			
			fileSize2 = file2.length();
		}
		
		request.setAttribute("originalFileName1", originalFileName1);
		request.setAttribute("fileName1", fileName1);
		request.setAttribute("fileSize1", fileSize1);

		request.setAttribute("originalFileName2", originalFileName2);
		request.setAttribute("fileName2", fileName2);
		request.setAttribute("fileSize2", fileSize2);
		
		request.getRequestDispatcher("/file/fileUploadResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
