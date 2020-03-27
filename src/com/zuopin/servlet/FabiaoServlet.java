package com.zuopin.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zuopin.beans.Tiezi;
import com.zuopin.service.InputTiezi;

/**
 * Servlet implementation class FabiaoServlet
 */
public class FabiaoServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setCharacterEncoding("GB18030");
		HttpSession session = request.getSession();
		
	//	PrintWriter out = response.getWriter();
		
		 response.setCharacterEncoding("GB18030");
				request.setCharacterEncoding("UTF-8");
		String title =request.getParameter("title");
		 String neirong =request.getParameter("neirong");
		 String username=(String) session.getAttribute("username");
		 String name =username;
		 //if(name==null) {
			// out.print("������˼���¼�˺ţ�");
			 //request.getRequestDispatcher("welcome.jsp").forward(request, response);
			 
		 //}else {
		 Date date=new Date();//ȡ�õ�ǰʱ��
		 SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time = tempDate.format(date); 
		Tiezi tiezi =new Tiezi(title,neirong,name,time);
		//tiezi.setTitle(title);
		//tiezi.setNeirong(neirong);
		//tiezi.setName(name);
		//tiezi.setTime(time);
		InputTiezi tz = new InputTiezi();
		//tz.insertTiezi(tiezi);
		//request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		int row =tz.insertTiezi(tiezi);
		if(row > 0){
			// ���³������Ϣ
			out.print("�ɹ������ " + row + "�����ݣ�");
		}else{
			out.print("���ʧ�ܣ�");}
		//out.flush();
		//out.close();
		
		
		
		 //}
		
	}

}
