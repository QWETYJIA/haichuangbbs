package com.zuopin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class chaxun
 */
public class chaxun extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		response.setCharacterEncoding("GB18030");
			request.setCharacterEncoding("UTF-8");
		  String Name = request.getParameter("name");
		   String title = request.getParameter("title");
		   session.setAttribute("Name", Name);
		
		   session.setAttribute("Title", title);
		//   request.getRequestDispatcher("").forward(request, response);
		   
		   if(Name==null)
			   request.getRequestDispatcher("TitleServler").forward(request, response);
		else
	request.getRequestDispatcher("NeirongServler").forward(request, response);

	}

}
