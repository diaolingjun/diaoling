<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加信息</title>
<script>
</script>
</head>
<body>
<%
         Object message = request.getAttribute("message");
         if(message!=null && !"".equals(message)){
     
    %>
         <script type="text/javascript">
              alert("<%=request.getAttribute("message")%>");
         </script>
    <%} %>
  <table align="center" border="0px" cellpadding="10px" cellspacing="10px">
  <form action="xuankeServlet?method=addstu"  method="post"  onsubmit="return check()">
  <tr>
  <td><a href="index.jsp">返回菜单</a></td>
  </tr>
   <tr>
    <td>技术名称:</td>
    <td><input type="text" name="spid" id="spid"></td>
   </tr>
   <tr>
   <td>重大科技需求概述：</td>
   <td><input type="text" name="stuname" id="stuname"></td>
   </tr>
   <tr>
   <td>研究类型</td>
   <td>
   <select name="sex">
   <option value="基础研究">基础研究</option>
   <option value="应用研究">应用研究</option>
   <option value="实验发展">实验发展</option>
   <option value="研究发展与成果应用">研究发展与成果应用</option>
   <option value="技术推广与科技服务">技术推广与科技服务</option>

    </select>
   </td>
   </tr>
   <tr>
   <td>技术需求</td>
   <td>
   <select name="sex">
   <option value="独立开发">独立开发</option>
   <option value="技术转让">技术转让</option>
   

    </select>
   </td>
   </tr>
   <tr>
   <td>合作模式</td>
   <td>
   <select name="sex">
   <option value="技术入股">技术入股</option>
   <option value="合作开发">合作开发</option>
  

    </select>
   </td>
   </tr>
   <tr>
   <td>计划总投资</td>
   <td><input type="text" name="banji" id="banji"></td>
   </tr>
  
 
    <tr align="center">
    <th colspan="2">
    <input type="submit" value="提交">
    </th>
    </tr>
    </form>
</table>
</body>
</html>