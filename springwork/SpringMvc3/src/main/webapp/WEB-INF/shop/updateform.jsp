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
    </style>
</head>
<body>
<div style="margin: 30px; width: 400px;">
    <form action="./update" method="post">
        <input type="hidden" name="num" value="${dto.num}">

        <table class="tab1 table table-bordered">
            <caption align="top"><b>상품수정</b></caption>
            <tbody>
            <tr>
                <th width="100">상품명</th>
                <td>
                    <input type="text" name="sangpum" autofocus required="required"
                           class="form-control" value="${dto.sangpum}">
                </td>
            </tr>
            <tr>
                <th>가격</th>
                <td>
                    <input type="number" name="sprice" class="form-control"
                           required="required" value="${dto.sprice}" step="5000" >
                </td>
            </tr>
            <tr>
                <th>수량</th>
                <td>
                    <input type="number" name="scnt" class="form-control"
                           required="required" value="${dto.scnt}">
                </td>
            </tr>
            <tr>
                <th>색상</th>
                <td>
                    <input type="color" name="scolor" class="form-control"
                           value="${dto.scolor}">
                </td>
            </tr>
            <tr>
                <th>입고일</th>
                <td>
                    <input type="date" name="ipgoday" class="form-control"
                           required="required" value="${dto.ipgoday}">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class="btn btn-sm btn-success"
                            onclick="">수정하기</button>
                    <button type="button" class="btn btn-sm btn-success"
                            onclick="location.href='./list'">목록</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>