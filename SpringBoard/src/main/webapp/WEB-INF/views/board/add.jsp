<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<style>
	.add th {width: 150px;}
	.add th {width: auto;}
	.add textarea { resize: none; height: 200px; }
</style>


<form method="POST" action="/addok" enctype="multipart/form-data">
<table class="table table-bordered add">
	
	<tr>
		<th>제목</th>
		<td><input type="text" name="subject" class="form-control" required></td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td><textarea name="content" class="form-control" required></textarea></td>
	</tr>
	
	<tr>
		<th>파일</th>
		<td><input type="file" name="attach" class="form-control"></td>
	</tr>

</table>
<div class="btns">
	<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='/list';">
	<input type="submit" value="작성하기" class="btn btn-default">
</div>

</form>