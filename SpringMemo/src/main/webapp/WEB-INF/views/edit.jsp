<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Document</title>
   <%@ include file="/inc/asset.jsp" %>
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
		
		<form method="POST" action="/memo/editok.do">
		<table class="table table-bordered">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" class="form-control" required value="${dto.name}"></td>
			</tr>
			<tr>
				<th>메모</th>
				<td><textarea name="memo" class="form-control" required style="height: 200px;">${dto.memo}</textarea>
			</tr>
		</table>
		
		<hr>

		<div>
			<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='/memo/list.do';">
			<input type="submit" value="메모수정 " class="btn btn-default">
		</div>
		
		<input type="hidden" name="seq" value="${dto.seq}">
		</form>
      
   </div>
   
   <script>
   
   </script>
</body>
</html>
