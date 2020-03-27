package com.kaohe.servles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaohe.service.yonghuService;
import com.zuopin.service.InputTiezi;

/**
 * Servlet implementation class deleteyhServlet
 */
public class deleteyhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Id= Integer.valueOf(request.getParameter("id"));
		yonghuService service=new yonghuService();
		service.delete(Id);
		response.sendRedirect("chaPTServlet?osid=delete");	}

	

}
