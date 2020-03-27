<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
  <body>
  <br><br>
  <center><%
        String name=(String)session.getAttribute("username");   
        %>
        <a href="Person.jsp" target="main_left">用户名<%=name %><br></a>
        <a href="fabiao.jsp" target="main_right">发表帖子</a><br>
        <a href="main_right.jsp" target="main_right">搜索帖子</a><br>
        
        <a href="fenyeServlet"target="main_right">所有帖子</a><br>
         <a href="guanliyuan.jsp" target="main_left">管理员界面</a><br>
        <a href="tuichuServlet" target="_top">注销登录退出</a><br>
        </center>
   
  </body>
</html>