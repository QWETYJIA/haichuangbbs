package com.kaohe.servles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaohe.beans.Yonghu;
import com.kaohe.service.yonghuService;

/**
 * Servlet implementation class chaPTServlet
 */
public class chaPTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		String osid=request.getParameter("osid");
	//	IYonghuService service = new YonghuServiceImpl();
		yonghuService service=new yonghuService();
		Yonghu yonghu =new Yonghu();
		String gl="0";
		List<Yonghu> list =service.findGl(gl);
		request.setAttribute("list", list);
		   if(osid.equals("delete"))
		   request.getRequestDispatcher("deleteyh.jsp").forward(request, response);
			else if(osid.equals("xiugai"))
				   request.getRequestDispatcher("xiugaiyh.jsp").forward(request, response);
		
	   
	}

}
