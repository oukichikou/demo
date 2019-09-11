<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form action="insert" method="post">
<input name="id">
<input name="name">
<input type="submit">
</form>
<c:forEach items="${list}" var="a">
	${a.name}<br>
</c:forEach>
</body>
</html>