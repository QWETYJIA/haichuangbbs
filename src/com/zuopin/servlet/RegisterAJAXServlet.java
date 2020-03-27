package com.zuopin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaohe.beans.Yonghu;
import com.kaohe.service.yonghuService;

/**
 * Servlet implementation class RegisterAJAXServlet
 */
public class RegisterAJAXServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ȡ���������
        PrintWriter out = response.getWriter();
        
        //��ȡ���ύ������
        String username = request.getParameter("username");

        //�����ݴ���service�����߼��ж�
        yonghuService service = new yonghuService();
        Yonghu yonghu = service.checkUsername(username);
        
        //AJAX��ʽ
        if(yonghu==null){
            //�������true��˵���û���û�б�����������ע��,����0
            out.println(0);
        }else{
            //�û����Ѿ���ע�ᣬ����1
            out.println(1);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}