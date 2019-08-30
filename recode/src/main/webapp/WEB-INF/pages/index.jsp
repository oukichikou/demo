<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form action="index1" method="post">
	<input name="name">
	<button type="submit">查询</button>
</form> 
<table>
<tr><td>名称</td></tr>
 <c:forEach items="${list}" var="row">
 <tr><td>${row.name}</td></tr>
 </c:forEach>
</table>

</body>
</html>