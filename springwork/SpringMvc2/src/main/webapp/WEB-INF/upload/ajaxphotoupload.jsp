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
        #photoupload{
            display: none;
        }
        #myphoto{
            width: 250px;
            height: 250px;
            border-radius: 200px;
            border: 1px solid lightgray;
        }
        .icon{
            font-size: 1.3em;
            color: gray;
            background-color: whitesmoke;
            cursor: pointer;
            padding: 5px;
            border-radius: 20px;
            border: 1px solid gray;
            position: relative;
            left: -60px;
            top: 80px;
        }

    </style>
</head>
<body>
<div style="margin: 50px;">

    <input type="file" id="photoupload">

    <img src="" id="myphoto" onerror="this.src='./image/noimage.jpg'">

    <i class="bi bi-camera icon"></i>

    <script>
        $(".icon").click(function (){
           $("#photoupload").trigger("click");
        });
        //파일태그는 무조건 배열로 넘어오기때문에 꼭 배열 위치 확인
        $("#photoupload").change(function (e){
            let form=new FormData();
        //    form.append("upload",$("#photoupload")[0].files[0]);//선택한 파일 1개
            form.append("upload",e.target.files[0]);// 이것도 가능
        /*
        processData:false : 서버에 전달하는 데이터는 query string 이라는 형태로 들어간다
        파일전송의 경우 이를 하지 않아야 하는데 그 설정이 false
        contentType:false : enctype 이 원래 기본값이 application/x-www... 이거인데
        multypart/form-data 로 변경해준다
        */
            $.ajax({
                type:"post",
                dataType:"json",
                url:"./oneupload",
                processData:false,
                contentType:false,
                data:form,
                success:function (res){
                    $("#myphoto").attr("src","./save/"+res.photo);
                }
            });
        });
    </script>
</div>

</body>
</html>