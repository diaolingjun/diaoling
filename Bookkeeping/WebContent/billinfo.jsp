<%@page import="com.zzw.entity.Bill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
        .info-panel{
            width: 400px;
            height: 300px;
            background-image: url('images/05.jpg');
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
	          alert("操作失败");
	     </script>
	     <%
      }else if(message.equals("noerror")){
    	  %>
     	 <script type="text/javascript">
	          alert("操作成功");
	     </script>
	     <%
      }else{
      }
      }
      %>
<div class="outer-wrap">
      <div style="font-size:160px;text-align:center">家庭记账本</div>
      <div class="info-panel">
         <%
       Bill bill= (Bill)request.getAttribute("bill");
    %>
    <a href=index.jsp>返回系统首页</a><br>
    <form action="UpdateBillServlet">
    <div style="text-align:center">
             账目编号<input type="text" name="bid"  value="<%=bill.getBid() %>" readonly="readonly">
    </div>
        <div style="text-align:center">
             账目类型<input type="text" name="btype"  value="<%=bill.getBtype() %>" readonly="readonly">
    </div>
    <div style="text-align:center">
     金额<input type="text"  name="bmoney" value="<%=bill.getBmoney()%>"><br/>
    </div>
    <div style="text-align:center">
     日期<input type="date"  name="bdate" value="<%=bill.getBdate()%>"><br/>
    </div>
    <div style="text-align:center">
     备注<input type="text"  name="bremark" value="<%=bill.getBremark()%>"><br/>
    </div>
    <div style="text-align:center">
      <input type="submit" value="修改"><br/>
    </div>
    </form>
      </div>
      </div>
</body>
</html>