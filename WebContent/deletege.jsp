<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="com.zuopin.beans.Tiezi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>只删除个人的帖子</title>
<style type="text/css">
	td{font-size: 12px;}
	h2{margin: 0px}
</style>
</head>
<body>
	<table align="center" width="450" border="1" height="180" bordercolor="white" bgcolor="white" cellpadding="1" cellspacing="1">
		<tr bgcolor="white">
			<td align="center" colspan="5">
				<h2>所有的帖子信息</h2>
			</td>
		</tr>
		<tr align="center" bgcolor="#e1ffc1" >
			<td><b>ID</b></td>
			<td><b>题目</b></td>
			<td><b>作者</b></td>
			<td><b>时间</b></td>
			<td><b>选择</b></td>
			
			
		</tr>
			<%
				// 获取图书信息集合
						List<Tiezi> list = (List<Tiezi>)request.getAttribute("list");
						// 判断集合是否有效
					if(list == null || list.size() < 1){
							out.print("没有数据！");}
					else{
							//遍历图书集合中的数据
							for(Tiezi s : list){
			%>
				<tr align="center" bgcolor="white">
					<td><%=s.getId()%></td>
					<td><%=s.getTitle()%></td>
					<td><%=s.getName()%></td>
					<td><%=s.getTime()%></td>
		<td><a href="deletegrServlet?id=<%=s.getId()%>">删除</a></td>
					
				</tr>
			<%
							}}
				
			%>
				<td align="center" colspan="6">
		
		
		<%=request.getAttribute("bar")%>
		</td>
		
	</table>
</body>
</html>