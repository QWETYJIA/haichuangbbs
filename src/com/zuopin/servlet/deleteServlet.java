package com.zuopin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuopin.service.InputTiezi;

/**
 * Servlet implementation class deleteServlet
 */
public class deleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int Id= Integer.valueOf(request.getParameter("id"));
		InputTiezi tz = new InputTiezi();
		tz.delete(Id);
		response.sendRedirect("FindServlet?osid=delete");

	}

}
