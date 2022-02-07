<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- asset.jsp -->

<%
	String root = request.getContextPath();
%>


<!--  
	
	스프링 MVC 프로젝트에서는 정적 자원(html, css, js, 이미지 등)은 resources 폴더 하위에서 관리하도록 권장

-->

<link rel="stylesheet" href="<%= root %>/resources/css/bootstrap.css">

<script src="<%= root %>/resources/js/jquery-1.12.4.js"></script>
<script src="<%= root %>/resources/js/bootstrap.js"></script>
<script src="<%= root %>/resources/js/cookie.js"></script>