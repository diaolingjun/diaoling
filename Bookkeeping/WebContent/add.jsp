<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>记账</title>
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
        .add-panel{
            width: 400px;
            height: 300px;
            background-image: url('images/06.jpg');
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
	          alert("添加失败");
	     </script>
	     <%
      }else if(message.equals("noerror")){
    	  %>
     	 <script type="text/javascript">
	          alert("添加成功");
	     </script>
	     <%
      }else{
      }
      }
         
      %>
      
<div class="outer-wrap">
      <div style="font-size:160px;text-align:center">家庭记账本</div>
      <div class="add-panel">
      <a href=index.jsp>返回系统首页</a><br>
      <div style="text-align:center;color:yellow">请输入要添加的账目信息：</div><br/>
      <form action="AddBillServlet" method="post">
      
    <div style="text-align:center;color:yellow">
             账目类型<select id="btype" name="btype">
			<option value="饮食">饮食</option>
			<option value="教育">教育</option>
			<option value="购物">购物</option>
			<option value="医疗">医疗</option>
			<option value="收入">收入</option>
			<option value="借贷">借贷</option>
			<option value="其它">其它</option>
		</select>
    </div>
    <div style="text-align:center;color:red">注：借贷和其它类型的账目不计入收支</div>
    <div style="text-align:center;color:yellow">
     金额<input type="text"  name="bmoney"><br/>
    </div>
    <div style="text-align:center;color:yellow">
     日期<input type="date"  name="bdate"><br/>
    </div>
    <div style="text-align:center;color:yellow">
     备注<input type="text"  name="bremark"><br/>
    </div>
    <div style="text-align:center;color:yellow">
     <input type="submit"  value="添加"><br/>
    </div>
    </form>
      </div>
      </div>
</body>
</html>