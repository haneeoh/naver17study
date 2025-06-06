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

        #showimg {
            width: 120px;
            height: 160px;
            border: 1px solid lightgrey;
        }

        .tab1 tbody th {
            background-color: mistyrose;
        }
    </style>
    <script>
        let jungbok=false;

        $(function (){
            //중복버튼 이벤트
            $("#btnidcheck").click(function (){
                let myid=$("#myid").val();
                $.ajax({
                    type:"get",
                    dataType:"json",
                    data:{"myid":myid},
                    url:"./idcheck",
                    success:function (res){
                        if(res.result=='success'){
                            jungbok=true;
                            alert("사용 가능한 아이디입니다.")
                        }else {
                            jungbok=false;
                            alert("이미 존재하는 아이디입니다.\n다시 입력해주세요.");
                            $("#myid").val("");
                        }
                    }
                })
            });

            //중복체크를 하고 아이디 다시입력시 중복변수 다시 false 로
            $("#myid").keyup(function (){
                jungbok=false;
            });

        });
        function check(){
            let p1=$("#mpass").val();
            let p2=$("#mpass2").val();
            if (!jungbok) {
                alert("id 중복체크를 해주세요");
                return false;
            }
            if (p1!=p2){
                alert("비밀번호가 일치하지 않습니다");
                return false;//false 로 주면 action 으로 안넘어감
            }

        }
    </script>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
<div style="margin: 10px 10px;width: 450px;">
    <form action="./insert" method="post" enctype="multipart/form-data"
    onsubmit="return check()">
        <table class="table table-bordered tab1">
            <tbody>
            <tr>
                <td width="130" rowspan="4">
                    <input type="file" name="upload" style="width:100px;"
                           onchange="preview(this)">
                    <br>
                    <img src="" id="showimg" onerror="this.src='../save/noimage.jpg'">

                    <!-- 파일 선택시 제이쿼리로 미리보기 코드 -->
                    <script>
                        function preview(tag) {
                            let f = tag.files[0];
                            if (!f.type.match("image.*")) {
                                alert("이미지 파일만 가능합니다");
                                $("#showimg").attr("src", "");
                                return;
                            }

                            if (f) {
                                let reader = new FileReader();
                                reader.onload = function (e) {
                                    $("#showimg").attr("src", e.target.result);
                                }
                                reader.readAsDataURL(f);
                            }
                        }
                    </script>

                </td>
                <th width="70">이름</th>
                <td class="input-group">
                    <input type="text" name="mname" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <th width="70">아이디</th>
                <td class="input-group">
                    <input type="text" name="myid" class="form-control" required="required" id="myid">
                    <button type="button" class="btn btn-sm btn-danger"
                            id="btnidcheck">중복체크</button>
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td class="input-group">
                    <input type="password" name="mpass" class="form-control" required="required"
                           id="mpass" placeholder="비밀번호1">
                    <input type="password" name="mpass2" class="form-control" required="required"
                           id="mpass2" placeholder="비밀번호2">
                </td>
            </tr>
            <tr>
                <th>핸드폰</th>
                <td class="input-group">
                    <input type="text" name="mhp" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <th>주 소</th>
                <td colspan="2">
                    <input type="text" name="maddr" class="form-control">
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <button type="submit" class="btn btn-sm btn-success gaip">회원가입</button>
                </td>
            </tr>
            </tbody>
        </table>

    </form>
</div>
</body>
</html>