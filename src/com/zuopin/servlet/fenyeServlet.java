package com.zuopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuopin.beans.Tiezi;
import com.zuopin.service.InputTiezi;

public class fenyeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currPage = 1;
		// �жϴ���ҳ���Ƿ���Ч
		if(request.getParameter("page") != null){
			// �Ե�ǰҳ�븳ֵ
			currPage = Integer.parseInt(request.getParameter("page"));
		}
		// ʵ����ProductDao
		InputTiezi tz = new InputTiezi();		// ��ѯ������Ʒ��Ϣ
		List<Tiezi> list = tz.findP(currPage);
		// ��list���õ�request֮��
		request.setAttribute("list", list);
		// ��ҳ��
		int pages ;
		// ��ѯ�ܼ�¼��
		int count = tz.findCount();
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
				sb.append("<a href='fenyeServlet?page=" + i + "'>" + i + "</a>");
			}
			// ������ҳ��
			sb.append("��");
		}
		// ����ҳ�����ַ������õ�request֮��
		request.setAttribute("bar", sb.toString());
		// ת����product_list.jspҳ��
		request.getRequestDispatcher("fenye.jsp").forward(request, response);
	}


}