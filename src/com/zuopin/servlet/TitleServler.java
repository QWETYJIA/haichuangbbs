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
 * Servlet implementation class TitleServler
 */
public class TitleServler extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	//	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		//		throws ServletException, IOException {
			int currPage = 1;
			// 判断传递页码是否有效
			if(request.getParameter("page") != null){
				// 对当前页码赋值
				currPage = Integer.parseInt(request.getParameter("page"));
			}
			String osid=request.getParameter("osid");   
			   HttpSession session=request.getSession();
			   String title=(String) session.getAttribute("Title");
			 response.setCharacterEncoding("GB18030");
					request.setCharacterEncoding("UTF-8");
					Chakan tz = new Chakan();
				List<Tiezi> list = tz.findT(currPage,title);
				// 将list放置到request之中
				request.setAttribute("list", list);
				// 总页数
				int pages ;
				// 查询总记录数
				int count = tz.findCountt(title);
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
						sb.append("<a href='TitleServler?page=" + i + "'>" + i + "</a>");
					}
					// 构建分页条
					sb.append("　");
				}
				// 将分页条的字符串放置到request之中
				request.setAttribute("bar", sb.toString());
				// 转发到product_list.jsp页面
				//request.getRequestDispatcher("fenye.jsp").forward(request, response);
			


		

			 //  if(osid.equals("query")) {
				   request.getRequestDispatcher("tiezi_list.jsp").forward(request, response);//}
			//   else if(osid.equals("xiugai"))
			//	   request.getRequestDispatcher("xiugaitz.jsp").forward(request, response);
			//else
		//response.setCharacterEncoding("GB18030");
	//	HttpSession session = request.getSession();
	//	request.setCharacterEncoding("UTF-8");
	//	String name = request.getParameter("name");
		//   Chakan tz = new Chakan();
		//<Tiezi> list =tz.findn(name);
		//   request.setAttribute("list", list);
		  
			//   request.getRequestDispatcher("tiezi_list.jsp").forward(request, response);}
		  

				
	}
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		   doPost(request, response);
	   }
}

	

