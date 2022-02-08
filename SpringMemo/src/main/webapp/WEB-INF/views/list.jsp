<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<%@ include file="/inc/asset.jsp"%>
	<style>
		.container {
			width: 600px;
		}
	</style>
</head>
<body>
	<!--  -->
	<div class="container">

		<%@ include file="/inc/header.jsp"%>
		
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>메모</th>
				<th>이름</th>
				<th>날짜</th>
				<th>조작</th>
			</tr>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.seq}</td>
				<td>${dto.memo}</td>
				<td>${dto.name}</td>
				<td>${dto.regdate}</td>
				<td>
					<input type="button" value="E" class="btn btn-default btn-xs" onclick="location.href='/memo/edit.do?seq=${dto.seq}'">
					<input type="button" value="D" class="btn btn-default btn-xs" onclick="location.href='/memo/delok.do?seq=${dto.seq}'">
				</td>
			</tr>
			</c:forEach>
		</table>
		
		<hr>

		<div>
			<input type="button" value="메모쓰기" class="btn btn-default" onclick="location.href='/memo/add.do'">
		</div>
		
	</div>

	<script>
   
   </script>
</body>
</html>
