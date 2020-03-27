package com.kaohe.servles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaohe.beans.Yonghu;
import com.kaohe.service.IYonghuService;
import com.kaohe.service.YonghuServiceImpl;

public class RegisterServler extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gl = request.getParameter("gl");
		
		//HttpSession session = request.getSession();
		HttpSession session = request.getSession();
		session.setAttribute("gl", gl);
		String str1="\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
		String str2="^[A-Za-z0-9]{8,10}+$";
		if(username.matches(str1)) {
			if(password.matches(str2)) {
			session.setAttribute("results", "欢迎注册（账号请比对邮箱格式！）");}
			else {session.setAttribute("results", "密码不规范,必须包括英文字母与数字,并且位数不少于8位,不大于10位");
			response.sendRedirect(request.getContextPath()+"/register.jsp");
			return;	}
		}else  {
			session.setAttribute("results", "请比对邮箱格式输入");
			response.sendRedirect(request.getContextPath()+"/register.jsp");
			return;
		}
		//huoqusession
		
		Yonghu yonghu =new Yonghu(name);
		yonghu.setPassword(password);
		yonghu.setGl(gl);
		yonghu.setUsername(username);
		//账号和密码进行验证 servlet时control
	 	IYonghuService service = new YonghuServiceImpl();
 	    service.saveYonghu(yonghu);//提供业务的方法check用户的方法
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	

	}

}
