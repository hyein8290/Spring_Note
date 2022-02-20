<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!-- view.jsp -->

<style>
	.add th {width: 150px;}
	.add th {width: auto;}
	.add textarea { resize: none; height: 200px; }
</style>


<table class="table table-bordered add">
	
	<tr>
		<th>번호</th>
		<td>${dto.seq}</td>
	</tr>

	<tr>
		<th>이름</th>
		<td>${dto.name}(${dto.id})</td>
	</tr>

	<tr>
		<th>날짜</th>
		<td>${dto.regdate}</td>
	</tr>
	
	<tr>
		<th>제목</th>
		<td>${dto.subject}</td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td>${dto.content}</td>
	</tr>
	
	<tr>
		<th>파일</th>
		<td>
			<c:if test="${empty dto.orgfilename}">
				첨부파일 없음
			</c:if>			
			<c:if test="${not empty dto.orgfilename}">
				<a href="/download?filename=${dto.filename}&orgfilename=${dto.orgfilename}">${dto.orgfilename}</a>
			</c:if>
		</td>
	</tr>

</table>
<div class="btns">
	<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='/list';">
	<input type="button" value="수정하기" class="btn btn-default" onclick="location.href='/edit?seq=${dto.seq}';">
	<input type="button" value="삭제하기" class="btn btn-default" onclick="location.href='/del?seq=${dto.seq}';">
</div>


