<%@page import="com.kaohe.beans.Yonghu"%>
<%@page import="com.kaohe.servles.LoginServler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发表帖子</title>
</head>
<body>
<%
//String Name=(String)session.getAttribute("username");  
//if(Name==null)
//{
 %>
                                     <!--  对不起！你没有登录账号！！！！！！！！！
       <a href="welcome.jsp"target="_top">返回主页面</a><br> -->
 <%//} else { %>
	<center>
		<form action="${pageContext.request.contextPath }/FabiaoServlet" method="post">
			<table bgColor="#c0c0c0">
				<tr>
					<td align="center" bgcolor=Skyblue colspan=5><font color=white><h1>发帖子</h1></font></td>
				</tr>
				<tr>
					<td><h2>标题：</h2></td>
					<td><input type="text" size=60 name="title"></td>
				</tr>
			<tr>
					<td><h2>发布者：</h2></td>
					
				</tr>
				<tr valign="top">
					<td><h2>内容：</h2></td>
					<td><textarea rows=20 cols=60 name="neirong"></textarea></td>
				</tr>
				<tr ><td align="center" colspan="1" ><input type="submit"  value="提交">		
			</table>
			
		</form>
	</center><%//？%>	
</body>
</html>