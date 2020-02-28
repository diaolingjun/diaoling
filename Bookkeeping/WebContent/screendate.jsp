<%@page import="com.zzw.entity.Bill"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>按日期查询账目</title>
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
        .screen-panel{
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
      <div class="screen-panel">
      <a href=index.jsp>返回系统首页</a><br>
      <form action="QueryDateServlet" method="post" onsubmit="return checkName()">
      
    <div style="text-align:center;color:yellow">
     日期<input type="date"  name="bdate"><br/>
    </div>
   <div style="text-align:center;color:yellow">
     <input type="submit" class="btn btn-primary" value="查询"><br/>
    </div>
    </form>
<script src="jquery-3.4.1.min.js"></script>
    <script>
        function checkName() {
            var date = document.getElementById("bdate");
            if (date.value==null||date.value == "") {
                alert("请选择日期");
                return false;
            }
            return true;
        }
    </script>
          <table border="1px">
         <tr>
         <th>账目编号</th>
         <th>账目类型</th>
         <th>金额</th>
         <th>账目日期</th>
         </tr>
         <%
         List <Bill> bills =(List<Bill>) request.getAttribute("bills");
         if(bills!=null){
           for(Bill bill:bills){
        	   %>
        	   
        	   <tr>        	       
        	       <td><%=bill.getBid() %></td>
        	       <td><%=bill.getBtype() %></td>
        	       <td><%=bill.getBmoney() %></td>
        	       <td><%=bill.getBdate() %></td>
        	       <td><a href ="DeleteBillServlet?bid=<%=bill.getBid() %>">删除</a></td>
        	       <td><a href="QueryBillServlet?bid=<%=bill.getBid() %>">查询</a></td>
        	   </tr>
        	   <%
           }
         }
         %>
      </table>
      </div>
      </div>
</body>
</html>