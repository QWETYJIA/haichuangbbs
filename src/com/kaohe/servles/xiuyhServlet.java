package com.kaohe.servles;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaohe.service.yonghuService;
import com.zuopin.beans.Tiezi;
import com.zuopin.service.InputTiezi;

/**
 * Servlet implementation class xiuyhServlet
 */
public class xiuyhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//response.setCharacterEncoding("GB18030");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int Id=Integer.valueOf(request.getParameter("id"));

		
		String gl =request.getParameter("gl");
		
		 yonghuService service=new yonghuService();
		 service.xiugaiyonghu(gl,Id);
		// response.sendRedirect("");
		response.sendRedirect("chayhServlet?osid=xiugai");

		
		
		
		
		
	}

}
