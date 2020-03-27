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
 * Servlet implementation class gerenscServlet
 */
public class gerenscServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int currPage = 1;
		// �жϴ���ҳ���Ƿ���Ч
		if(request.getParameter("page") != null){
			// �Ե�ǰҳ�븳ֵ
			currPage = Integer.parseInt(request.getParameter("page"));
		}
		String osid=request.getParameter("osid");
		   Chakan tz = new Chakan();
		   HttpSession session=request.getSession();
		   String name=(String) session.getAttribute("username");
			List<Tiezi> list = tz.findP(currPage,name);
			// ��list���õ�request֮��
			request.setAttribute("list", list);
			// ��ҳ��
			int pages ;
			// ��ѯ�ܼ�¼��
			int count = tz.findCount(name);
			// ������ҳ��
			if(count % Tiezi.PAGE_SIZE == 0){
				// ����ҳ����ֵ
				pages = count / Tiezi.PAGE_SIZE;
			}else{
				// ����ҳ����ֵ
				pages = count / Tiezi.PAGE_SIZE + 1;
			}
			// ʵ����StringBuffer
			StringBuffer sb = new StringBuffer();
			// ͨ��ѭ��������ҳ��
			for(int i=1; i <= pages; i++){
				// �ж��Ƿ�Ϊ��ǰҳ
				if(i == currPage){
					// ������ҳ��
					sb.append("��" + i + "��");
				}else{
					// ������ҳ��
					sb.append("<a href='gerenscServlet?page=" + i + "'>" + i + "</a>");
				}
				// ������ҳ��
				sb.append("��");
			}
			// ����ҳ�����ַ������õ�request֮��
			request.setAttribute("bar", sb.toString());
			// ת����product_list.jspҳ��
			//request.getRequestDispatcher("fenye.jsp").forward(request, response);
		


	

		// if(osid.equals("query")) {
			//   request.getRequestDispatcher("tiezi_list.jsp").forward(request, response);
	// else if(osid.equals("xiugai"))
	//	  request.getRequestDispatcher("xiugaitz.jsp").forward(request, response);
	//	else
request.getRequestDispatcher("deletege.jsp").forward(request, response);
			

		   
	}
}
