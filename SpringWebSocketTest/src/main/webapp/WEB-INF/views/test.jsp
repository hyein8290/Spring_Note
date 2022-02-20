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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h1 class="page-header">Web Socket</h1>
		
		<fieldset>
			<legend>웹소켓 연결 테스트</legend>
			
			<input type="button" value="연결하기" id="btn1" class="btn btn-default">
			<input type="button" value="종료하기" id="btn3" class="btn btn-default">			
			<input type="button" value="에코 테스트" id="btn2" class="btn btn-default">
			<hr>
			<input type="text" id="msg" class="form-control">			
			<hr>
			<div class="well" id="log"></div>
			
		</fieldset>
	</div>
	
	<script>
	
		//클라이언트 <-> 서버(테스트용)
		//에코 테스트
		//let url = 'ws://echo.websocket.org';
		let url = 'ws://localhost:8090/socket/server';
		
		//웹소켓
		let ws;
		
		$('#btn1').click(() => {
				
			//1. 소켓 생성
			//2. 서버 접속(연결)
			//3. 통신
			//4. 서버 접속 종료
			
			//소켓 생성 + 서버 접속
			ws = new WebSocket(url);
			
			//소켓 이벤트 > 콜백 형태
			//서버측에서 소켓 연결을 받아들이고 연결이 되는 순간 발생
			ws.onopen = function(evt) {
				log('서버와 연걸되었습니다.');
			};
			
			//상대방이 나에게 메시지를 보낼 때 발생
			ws.onmessage = function(evt) {
				log(evt.data);
			}
			
			//연결이 끊길 때
			ws.onclose = function(evt) {
				log('서버와 종료되었습니다.');
			}
			
			//에러 발생할 때
			ws.onerror = function(evt) {
				log('에러가 발생했습니다.');
			}
			
		});
		
		function log(msg) {
			$('#log').prepend('<div>[' + new Date().toLocaleTimeString()+ ']' + msg + '</div>');
		}
		
		$('#btn2').click(() => {
			
			//연결된 서버에게 메시지 전송하기
			ws.send('안녕하세요');
			log('메시지를 전송했습니다.');
			
		});
		
		$('#msg').keydown((evt) => {
			
			if(evt.keyCode == 13){
				ws.send($('#msg').val());
				$('#msg').val('');
				log('메시지를 전송했습니다.');
			}
			
		});
		
		$('#btn3').click(() => {
			
			ws.close();
			log('연결을 종료합니다.');
		});
		
	</script>
	
</body>
</html>










