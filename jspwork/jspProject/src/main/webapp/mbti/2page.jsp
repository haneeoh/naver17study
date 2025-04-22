<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
	<link href="https://fonts.googleapis.com/css2?family=DM+Sans:ital,opsz,wght@0,9..40,100..1000;1,9..40,100..1000&family=DM+Serif+Text:ital@0;1&family=Gowun+Batang&family=Jua&family=Micro+5&family=Noto+Sans+KR:wght@100..900&family=Sunflower:wght@300&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./mbticss.css">
    
</head>
<body>
<div class="box">
<!-- 		<div class="range"></div> -->
		<div class="range2" style="width : 30px;"></div>
		<div class="back">
			<div class="line"></div>
			<div class="cir1"></div>
			<div class="cir2"></div>
			<div class="cir3"></div>
			<div class="moon">
				
			</div>
		</div>
		<img class="yes" src="./mbtiimg/yes.png">
		<img class="no" src="./mbtiimg/no.png">
	</div>
	<script>
	$(document).ready(function () {
		
	    let questions = []; // 질문 데이터를 저장할 배열
	    let currentIndex = 0; // 현재 질문 인덱스
	    fetchQuestions(); // 페이지 로드 시 XML 데이터 가져오기
	    let a=0,b=0,c=0,d=0;
	    const urlParams = new URLSearchParams(window.location.search);
        const name = urlParams.get("name");
/*         console.log("이름",name); */

	    // XML 데이터를 가져오는 함수
	    function fetchQuestions() {
	        $.ajax({
	            type: "GET",
	            dataType: "xml",
	            url: "./moon.xml", // XML 파일 불러오기
	            success: function (res) {
	            /* 	console.log("xml",res); */
	                // XML 데이터를 배열에 저장
	                $(res).find("question").each(function () {
	                    let e = $(this);
	                    let title = e.find("title").text();
	                    let text = e.find("p").html(); // <p> 내부의 <br> 태그도 유지
	                    let num = e.find("num").text();
/* 	                    console.log("타이틀",title);
	                    console.log("텍스트",text); */
	                    questions.push({ title, text, num});
	                });

	                updateQuestion(); // 첫 번째 질문 표시
	            }

	        });
	    }
	    

	    // 현재 질문을 업데이트하는 함수
	    function updateQuestion() {
	        if (currentIndex < questions.length) {
 	        	/* console.log("a",a);
	        	console.log("b",b);
	        	console.log("c",c);
	        	console.log("d",d);  */

	        	
	            $(".moon").html(`
	                <div class="title">\${questions[currentIndex].title}</div>
	                <p class="p">\${questions[currentIndex].text}</p>
	            `);
	        } else {
	            // 3page.jsp로 이동하며 a, b, c, d 값을 전달
	            window.location.href = "./resultpage.jsp?name="+name+"&a="+a+"&b="+b+"&c="+c+"&d="+d;
	        }
	    }

	    $(".yes").click(function () {
	        if (currentIndex < questions.length) {
	            // 현재 질문의 <num> 태그 값 가져오기
	            let num = questions[currentIndex].num;

	            // YES 버튼 클릭 시 +1
	            if (num === "I") a += 1;
	            else if (num === "N") b += 1;
	            else if (num === "F") c += 1;
	            else if (num === "P") d += 1;

	            currentIndex++;
	            updateQuestion();
	        }
	    });

	    $(".no").click(function () {
	        if (currentIndex < questions.length) {
	            // 현재 질문의 <num> 태그 값 가져오기
	            let num = questions[currentIndex].num;

	            // NO 버튼 클릭 시 -1
	            if (num === "I") a -= 1;
	            else if (num === "N") b -= 1;
	            else if (num === "F") c -= 1;
	            else if (num === "P") d -= 1;

	            currentIndex++;
	            updateQuestion();
	        }
	    });
	
	});

	</script>
</body>
</html>