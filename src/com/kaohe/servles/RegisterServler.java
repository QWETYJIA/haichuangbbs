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
			session.setAttribute("results", "��ӭע�ᣨ�˺���ȶ������ʽ����");}
			else {session.setAttribute("results", "���벻�淶,�������Ӣ����ĸ������,����λ��������8λ,������10λ");
			response.sendRedirect(request.getContextPath()+"/register.jsp");
			return;	}
		}else  {
			session.setAttribute("results", "��ȶ������ʽ����");
			response.sendRedirect(request.getContextPath()+"/register.jsp");
			return;
		}
		//huoqusession
		
		Yonghu yonghu =new Yonghu(name);
		yonghu.setPassword(password);
		yonghu.setGl(gl);
		yonghu.setUsername(username);
		//�˺ź����������֤ servletʱcontrol
	 	IYonghuService service = new YonghuServiceImpl();
 	    service.saveYonghu(yonghu);//�ṩҵ��ķ���check�û��ķ���
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	

	}

}
