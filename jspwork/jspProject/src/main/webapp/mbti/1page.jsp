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
	<b class="start">"나와 비슷한 야채는?"</b>
		<div class ="startbtn" onclick="handleClick(this)">
			
			<span>Start!</span>
		</div>
		<div class ="hidden" id="hiddenDiv">
			<input type="text" class="form-control namebox"
			placeholder="이름 입력">
			<span class="nickname">결과에 나타날 이름을 입력해주세요.</span>
		</div>
		
	</div>
	<script>
	function handleClick(buttonElement) {
        const spanElement = buttonElement.querySelector('span'); // 버튼의 span 요소 가져오기
        const currentText = spanElement.textContent;
        const hiddenDiv = document.getElementById('hiddenDiv');
        

        if (currentText === "Start!") {
            // Start -> Next로 변경
            spanElement.textContent = "Next";
	        hiddenDiv.classList.remove('hidden'); // 'hidden' 클래스 제거
        } else if (currentText === "Next") {
            // Next 상태에서 페이지 이동
            const inputBox = document.querySelector('.namebox'); // input 요소 선택
	        const inputValue = inputBox.value.trim(); // 입력값 가져오기 (앞뒤 공백 제거)
	
	        if (inputValue) {
	            // 입력값이 있는 경우, URL에 포함하여 다음 페이지로 이동
	            window.location.href = "./2page.jsp?name="+inputValue; // 이동할 JSP 파일 경로
	        } else {
	            // 입력값이 없을 경우 경고 메시지 표시
	            alert("이름을 입력해주세요!");
	        }
           
        }
    }

	</script>
</body>
</html>