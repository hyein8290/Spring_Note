<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<tiles:insertAttribute name="asset"></tiles:insertAttribute>
	<style>
	nav {
		border: 10px solid #555;
		width: 150px;
		height: 400px;
		background-color: rgb(255, 201, 14); /* 회원 */
		/*background-color: rgb(181, 231, 29); */ /* 관리자 */
		float: left;
	}
	
	nav>a {
		display: block;
		margin: 10px;
	}
	
	section>section {
		width: 430px;
	}
	</style>
</head>
<body>
	<!-- two.jsp -->

	<main>

		<tiles:insertAttribute name="mainmenu"></tiles:insertAttribute>
		
		<section>
			<tiles:insertAttribute name="submenu"></tiles:insertAttribute>
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		</section>

	</main>
   
   <script>
   
   </script>

</body>
</html>
