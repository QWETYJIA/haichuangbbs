<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript">
		function reloadCode(){
			var time = new Date().getTime();
			document.getElementById("imagecode").src="${pageContext.request.contextPath }/ImageServlet?d="+time;
		}
	</script>
</head>
<body>

${message }<br>
 <form action="${pageContext.request.contextPath }/LoginServler" method="post">
       账&nbsp;号：<input type="text" name="username"/><br><br>
       密&nbsp;码：<input type="password" name="password"/><br><br>
       验证码：<input type="text" name="checkcode"/>
    <img alt="验证码" id="imagecode" src="${pageContext.request.contextPath }/ImageServlet"/>
    <a href="javascript: reloadCode();">看不清楚</a><br><br>
    
       管理员：<input type="radio" name="gl" checked value="1">是&nbsp;&nbsp;
						<input type="radio" name="gl" value="0">否<br><br>
    <input type="submit" value="登录"/> 
 </form>
 &nbsp;  <a href="${pageContext.request.contextPath }/register.jsp">新用户注册</a>&nbsp;&nbsp;&nbsp;
   <a href=welcome.jsp>游客身份进入</a>
 
</body>
</html>