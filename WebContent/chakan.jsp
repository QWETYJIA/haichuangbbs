<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="com.zuopin.beans.Tiezi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<%
		Tiezi tz =(Tiezi) session.getAttribute("tz");
	%>
	<center>
		<%//action="${pageContext.request.contextPath }/chakantzServlet" method="post">
 %> 			<table bgColor="#c0c0c0">
				<tr>
					<td align="center" bgcolor=Skyblue colspan=5><font color=white><h1>发帖子</h1></font></td>
				</tr>
				<tr>
					<td><h2>标题：<%=tz.getTitle()%></h2></td>

				</tr>
			<tr>
					<td><h2>发布者：<%=tz.getName()%></h2></td>
					
</div></td>
				</tr>
				<tr valign="top"><
					<td><h2>内容：<%=tz.getNeirong()%></h2></td>
					
</div></td>
				</tr>
					
			</table>
			
		
	</center>
</body>
</html>

</body>
</html>