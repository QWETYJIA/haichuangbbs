<%@page import="com.kaohe.beans.Yonghu"%>
<%@page import="com.kaohe.servles.LoginServler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <%
// String Guan=(String)session.getAttribute("gly"); 
 //String Name=(String)session.getAttribute("username");  
// String GL="0";
//if(Name==null)
//{
 %>    <!--  对不起！你没有登录！！！！！！！！！
       <a href="welcome.jsp"target="_top">返回主页面</a><br> -->
 <%// else if( Guan.equals(GL)){ %>
 
 
  <!--
 对不起！你不是管理员！！！！！！！！！
       <a href="welcome.jsp"target="_top">返回主页面</a><br>-->
 <%// else { %>
    <center>
    
                        管理员设置<br>
			<a href="FindServlet?osid=delete"target="main_right">删除帖子</a><br>
			<a href="gerenxgServlet?osid=xiugai"target="main_right">修改帖子</a><br>
			<a href="chayhServlet?osid=chaxun" target="main_right">查询所有的用户</a><br>
			<a href="chaPTServlet?osid=delete"target="main_right">删除用户</a><br>
			<a href="chaPTServlet?osid=xiugai"target="main_right">更改用户权限</a><br>
			<a href="welcome.jsp"target="_top">返回主页面</a><br>
    </center>
    <%   //? %>	
</body>
</html>