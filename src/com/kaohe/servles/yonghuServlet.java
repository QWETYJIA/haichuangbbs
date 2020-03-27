package com.kaohe.servles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaohe.beans.Yonghu;
import com.kaohe.service.yonghuService;
import com.zuopin.beans.Tiezi;
import com.zuopin.service.InputTiezi;

/**
 * Servlet implementation class yonghuServlet
 */
public class yonghuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int Id= Integer.valueOf(request.getParameter("id"));
		//PrintWriter out = response.getWriter();
		//out.print(Id);
		Yonghu yonghu = new yonghuService().findid(Id);
		HttpSession session=request.getSession();
		session.setAttribute("tz", yonghu);
		request.getRequestDispatcher("yonghu.jsp").forward(request, response);
	}

	

}
