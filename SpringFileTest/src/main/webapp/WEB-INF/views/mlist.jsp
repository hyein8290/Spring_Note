<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
   <!-- mlist.jsp -->

	<main>
		<h1>게시판</h1>
		
		<table border width="500">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>파일</th>
			</tr>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.seq}</td>
				<td>${dto.subject}</td>
				<td>
					<c:forEach items="${dto.flist}" var="fdto">
					<div>
					<a href="/file/download.do?orgfilename=${fdto.orgfilename}&filename=${fdto.filename}">${fdto.orgfilename}</a>
					<c:if test="${fdto.orgfilename.endsWith('.jpg') || fdto.orgfilename.endsWith('.jpeg') || fdto.orgfilename.endsWith('.gif') || fdto.orgfilename.endsWith('.png')}">
					<img src="/file/resources/file/${fdto.filename}">
					</c:if>

					
					</div>
					</c:forEach>
				</td>
			</tr>
			</c:forEach>
		</table>
		
		<hr>
		
		<div>
			<input type="button" value="글쓰기" onclick="location.href='/file/madd.do'">
		</div>
	</main>

	
   
   <script>
   
   </script>
</body>
</html>
