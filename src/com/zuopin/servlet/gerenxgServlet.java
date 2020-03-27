package com.zuopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zuopin.beans.Tiezi;
import com.zuopin.service.Chakan;

/**
 * Servlet implementation class gerenxgServlet
 */
public class gerenxgServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int currPage = 1;
		// 判断传递页码是否有效
		if(request.getParameter("page") != null){
			// 对当前页码赋值
			currPage = Integer.parseInt(request.getParameter("page"));
		}
		String osid=request.getParameter("osid");
		   Chakan tz = new Chakan();
		   HttpSession session=request.getSession();
		   String name=(String) session.getAttribute("username");
			List<Tiezi> list = tz.findP(currPage,name);
			// 将list放置到request之中
			request.setAttribute("list", list);
			// 总页数
			int pages ;
			// 查询总记录数
			int count = tz.findCount(name);
			// 计算总页数
			if(count % Tiezi.PAGE_SIZE == 0){
				// 对总页数赋值
				pages = count / Tiezi.PAGE_SIZE;
			}else{
				// 对总页数赋值
				pages = count / Tiezi.PAGE_SIZE + 1;
			}
			// 实例化StringBuffer
			StringBuffer sb = new StringBuffer();
			// 通过循环构建分页条
			for(int i=1; i <= pages; i++){
				// 判断是否为当前页
				if(i == currPage){
					// 构建分页条
					sb.append("『" + i + "』");
				}else{
					// 构建分页条
					sb.append("<a href='gerenxgServlet?page=" + i + "'>" + i + "</a>");
				}
				// 构建分页条
				sb.append("　");
			}
			// 将分页条的字符串放置到request之中
			request.setAttribute("bar", sb.toString());
			// 转发到product_list.jsp页面
			//request.getRequestDispatcher("fenye.jsp").forward(request, response);
		


	

		// if(osid.equals("query")) {
			//   request.getRequestDispatcher("tiezi_list.jsp").forward(request, response);
	// else if(osid.equals("xiugai"))
		  request.getRequestDispatcher("xiugaitz.jsp").forward(request, response);
	//	else
//request.getRequestDispatcher("deletege.jsp").forward(request, response);
			

		   
	}
}
