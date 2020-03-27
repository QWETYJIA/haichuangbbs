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
		//1 接收请求参数
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
			session.setAttribute("message", "用户名输入有误,请用邮箱的格式");
			System.out.println("==================");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return;
	           } 
		
		if(password ==null||"".equals(password.trim())) {
			session.setAttribute("message", "密码输入有误");
			System.out.println("==================");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return;
	           } 		
		
		IYonghuService service = new YonghuServiceImpl();//账号和密码进行验证 servlet时control
		Yonghu yonghu = service.checkUser(name,password,gl);//提供业务的方法check用户的方法
		
		if(yonghu==null){
			
			session.setAttribute("message", "用户名和密码输入有误或你不是管理员");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			
			return;
		}else if(checkcode.equals(piccode)){
			String mingzi=yonghu.getName();
			session.setAttribute("username", mingzi);
           String username=(String) session.getAttribute("username");
           session.setAttribute("message", "欢迎来到论坛");
			response.sendRedirect(request.getContextPath()+"/welcome.jsp");}
		else {
			session.setAttribute("message", "验证码输入错误");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			
		}
		
	/*	if(yonghu ==null) {//验证通过则跳转到系统的主页index.jsp
			session.setAttribute("message", "用户名和密码输入有误or你不是管理员");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
		else{
			}*/
		
}
}