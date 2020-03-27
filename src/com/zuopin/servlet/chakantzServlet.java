package com.zuopin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zuopin.beans.Tiezi;
import com.zuopin.service.InputTiezi;

/**
 * Servlet implementation class chakantzServlet
 */
public class chakantzServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Id= Integer.valueOf(request.getParameter("id"));
		//PrintWriter out = response.getWriter();
		//out.print(Id);
		Tiezi tz = new InputTiezi().findid(Id);
		HttpSession session=request.getSession();
		session.setAttribute("tz", tz);
		request.getRequestDispatcher("chakan.jsp").forward(request, response);
	}

	

}
