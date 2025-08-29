<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h2>게시판 목록</h2>
	<hr>
	
	글 번호 / 글    제    목 / 글 쓴 이 / 조회수 / 등 록 일 <br> <br>
	
	<c:forEach items="${boardDtos}" var="bDto">
		${bDto.bnum} / ${bDto.btitle} / ${bDto.bcontent} / ${bDto.bname} / ${bDto.bhit} / ${bDto.bdate} <br>
	</c:forEach>
	
	<hr>
	
	<input type="button" value="글쓰기" onclick="javascript:window.location.href='writeForm'">
	
	<input type="button" value="글삭제" onclick="javascript:window.location.href='deleteForm'"> 
</body>
</html>