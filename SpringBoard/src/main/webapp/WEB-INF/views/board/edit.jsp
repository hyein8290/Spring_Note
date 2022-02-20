<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<style>
	.add th {width: 150px;}
	.add th {width: auto;}
	.add textarea { resize: none; height: 200px; }
</style>


<form method="POST" action="/editok" enctype="multipart/form-data">
<table class="table table-bordered add">
	
	<tr>
		<th>제목</th>
		<td><input type="text" name="subject" class="form-control" required value="${dto.subject}"></td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td><textarea name="content" class="form-control" required>${dto.content}</textarea></td>
	</tr>
	
	<tr>
		<th>파일</th>
		<td>
			<div>
				<input type="file" name="attach" class="form-control">		
			</div>
			<div>
				<c:if test="${empty dto.orgfilename}">
					첨부파일 없음
				</c:if>			
				<c:if test="${not empty dto.orgfilename}">
					<div id="file">첨부파일: ${dto.orgfilename}</div>
					<div id="on">[삭제하기]</div>
					<div id="off">[되돌리기]</div>
				</c:if>	
			</div>
		</td>
	</tr>

</table>
<div class="btns">
	<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='/list';">
	<input type="submit" value="수정하기" class="btn btn-default">
</div>

<input type="hidden" name="seq" value="${dto.seq}">
<input type="hidden" name="del" id="del" value="off">
</form>

<script>
	$('#off').hide();
	
	$('#on').click(() => {
		$('#file').css("text-decoration", "line-through");
		$('#on').hide();
		$('#off').show();
		$('#del').val("on");
	});

	$('#off').click(() => {
		$('#file').css("text-decoration", "none");
		$('#on').show();
		$('#off').hide();
		$('#del').val("off");
	});
	
</script>




