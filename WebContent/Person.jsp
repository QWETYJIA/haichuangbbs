<%@page import="com.kaohe.beans.Yonghu"%>
<%@page import="com.kaohe.servles.LoginServler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>用户个人界面</title>
</head>

<body>
   <%
   String Name=(String)session.getAttribute("username");  
if(Name==null)
{
 %>
                                     对不起！你没有登录账号！！！！！！！！！
       <a href="welcome.jsp"target="_top">返回主页面</a><br>
 <%} else { %>
      
        <%
        
        String name=(String)session.getAttribute("username");   
        %>
        <center>
                       用户名<%=name %><br>
			<a href="gerenscServlet?osid=delete"target="main_right">删除帖子</a><br>
			<a href="gerenxgServlet?osid=xiugai"target="main_right">修改帖子</a><br>
			<a href="fabiao.jsp" target="main_right">发表帖子</a><br>
			<a href="gerenckServlet?osid=query"target="main_right">查询帖子</a><br>
			<a href="welcome.jsp"target="_top">返回主页面</a><br>
	</center>
		 <%} %>	
</body>
</html>