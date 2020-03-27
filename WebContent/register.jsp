<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    //为用户名文本框添加这个方法，在文本框失去焦点以后运行
    //就是当用户填写完用户名后，进行下一步填写的时候，异步执行这个方法
    function checkUsername(){
        //获取用户名文本框对象
        var username = document.getElementsByName("username")[0].value;
        //获取提示信息span对象
        var span1 = document.getElementsByTagName("span")[0];
        if(username == ""){
            span1.innerHTML = "用户名不能为空！";
            return;
        }
        
        //创建请求对象
        var xmlHttp = new XMLHttpRequest();
        
        //设置请求状态变化时触发的事件
        xmlHttp.onreadystatechange = function(){
            //如果请求状态码为4，说明请求已经完成，响应已经就绪
            if(xmlHttp.readyState == 4){
                //响应状态码为200，响应完成
                if(xmlHttp.status == 200){
                    //获取服务器返回的信息
                    var data = xmlHttp.responseText;
                    //判断返回的信息，输出响应的提示信息
                    if(data == 0){
                        //如果返回0，说明用户名不重复，可以使用
                        span1.innerHTML = "用户名可以使用！";
                    }else{
                        //说明用户名重复，不能使用
                        span1.innerHTML = "用户名已经被注册！";
                    }
                }
            }
        }
            //创建连接
            xmlHttp.open("GET","${pageContext.request.contextPath }/RegisterAJAXServlet?username="+username,true);
            
            //发送请求
            xmlHttp.send();
        
    }
</script>
	</head>
<body>
<center>

${results }<br>
 <form action="${pageContext.request.contextPath }/RegisterServler" method="post">
         账号：<input type="text" name="username"  onblur="checkUsername();"/><span></span>
         <br/>
     用户名：<input type="text" name="name"/><br>
         密码：<input type="password" name="password"/><br>${result }
         管理员：<input type="radio" name="gl" checked value="1">是&nbsp;&nbsp;
						<input type="radio" name="gl" value="0">否
       <input type="submit" value="注册"/>
 </form>
  </center> 
</body>
</html>