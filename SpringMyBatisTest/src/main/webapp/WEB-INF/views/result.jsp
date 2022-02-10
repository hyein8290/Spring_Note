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
<style>
</style>
</head>
<body>
	<!--  -->
	<div class="container">
		<h1 class="page-header">
			MyBatis<small>결과</small>
		</h1>

		<h2>m2, m3, m4</h2>
		<div>${result}</div>

		<h2>m5</h2>
		<div>count: ${count}</div>

		<h2>m6</h2>
		<div>dto: ${dto}</div>

		<h2>m7</h2>
		<c:forEach items="${memo}" var="content">
			<div>${content}</div>
		</c:forEach>

		<h2>m8, m9</h2>
		<c:forEach items="${list}" var="dto">
			<div>${dto.seq}.${dto.memo}(${dto.name}))</div>
		</c:forEach>

	</div>

	<script>
   
   </script>
</body>
</html>
