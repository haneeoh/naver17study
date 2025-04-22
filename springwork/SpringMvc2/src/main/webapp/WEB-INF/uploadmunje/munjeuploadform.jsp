<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>502jsp study</title>
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        body * {
            font-family: 'Jua';
        }
        .plus{
            position: relative;
            top:-25px;
            left:250px;
            width: 24px;
            height: 24px;
            border-radius: 15px;
            border: 1px solid black;
            background-color: black;
            color: white;
            text-align: center;
        }
        .min{
            position: relative;
            left:250px;
            top:-25px;
            width: 24px;
            height: 24px;
            border-radius: 15px;
            border: 1px solid gray;
            background-color: white;
            color: black;
            text-align: center;
        }
    </style>
</head>
<body>
<h4 class="alert alert-danger">여러개의 사진 업로드하기</h4>
<form action="./munjeprocess2" method="post" enctype="multipart/form-data">
    제목 : <input type="text" name="title"><br>
    사진 : <input type="file" name="upload" multiple style="width: 200px;"><br>
    <div class="addfile"></div>
    <button type="submit">전송</button>
    <button type="button" class="plus">+</button>
    <button type="button" class="min">-</button>
</form>
<script>
    $(".plus").click(function (){
       let s=`<input type="file" name="upload" multiple class="files"><br>`;
       $(".addfile").append(s);
    });
    $(".min").click(function (){
        $(".addfile .files:last").remove();
        $(".addfile br:last").remove();
    });
</script>
</body>
</html>