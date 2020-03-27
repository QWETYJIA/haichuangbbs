package com.zuopin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuopin.beans.Tiezi;
import com.zuopin.service.InputTiezi;
  public class XiugaiServlet extends HttpServlet {
	  
	 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//response.setCharacterEncoding("GB18030");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int Id=Integer.valueOf(request.getParameter("id"));

		 String title =request.getParameter("title");
		// out.print(title);
		 String neirong =request.getParameter("neirong");
		 //out.print(neirong);
		String name =request.getParameter("name");
		//out.print(Id);
		 Date date=new Date();//取得当前时间
		 SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time = tempDate.format(date); 
		 //out.print(time);
		Tiezi tiezi =new Tiezi(title,neirong,name,time);
		//tiezi.setTitle(title);
		//tiezi.setNeirong(neirong);
		//tiezi.setName(name);
		//tiezi.setTime(time);
		InputTiezi tz = new InputTiezi();
		tz.xiugaitiezi(tiezi,Id);
		// response.sendRedirect("");
		response.sendRedirect("gerenckServlet?osid=xiugai");

		
		
		
		
		
		
	
	}

}
