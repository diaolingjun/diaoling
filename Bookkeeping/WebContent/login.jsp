<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
    <style type="text/css">
        *{margin: 0;padding: 0}
        html,body{height: 100%}     /*这里很关键*/
 
        .outer-wrap{
            /*只有同时为html和body设置height: 100%时，这里的height才生效，
            并且随浏览器窗口变化始终保持和浏览器视窗等高*/
            height: 100%;    
            position: relative;
            background-image: url('images/01.jpg');
        }
        .login-panel{
            width: 400px;
            height: 200px;
            background-image: url('images/02.jpg');
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -150px;
            margin-left: -200px;
        }
    </style>
<body>
<%
         request.setCharacterEncoding("utf-8");
         String message=(String)request.getAttribute("message");
         if(message!=null){
         if(message.equals("error")){
        	 %>
        	 <script type="text/javascript">
	          alert("用户名或密码错误");
	     </script>
	     <%
      }else if(message.equals("noerror")){
    	  %>
     	 <script type="text/javascript">
	          alert("登录成功");
	     </script>
	     <%
      }else{
      }
      }
      %>
    <div class="outer-wrap">
    
    <div style="font-size:160px;text-align:center">家庭记账本</div>
    <div class="login-panel">
    <div style="font-size:40px;text-align:center">登陆界面</div>
        <form action="LoginServlet" method="post" >
         用户名<input type="text" style="width:300px;height:30px;text-align:center" name="uname"><br/>
         密&nbsp&nbsp&nbsp码<input style="width:300px;height:30px;text-align:center"type="password" name="upwd"><br/>
      <div style="text-align:center">   <input type="submit"  value="登录"><br/></div>
      <div style="text-align:center">  <a href="register.jsp" >没有账号，立即去注册</a>  </div>
        </form>
    </div>
    </div>
</body>
</html>