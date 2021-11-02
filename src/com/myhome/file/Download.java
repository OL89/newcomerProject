package com.myhome.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file/Download")
public class Download extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("fileName");

		
		String realFolder = request.getServletContext().getRealPath("/storage");

		 
		File file = new File(realFolder, fileName);

		 
		
		
		fileName="attachment;fileName="+new String(URLEncoder.encode(fileName,"UTF-8")).replaceAll("\\+"," ");
		response.setHeader("Content-Disposition", fileName);
		response.setHeader("Content-Length", String.valueOf(file.length()));

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

		byte[] b = new byte[(int)file.length()];
		bis.read(b, 0, b.length); 
		bos.write(b);
		
		bis.close();
		bos.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
