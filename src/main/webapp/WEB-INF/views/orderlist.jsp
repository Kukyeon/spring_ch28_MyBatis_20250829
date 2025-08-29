<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 리스트</title>
</head>
<body>
	<h2>주문 리스트</h2>
	<hr>
	<c:forEach items="${userOrderDtos}" var="oDto">
		주문 번호 : ${oDto.orderid} <br>
		주문 상품 : ${oDto.ordername} <br>
		<hr>
	</c:forEach>
</body>
</html>