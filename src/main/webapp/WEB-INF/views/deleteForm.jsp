<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
</head>
<body>
	<h2>글삭제</h2>
	<hr>
	<form action="deleteOk">
		글 번호 : <input type="text" name="bnum">
		<input type="submit" value="삭제">
	</form>
	 <hr>
	 <c:if test="${not empty error}">
	 	<h3 style="color: red;"> 해당 글 번호는 존재하지 않습니다.</h3>
	 </c:if>
</body>
</html>