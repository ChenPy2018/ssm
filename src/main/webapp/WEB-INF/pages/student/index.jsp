<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		margin:0px;
		padding:0px;
	}
	ul{
		margin-left:2px;
	}
	ul li{
		list-style: none;
		float:left;
		margin:5px;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<form method="post">
		name:<input  name="sname" value="${name }"><input type="submit" >
	</form>
  <table>
  	<thead>
  		<tr>
  			<th>编号</th>
  			<th>姓名</th>
  			<th>年龄</th>
  			<th>性别</th>
  			<th>系别</th>
  		</tr>
  	</thead>
  	<tbody>
  		<c:forEach items="${student }" var="t">
	  		<tr>
	  			<td>${t.sno}</td>
	  			<td>${t.sname}</td>
	  			<td>${t.sage}</td>
	  			<td>${t.ssex}</td>
	  			<td>${t.dept}</td>
	  		</tr>
  		</c:forEach>
  	</tbody>
  </table>
	  <ul>
	  	<li><a href="list.do?pageNo=1">首页</a></li>
	  	<li><a href="list.do?pageNo=1">上一页</a></li>
	  	<li><a href="list.do?pageNo=1">第1页</a></li>
	  	<li><a href="list.do?pageNo=2">第2页</a></li>
	  	<li><a href="list.do?pageNo=3">第3页</a></li>
	  	<li><a href="list.do?pageNo=1">下一页</a></li>
	  	<li><a href="list.do?pageNo=3">尾页</a></li>
	  </ul>
</body>
</html>