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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }

        img.large {
            width: 300px;
            height: 350px;
            border: 1px solid lightgray;
        }

        img.small {
            width: 80px;
            height: 80px;
            border: 1px solid lightgray;
            cursor: pointer;
        }

        .colorbox {
            display: inline-block;
            width: 25px;
            height: 25px;
            border: 1px solid lightgray;
            border-radius: 15px;
        }

        .addphoto {
            cursor: pointer;
            color: #25ccff;
            font-size: 2em;
        }

        div #photoupload {
            display: none;
        }

        .replelist {
            margin: 10px 10px;
        }

        .rephoto {
            width: 60px;
            height: 60px;
            border-radius: 30px;
            margin-right: 20px;
            cursor: pointer;
        }

        .rwriteday {
            font-size: 0.8em;
            color: lightgray;
        }

        .rmsg {
            font-size: 1.3em;
        }

        .like {
            color: red;
            cursor: pointer;
            position: relative;
            top: 18px;
            left: 150px;
        }

        .likes {
            color: gray;
            font-size: 0.8em;
        }

        .like:hover {
            background-color: yellow;
        }

        .redel {
            color: red;
            font-size: 0.8em;
            cursor: pointer;
        }
    </style>
    <script>
        let file;
        $(function () {
            replelist();//처음 로딩시 댓글 출력
            //댓글 삭제 아이콘 이벤트
            $(document).on("click",".redel",function () {
                let ans = confirm("현재 댓글을 삭제하시겠습니까?");
                let idx = $(this).attr("idx");
                let rphoto = $(this).attr("rphoto");
                // console.log("idx",idx);
                if(ans) {
                    $.ajax({
                        type: "get",
                        dataType: "text",
                        data: {"idx": idx, "rphoto": rphoto},
                        url: "./repledelete",
                        success: function () {
                            replelist();
                        }
                    });
                }
            });

            //카메라 아이콘 이벤트
            $(".addphoto").click(function () {
                $("#photoupload").trigger("click");
            });
            //파일 업로드 이벤트
            $("#photoupload").change(function (e) {
                file = e.target.files[0];
                console.log(file);
            });

            //댓글 등록버튼 이벤트(ajax)
            $("#btnaddreple").click(function () {
                let m = $("#message").val();
                if (m == '') {
                    alert("댓글을 입력해주세요");
                    return;
                }
                if (file == null) {
                    alert("사진을 선택해주세요");
                    return;
                }

                let form = new FormData();

                console.log(file);

                form.append("upload", file);
                form.append("message", m);
                form.append("num", ${dto.num});

                $.ajax({
                    type: "post",
                    dataType: "text",
                    url: "./addreple",
                    data: form,
                    processData: false,
                    contentType: false,
                    success: function () {
                        $("#message").val("");
                        file = null;
                        replelist();
                    }
                });
            });

            //미니 댓글 사진 클릭시 원본 사진 보기
            $(document).on("click","img.rephoto",function (){
                let imgSrc=$(this).attr("src");
                $("img.modalphoto").attr("src",imgSrc);
            });

            //추천 아이콘 클릭시 추천 아이콘 증가
            $(document).on("click",".like",function (){
                let idx=$(this).attr("idx");
                let icon=$(this);
                $.ajax({
                    type:"get",
                    dataType:"json",
                    data:{"idx":idx},
                    url:"./likes",
                    success:function (res){
                        // alert(res.likes)
                        icon.next().find(".likes").text(res.likes);
                    }
                })
            })
        });

        function replelist() {
            $.ajax({
                type: "get",
                dataType: "json",
                data: {"num":${dto.num}},
                url: "./replelist",
                success: function (res) {
                    // console.log(res);
                    writedata(res);
                }
            });
        }

        function writedata(res) {
            let s = "";
            s = `<b style="font-size:1.2em;">총 \${res.length} 개의 댓글이 있습니다.</b><br><hr>`;
            //반복문
            $.each(res, function (idx, ele) {
                s += `
                <img class="rephoto" src="\${naverurl}/shop/\${item.photo}" align="left" idx="\${ele.idx}" data-bs-toggle="modal" data-bs-target="#myModal">
                <span class="rwriteday">\${ele.writetime}</span>&nbsp;&nbsp;
                <i class="bi bi-x-circle redel" idx="\${ele.idx}" rphoto="\${ele.photo}"></i>
                <i class="bi bi-hand-thumbs-up like" idx="\${ele.idx}">
                    <span class="likes" val="0" idx="\${ele.idx}">&nbsp;&nbsp;추천\${ele.likes}</span><br>
                </i>
                <span class="rmsg">\${ele.message}</span><br>
                <hr>
                `;

            });
            $(".replelist").html(s);
        }

    </script>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
<!-- The Modal -->
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">사진보기</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <img src="" class="modalphoto" style="width: 90%;">
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
            </div>

        </div>
    </div>
</div>
<div style="margin: 20px;">
    <table>
        <tr>
            <td width="100">
                <c:forTokens var="photo" items="${dto.sphoto}" delims=",">
                    <img src="${naverurl}/shop/${photo}" class="small" style="margin-bottom: 20px;">
                    <script>
                        $("img.small").click(function () {
                            $("img.large").attr("src", $(this).attr("src"));
                        });
                    </script>
                </c:forTokens>
            </td>
            <td>
                <img src="${naverurl}/shop/${dto.mainPhoto}" class="large"
                     onerror="this.src='../save/noimage.jpg'">
            </td>
        </tr>
        <tr>

            <td colspan="2">
                <div style="margin: 20px 100px;font-size: 17px;">
                    <mark>상품명 : ${dto.sangpum}</mark>
                    <br>
                    가격 : <fmt:formatNumber value="${dto.sprice}" type="number"/>원<br>
                    색상 : ${dto.scolor}
                    <div class="colorbox" style="background-color: ${dto.scolor}"></div>
                    <br>
                    수량 : ${dto.scnt}<br>
                    입고일 : ${dto.ipgoday}<br>
                    등록일 : <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div class="repleform input-group" style="width: 450px;">
                    <input type="text" id="message" class="form-control"
                           style="width: 300px;" placeholder="댓글입력">&nbsp;&nbsp;
                    <input type="file" id="photoupload">
                    <i class="bi bi-camera-fill addphoto"></i>&nbsp;&nbsp;
                    <button type="button" class="btn btn-sm btn-info" id="btnaddreple">등록</button>
                </div>
                <div class="replelist">

                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="button" class="btn btn-sm btn-outline-secondary"
                        style="width: 80px;" onclick="location.href='./addform'">
                    상품등록
                </button>
                <button type="button" class="btn btn-sm btn-outline-secondary"
                        style="width: 60px;" onclick="location.href='./list'">
                    목록
                </button>
                <button type="button" class="btn btn-sm btn-outline-secondary"
                        style="width: 60px;" onclick="location.href='./updateform?num=${dto.num}'">
                    수정
                </button>
                <button type="button" class="btn btn-sm btn-outline-secondary"
                        style="width: 80px;" onclick="location.href='./photos?num=${dto.num}'">
                    사진수정
                </button>
                <button type="button" class="btn btn-sm btn-outline-secondary del"
                        style="width: 60px;">
                    삭제
                </button>
            </td>
        </tr>
    </table>
</div>
<script>
    $(".del").click(function () {
        if (confirm("삭제하시겠습니까?"))
            location.href = "./delete?num=" +${dto.num};
    });
</script>
</body>
</html>