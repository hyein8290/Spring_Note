<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Document</title>
	<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
   <style>
   		nav {
			border: 10px solid #555;
			width: 150px;
			height: 400px;
			background-color: rgb(255, 201, 14); /* 회원 */
			/*background-color: rgb(181, 231, 29); *//* 관리자 */
			float: left;
		}
		
		nav > a {
			display: block;
			margin: 10px;
		}
		
		section > section {
			width: 430px;
		}
   </style>
</head>
<body>
   <!-- info.jsp -->
	
	<main>

		<%@ include file="/WEB-INF/views/inc/mainmenu.jsp" %>

		<section>
			<%@ include file="/WEB-INF/views/inc/submenu_member.jsp" %>
			<section>
				회원 > 회원 로그 기록을 출력합니다.
			</section>
		</section>

	</main>
   
   <script>
   
   </script>
</body>
</html>
