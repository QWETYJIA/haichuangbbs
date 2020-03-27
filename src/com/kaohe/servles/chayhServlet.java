package com.kaohe.servles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaohe.beans.Yonghu;
import com.kaohe.service.IYonghuService;
import com.kaohe.service.YonghuServiceImpl;
import com.kaohe.service.yonghuService;
import com.zuopin.beans.Tiezi;

/**
 * Servlet implementation class chayhServlet
 */
public class chayhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		String osid=request.getParameter("osid");
	//	IYonghuService service = new YonghuServiceImpl();
		yonghuService service=new yonghuService();
		List<Yonghu> list =service.find();
		request.setAttribute("list", list);
		   if(osid.equals("chaxun"))
		   request.getRequestDispatcher("yh_list.jsp").forward(request, response);
			else if(osid.equals("xiugai"))
				   request.getRequestDispatcher("xiugaiyh.jsp").forward(request, response);
		
	   
	}

}
