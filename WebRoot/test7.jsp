<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   

  </head>
  
  <body>
    <h1> 用户登录</h1>
    <hr>
    <form action="/jzfp/jzfpmzcxservlet" name="login" method="get"  >
   <table>
   <tr>
   <td> kssj：</td>
   <td><input type="text" name="kssj" ></td>
   </tr>
   <tr>
   <td> jssj：</td>
   <td><input type="text" name="jssj" ></td>
   </tr>
 
   <tr>
   <td  >提交：</td><td><input type="submit" name="提交"></td>
   </tr>
   </table>
</form>
  </body>
</html>