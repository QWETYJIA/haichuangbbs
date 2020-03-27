package com.zuopin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zuopin.beans.Tiezi;
import com.zuopin.service.InputTiezi;

/**
 * Servlet implementation class deleteServlet
 */
public class xiugaitzServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int Id= Integer.valueOf(request.getParameter("id"));
		//PrintWriter out = response.getWriter();
		//out.print(Id);
		Tiezi tz = new InputTiezi().findid(Id);
		HttpSession session=request.getSession();
		session.setAttribute("tz", tz);
		request.getRequestDispatcher("xiugai.jsp").forward(request, response);
	}

}
