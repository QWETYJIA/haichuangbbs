package com.kaohe.servles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaohe.beans.Yonghu;
import com.kaohe.service.IYonghuService;
import com.kaohe.service.YonghuServiceImpl;


public class LoginServler extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1 �����������
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String gl = request.getParameter("gl");
		//String str1="\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
		//huoqusession
		String piccode = (String) request.getSession().getAttribute("piccode");
		String checkcode = request.getParameter("checkcode");
		checkcode = checkcode.toUpperCase();
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		boolean code=checkcode.equals(piccode);
		HttpSession session = request.getSession();
		//session.setAttribute("username", name);
		session.setAttribute("gly", gl);
		
		if(name ==null||"".equals(name.trim())) {
			session.setAttribute("message", "�û�����������,��������ĸ�ʽ");
			System.out.println("==================");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return;
	           } 
		
		if(password ==null||"".equals(password.trim())) {
			session.setAttribute("message", "������������");
			System.out.println("==================");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return;
	           } 		
		
		IYonghuService service = new YonghuServiceImpl();//�˺ź����������֤ servletʱcontrol
		Yonghu yonghu = service.checkUser(name,password,gl);//�ṩҵ��ķ���check�û��ķ���
		
		if(yonghu==null){
			
			session.setAttribute("message", "�û�������������������㲻�ǹ���Ա");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			
			return;
		}else if(checkcode.equals(piccode)){
			String mingzi=yonghu.getName();
			session.setAttribute("username", mingzi);
           String username=(String) session.getAttribute("username");
           session.setAttribute("message", "��ӭ������̳");
			response.sendRedirect(request.getContextPath()+"/welcome.jsp");}
		else {
			session.setAttribute("message", "��֤���������");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			
		}
		
	/*	if(yonghu ==null) {//��֤ͨ������ת��ϵͳ����ҳindex.jsp
			session.setAttribute("message", "�û�����������������or�㲻�ǹ���Ա");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
		else{
			}*/
		
}
}