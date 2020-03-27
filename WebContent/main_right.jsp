<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/chaxun" method="post">
       查询帖子相关内容的标题：<input type="text" size=10 name="title"> 
        <input type="submit" value="搜索"/>  
 </form>
 
 <br>
 
 <form action="${pageContext.request.contextPath }/chaxun" method="post">
       查询帖子相关内容的发布者：<input type="text" size=10 name="name">

       <input type="submit" value="查询"/> 
 </form>
</body>
</html>