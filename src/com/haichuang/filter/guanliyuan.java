package com.haichuang.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class guanliyuan implements Filter {
	private FilterConfig config;
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		
		String Guan=(String)session.getAttribute("gly"); 
		 String Name=(String)session.getAttribute("username");  
		 String GL="0";
		
		if(Name==null){
			session.setAttribute("jieguo", "�Բ�����û�е�¼�˺ţ�����������������");
			response.sendRedirect("jieguo.jsp");
		}else if( Guan.equals(GL)){
			session.setAttribute("jieguo", "�Բ����㲻�ǹ���Ա������������������");
			response.sendRedirect("jieguo.jsp");
		}
		else {
			arg2.doFilter(arg0, arg1);
			
		}
		
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException{
		
	}

}