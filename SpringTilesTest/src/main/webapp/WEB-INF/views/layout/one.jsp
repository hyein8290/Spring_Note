<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<tiles:insertAttribute name="asset"></tiles:insertAttribute>
	<style>	
	</style>
</head>
<body>
	<!-- main.jsp -->

	<main>

		<tiles:insertAttribute name="mainmenu"></tiles:insertAttribute>

		<section>
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		</section>

	</main>

	</div>

	<script>
   
   </script>
</body>
</html>
