<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
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
        .index-panel{
            width: 400px;
            height: 300px;
            background-image: url('images/04.jpg');
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
      <div class="index-panel">
           <div  style="font-size:40px;text-align:center">欢迎您的使用</div>
           <div style="font-size:30px;text-align:center">  <a href="add.jsp">记账</a><br/> </div>
           <div style="font-size:30px;text-align:center"> <a href="QueryAllBillServlet">查看全部账目</a> </div>
           <div style="font-size:30px;text-align:center"> <a href="screen.jsp">按日期与类型查看账目</a> </div>
            <div style="font-size:30px;text-align:center"> <a href="screentype.jsp">按账目类型查看账目</a> </div>
            <div style="font-size:30px;text-align:center"> <a href="screendate.jsp">按日期查看账目</a> </div>
      </div>
      </div>
</body>
</html>