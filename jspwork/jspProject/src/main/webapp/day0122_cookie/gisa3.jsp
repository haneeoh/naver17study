<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        body *{
          font-family: 'Jua';
        }
    </style>
</head>
<%	
	boolean blogin=false;
	
	//현재 브라우저에 저장된 모든 쿠기값 얻기. 없을경우 null 값.
	Cookie []cookies=request.getCookies();
	if(cookies!=null)
	{
		for(int i=0;i<cookies.length;i++)
		{
			//loginok 라는 쿠키가 있는지 검사
			if(cookies[i].getName().equals("loginok")){
				blogin=true;
				break;
			}
		}
	}
%>
<body>
<%
	if(blogin){%>
	<pre>
	김종국이 결혼 조건에 관해 꼭 초혼일 필요 없다는 말에 수긍했다.

	지난 21일 방송된 SBS 예능 '틈만나면,'에서는 차태현과 김종국이 출연했다.
	1976년생 동갑내기인 두 사람은 1972년생 유재석에게 "50대는 어떤 느낌이냐"고 묻자,
	유재석은 "별로다"라 답했다. 김종국은 "50대가 되면 가족이 있는 것과 혼자인 건
	많이 다르다"며 자신의 솔로 생활에 대한 소회를 털어놨다.
	</pre>
	<%}else{%>
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요");
			history.back();//이전 페이지로 이동
		</script>
	<%}
%>
</body>
</html>