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

        .profilelargephoto {
            width: 100px;
            height: 100px;
            border-radius: 50px;
            border: 1px solid lightgrey;
            position: relative;
            top: -140px;
        }

        .changecamera {
            position: relative;
            cursor: pointer;
            left: -30px;
            top: -100px;
            font-size: 1.5em;
        }
    </style>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
<div style="margin: 30px 100px">
<%--    <img src="../save/${dto.mphoto}" class="profilelargephoto"
onerror="this.src='../save/noimage.jpg'">--%>

    <!-- naver storage 에 있는 사진으로 출력 -->
    <img src="${naverurl}/member/${dto.mphoto}" class="profilelargephoto"
         onerror="this.src='../save/noimage.jpg'">
    <input type="file" id="fileupload" style="display: none">
    <i class="bi bi-camera-fill changecamera"></i>
    <script>
        $(".changecamera").click(function () {
            $("#fileupload").trigger("click");
        });

        //사진변경 이벤트
        $("#fileupload").change(function (e) {
            let form = new FormData();
            form.append("upload", e.target.files[0]);
            form.append("num", ${dto.num});

            $.ajax({
                type: "post",
                dataType: "text",
                data: form,
                url: "./changephoto",
                processData: false,
                contentType: false,
                success: function () {
                    location.reload();
                }
            })
        });
    </script>
    <div style="display: inline-block;margin: 20px 50px">
        <h6>회원명 : ${dto.mname}</h6>
        <h6>아이디 : ${dto.myid}</h6>
        <h6>핸드폰 : ${dto.mhp}</h6>
        <h6>주 소 : ${dto.maddr}</h6>
        <h6>가입일 :
            <fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd HH:mm"/>
        </h6>
        <br><br>
        <button type="button" class="btn btn-sm btn-danger"
                onclick="memberdel(${dto.num})">회원탈퇴
        </button>
        <script>
            function memberdel(num) {
                let ans = confirm("정말 탈퇴하시겠습니까?");
                if (ans) {
                    //ajax (세션에서도 삭제)
                    $.ajax({
                        type: "get",
                        dataType: "text",
                        data: {"num": num},
                        url: "./mypagedel",
                        success: function () {
                            location.href = '../';
                        }
                    });
                }
            }
        </script>
        <!-- 문제 : 아이디를 제외한 나머지정보(mname,mhp,maddr)수정 모달
         수정 후 reload 할거니까 #responseBody로 매서드 구현-->
        <button type="button" class="btn btn-sm btn-success"
                data-bs-toggle="modal" data-bs-target="#myUpdateModal">회원정보수정</button>
    </div>
</div>

<!-- The 수정Modal -->
<div class="modal" id="myUpdateModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">회원정보수정</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form id="updatefrm">
                <table>
                    <tbody>
                    <tr>
                        <th width="70">이름</th>
                        <td class="input-group">
                            <input type="text" name="mname" class="form-control"
                                   id="mname" required="required" value="${dto.mname}">
                        </td>
                    </tr>
                    <tr>
                        <th>핸드폰</th>
                        <td class="input-group">
                            <input type="text" name="mhp" class="form-control"
                                   id="mhp" required="required" value="${dto.mhp}">
                        </td>
                    </tr>
                    <tr>
                        <th>주 소</th>
                        <td class=" input-group">
                            <input type="text" name="maddr" class="form-control"
                                   id="maddr" value="${dto.maddr}">
                        </td>
                    </tr>
                    </tbody>
                </table>
                </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-success" data-bs-dismiss="modal"
                id="btnupdate">수정하기</button>
            </div>
        </div>
    </div>
</div>
<script>
    $("#btnupdate").click(function (e){
        $.ajax({
            type:"post",
            dataType: "text",
            data:{"mname":$("#mname").val(),"mhp":$("#mhp").val(),
            "maddr":$("#maddr").val(),"num":${dto.num}},
            url:"./update",
            success:function (){
                location.reload();ß
            }
        });
    });
</script>
</body>
</html>