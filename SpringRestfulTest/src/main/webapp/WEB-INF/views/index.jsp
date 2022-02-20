<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
	<meta charset="UTF-8">
	<title>주소록</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
	<script src="/resources/js/jquery.serializeObject.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	<style>
	
		.container {
			width: 700px;
		}
		
		.list th, .list td {
			text-align: center;
		}
		.list th-nth-child(1) { width: 80px;}
		.list th-nth-child(2) { width: 60px;}
		.list th-nth-child(3) { width: 150px;}
		.list th-nth-child(4) { width: auto;}
		.list th-nth-child(5) { width: 80px;}
		
		.add {
			width: 400px;
		}
		.add th {
			width: 100px;
			text-align: center;
		}
		.add input[name='name'], .add input[name='age'] {
			width: 120px;
		}
		
		.add input[name='name'] {
			width: 200px;
		}
		
	</style>
</head>
<body>

	<div class="container">
		<h1 class="page-header">주소록 <small>RESTful</small></h1>
		
		<!-- 
		<div class="well well-sm">
			<input type="text" class="form-control" placeholder="주소 검색" id="word" autocomplete="off">
		</div> 
		-->
		
		<div class="well well-sm">
		<div class="col-lg-6">
            <div class="input-group">
               <input type="text" class="form-control" placeholder="주소 검색" id="word" autocomplete="off">
               <span class="input-group-btn">
                  <button class="btn btn-default" type="button" onclick="clearSearch();">resset</button>
               </span>
            </div>
         </div>
         </div>
		
		<table class="table table-bordered list">
			<thead>
				<tr>
					<th>이름</th>
					<th>나이</th>
					<th>전화</th>
					<th>주소</th>
					<th>조작</th>
				</tr>
			</thead>
			<tbody>
				<!-- 
				<tr>
					<td colspan="5">데이터가 없습니다.</td>
				</tr>
				<tr>
					<td>홍길동</td>
					<td>20</td>
					<td>101-1234-1234</td>
					<td>서울시 강남구 역삼동</td>
					<td>
						<button type="button" class="btn btn-default btn-xs" value="x" onclick="">U</button>
						<button type="button" class="btn btn-default btn-xs" value="x" onclick="">D</button>
					</td>
				</tr>
				-->
			</tbody>
		</table>
		
		<hr>
		
		<form id="form1">
		<table class="table table-bordered add">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" class="form-control"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age" class="form-control"></td>
			</tr>
			<tr>
				<th>전화</th>
				<td><input type="tel" name="tel" class="form-control"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" class="form-control"></td>
			</tr>
		</table>
		<div>
			<input type="button" value="추가하기" class="btn btn-default" id="btn">
			<!-- seq 히든태그로 넣어주면 편함 -->
		</div>
		</form>
	</div>

	<script>
	
		//목록 가져오기
		//1. 시작할 때 호출
		//2. 추가하기 > 호출
		//3. 수정하기 > 호출
		//4. 삭제하기 > 호출
		function load(word) {
			
			let url = 'http://localhost:8090/address';
			
			if(word != null && word != ''){
				url = url + '/' + word;
			}
			
			$.ajax({
				
				//request
				type: 'GET',
				url: url,
				
				//response
				dataType: 'json',
				success: function(list) {
				
					$('.list tbody').html(''); //초기화
					
					$(list).each((index, item) => {
						
						let tr = '<tr><td>' + item.name + '</td><td>' + item.age +'</td><td>'+ item.tel + '</td><td>' + item.address + '</td><td><button type="button" class="btn btn-default btn-xs" value="x" onclick="edit(' + item.seq + ');">U</button><button type="button" class="btn btn-default btn-xs" value="x" onclick="del(' + item.seq +');">D</button></td></tr>';
						
						$('.list tbody').append(tr);
						
					});
				},
				
				//try-catch
				error: function(a, b, c){
					console.log(a, b, c);
				}
			
			})
		}
		
		load(); //1. 시작할 때 호출
		
		$('#btn').on('click', add);
		
		function add() {
			
			let data = JSON.stringify($('#form1').serializeObject());
			
			$.ajax({
				
				//request
				type: 'POST',
				url: 'http://localhost:8090/address',
				contentType: 'application/json;charset=UTF-8',
				data: data,
				
				//response
				dataType: 'json',
				success: function(result){
					if(result == 1){
						load();
						//$('#form1 .add input').val('');
						$('#form1 input[class=form-control]').val('');
					}
				},
				
				//error
				error: function(a, b, c){
					console.log(a,b,c);
				}
				
			});
			
		}

		function edit(seq) {
			
			let name = $(event.srcElement).parent().parent().children().eq(0).text();
			let age = $(event.srcElement).parent().parent().children().eq(1).text();
			let tel = $(event.srcElement).parent().parent().children().eq(2).text();
			let address = $(event.srcElement).parent().parent().children().eq(3).text();
			
			$('input[name=name]').val(name);
			$('input[name=age]').val(age);
			$('input[name=tel]').val(tel);
			$('input[name=address]').val(address);
			
			$('#btn').val('수정하기');
			$('#btn').off('click', add);
			$('#btn').on('click', {seq:seq}, editok);
			
		}
		
		function editok(evt) {
			
			/* json에 더 집어넣기*/
			/* 
			console.log($('#form1').serializeObject());
			let obj = $('#form1').serializeObject();
			obj.seq = evt.data.seq;
			console.log(obj);
			return;
			*/
			let data = JSON.stringify($('#form1').serializeObject());
			
			$.ajax({
				
				//request
				type: 'PUT',
				url: 'http://localhost:8090/address/' + evt.data.seq,
				contentType: 'application/json;charset=UTF-8',
				data: data,
				
				//response
				dataType: 'json',
				success: function(result){
					if(result == 1){
						load();
						$('#form1 input[class=form-control]').val('');
						
						$('#btn').val('추가하기');
						$('#btn').off('click', editok);
						$('#btn').on('click', add);
					}
				},
				
				//error
				error: function(a, b, c){
					console.log(a,b,c);
				}
				
			});
			
		}
		
		function del(seq) {
			
			$.ajax({
				
				//request
				//소문자로 적어도 되는데 대문자로 많이 적음
				type: 'DELETE',
				url: 'http://localhost:8090/address/' + seq,
				
				//response
				dataType: 'json',
				success: function(result){
					if(result == 1){
						load();
					}
				},
				
				//error
				error: function(a, b, c){
					console.log(a,b,c);
				}
				
			});
		}
		
		/*
		$('#word').keydown((evt) => {
			if(evt.keyCode == 13 && $('#word').val() != ''){
				
				load($('#word').val());
			}
		});
		*/
		$('#word').keyup((evt) => {
			
			let regex = /^[가-힣]{1,}$/gi;
			
			if(regex.test($('#word').val())){
				load($('#word').val());			
			}
		});
		
		
		function clearSearch() {
			$('#word').val('');
			load();
		}
		
	</script>
</body>
</html>
