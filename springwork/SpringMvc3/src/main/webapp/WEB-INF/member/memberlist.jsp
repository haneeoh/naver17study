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

        img {
            width: 25px;
            height: 25px;
        }

        .tab2 {
            font-size: 0.8em;
        }

        .tab1 thead th {
            background-color: #fff0f5;
        }
    </style>
</head>
<body>

<jsp:include page="../../layout/title.jsp"/>
<div style="margin: 20px; width: 450px;">
    <h5>총 ${totalCount}명의 회원이 있습니다.</h5>
</div>
<table class="table table-bordered tab1" style="width: 500px;margin: 20px;">
    <thead>
    <tr>
        <th width="100"><input type="checkbox" class="allchk"> 회원명</th>
        <th width="80">아이디</th>
        <th width="100">핸드폰</th>
        <th width="100">주소</th>
        <th width="55">삭제</th>
    </tr>
    </thead>
    <tbody class="tab2">
    <c:forEach var="member" items="${list}">
        <tr>
            <td>
                <input type="checkbox" class="numchk" num="${member.num}">&nbsp;
                    <%--  <img src="../save/${member.mphoto}"--%>
                    <%--      onerror="this.src='../save/noimage.jpg'">&nbsp;${member.mname}--%>
                    <%-- 원본사진을 사이즈만 바꿔서 출력 --%>
                    <%--  <img src="${naverurl}/member/${member.mphoto}"--%>
                    <%--      onerror="this.src='../save/noimage.jpg'">&nbsp;${member.mname}--%>
                    <%-- 원본사진에서 30*30으로 자른 썸네일로 출력 --%>
                <img src="${fronturl}/member/${member.mphoto}${backurl}"
                     onerror="this.src='../save/noimage.jpg'">&nbsp;${member.mname}

            </td>
            <td>
                    ${member.myid}
            </td>
            <td>
                    ${member.mhp}
            </td>
            <td>
                    ${member.maddr}
            </td>
            <td>
                <button class="btn btn-sm btn-danger"
                        onclick="memdel(${member.num})">삭제
                </button>
                <script>
                    function memdel(num) {
                        let ans = confirm("해당 멤버를 삭제하시겠습니까?");
                        if (ans) {
                            location.href = './delete?num=' + num;
                        }
                    }
                </script>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button type="button" class="btn btn-sm btn-info"
        style="margin: 20px;" id="delmembers">선택한 멤버 삭제
</button>
<script>
    //체크값 전달
    $(".allchk").click(function () {
        let chk = $(this).is(":checked");
// alert(chk);
        $(".numchk").prop("checked", chk);
    });
    //선택한 멤버 삭제 이벤트
    $("#delmembers").click(function () {
//체크 된 회원수
        let len = $(".numchk:checked").length;
// alert(len);
        if (len == 0) {
            alert("탈퇴시킬 멤버를 선택해주세요")
            return;
        }
        let nums = "";
        $(".numchk:checked").each(function (idx, item) {
            nums += $(this).attr("num") + ",";
        });
//마지막 , 는 제거
        nums = nums.substring(0, nums.length - 1);
// alert(nums);
//의사묻기 false면 retrun, true 면 실행
        if (!confirm("선택한 멤버를 삭제하시겠습니까?")) {
            return;
        }
//삭제이벤트
        $.ajax({
            type: "get",
            dataType: "text",
            data: {"nums": nums},
            url: "./checkdel",
            success: function () {
                location.reload();
            }
        })
    });
</script>
</body>
</html>