<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="com.zuopin.beans.Tiezi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
  <%
  String name=(String) session.getAttribute("username");
		Tiezi tz =(Tiezi) session.getAttribute("tz");
	%>
	<center>
		<form action="${pageContext.request.contextPath }/XiugaiServlet" method="post">
			<table bgColor="#c0c0c0">
				<tr>
					<td align="center" bgcolor=Skyblue colspan=5><font color=white><h1>发帖子</h1></font></td>
				</tr>
				<tr>
					<td><h2>标题：</h2></td>
					<td><input type="text" size=60 name="title"
					value="<%=tz.getTitle()%>"></td>
				</tr>
			<tr>
					<td><h2>发布者：</h2></td>
					<td><%=name%></td>
				</tr>
				<tr valign="top">
					<td><h2>内容：</h2></td>
					<td><textarea rows=3 cols=20 name="neirong"><%=tz.getNeirong()%></textarea></td>
				</tr>
				<tr ><td align="center" colspan="1" ><input type="hidden"name="id"value="<%=tz.getId()%>" >
				<input type="submit"  value="提交">		
			</table>
			
		</form>
	</center>
</body>
</html>