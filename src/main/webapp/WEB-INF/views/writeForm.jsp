<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<h2>게시판 글쓰기</h2>
	<hr>
	
	<form action="writeOk">
		제목 <br><input type="text" name="btitle"> <br>
		내용<br><textarea rows="10" cols="45"></textarea><br>
		글쓴이<br> <input type="text" name="bname"><br>
		조회수<br> <input type="text" name="bhit"><br>
		<input type="submit" value="글쓰기">
		<input type="button" value="취소" onclick="javascript:window.location.href='boardlist'">
	</form>
</body>
</html>