<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        body *{
          font-family: 'Jua';
        }
    </style>
</head>
<body>
<h1>redirect</h1>
<%	
	List<String> list=Arrays.asList("red","green","blue","orange");

	//list 를 request 에 저장
	request.setAttribute("list", list); //request 에 저장 ("이름",데이터)
	
	//redirect 로 이동하는 경우 특징 : 1. url주소가 바뀐다. 2. request 가 새로 생성된다.
	//foward 로 이동하는 경우 특징 : 1. url 주소 바뀌지 않는다. 2. request 가 유지된다.
	//데이터 ex6_redirect2.jsp 로 이동 . 여기서는 redirect 사용.
	response.sendRedirect("./ex6_redirect2.jsp");
%>
<h2>list 갯수 : <%=list.size() %></h2>
</body>
</html>