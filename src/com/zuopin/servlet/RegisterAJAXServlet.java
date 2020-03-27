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
        //获取输出流对象
        PrintWriter out = response.getWriter();
        
        //获取表单提交的数据
        String username = request.getParameter("username");

        //将数据传入service进行逻辑判断
        yonghuService service = new yonghuService();
        Yonghu yonghu = service.checkUsername(username);
        
        //AJAX方式
        if(yonghu==null){
            //如果返回true，说明用户名没有被创建，可以注册,返回0
            out.println(0);
        }else{
            //用户名已经被注册，返回1
            out.println(1);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}