<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
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
        .register-panel{
            width: 400px;
            height: 250px;
            background-image: url('images/03.jpg');
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
	          alert("该用户名已被使用，请重试");
	     </script>
	     <%
      }else if(message.equals("noerror")){
    	  %>
     	 <script type="text/javascript">
	          alert("注册成功");
	     </script>
	     <%
      }else{
      }
      }
      %>
 <div class="outer-wrap">
    
    <div style="font-size:160px;text-align:center">家庭记账本</div>
    <div class="register-panel">
    <div style="font-size:40px;text-align:center">注册界面</div>
    <form action="RegisterServlet" method="post">
    <div style="text-align:center">
    用户名<input type="text" style="width:300px;height:30px;text-align:center" name="uname"><br/>
    </div>
    <div style="text-align:center">
    密&nbsp&nbsp&nbsp码<input type="text" style="width:300px;height:30px;text-align:center" name="upwd"><br/>
    </div>
    <div style="text-align:center">
    <label>
                          性别<input type="radio" name="usex" value="男" checked> 男
             </label>
             <label>
             <input type="radio" name="usex" value="女" checked> 女
             </label>
    </div>
    <div style="text-align:center">   <input type="submit"  value="注册"><br/></div>
    <div style="text-align:center">  <a href="login.jsp" >已有账号，立即去登录</a>  </div>
    </form>
    </div>
    </div>
</body>
</html>