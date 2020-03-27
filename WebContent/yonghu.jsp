<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="com.kaohe.beans.Yonghu"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
  <%

		Yonghu tz =(Yonghu) session.getAttribute("tz");
	%>
	<center>
		<form action="${pageContext.request.contextPath }/xiuyhServlet" method="post">
			<table bgColor="#c0c0c0">
				<tr>
					<td align="center" bgcolor=Skyblue colspan=5><font color=white><h1>修改用户身份</h1></font></td>
				</tr>
				<tr>
					<td><h2>用户名：<%=tz.getName()%></h2></td>
					
				
				</tr>
			<tr>
				
				</tr>
				<tr valign="top">
		<td><h2>管理员：</h2></td><td><input type="radio" name="gl" <%if (tz.getGl() == "1") {%>
					checked <%}%> value="1">是&nbsp;&nbsp; <input type="radio"
					name="gl" <%if (tz.getGl() == "0") {%> checked <%}%> value="0">否</td>
				</tr>
				<tr ><td align="center" colspan="1" ><input type="hidden"name="id"value="<%=tz.getId()%>" >
				<input type="submit"  value="提交">		
			</table>
			
		</form>
	</center>
</body>
</html>