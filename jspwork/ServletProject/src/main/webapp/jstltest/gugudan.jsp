<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        body *{
            font-family: 'Jua';
        }
        
        .tab1 thead th{
        	background-color: #ddd;
        	color:blue;
        }
     </style>
</head>
<body>
<table class="table table-bordered tab1" style="margin:20px;width:700px;">
	<thead>
		<tr>
			<c:forEach var="dan" begin="2" end="9">
				<th>[${dan}단]</th>
			</c:forEach>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="n" begin="1" end="9">
			<tr>
				<c:forEach var="dan" begin="2" end="9">
					<td align="center">${dan}x${n}=${dan*n}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>
































