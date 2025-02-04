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
	22일 방송된 KBS 쿨FM '이은지의 가요광장'에는 스페셜 DJ 준케이가 진행하고
	'독수리 5형제를 부탁해' 엄지원, 안재욱이 출연했다.

	오는 2월 1일 첫방송하는 '독수리 5형제를 부탁해'에서 한동석 역의 안재욱은
	"회장님 역할은 처음이다. 스타일리스트와 의상, 외적인 부분에 고민하고 있다.
	회장도 회장이지만, 빈틈없는 성격이다보니 관리하고 꾸미는 것에 대해 철저할 것 같다"라고 말했다.
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









