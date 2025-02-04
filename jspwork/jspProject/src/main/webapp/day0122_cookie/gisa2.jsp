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
	배우 임세미가 tvN 새 월화드라마 ‘그놈은 흑염룡’(연출 이수현 극본 김수연)에서
	문가영, 최현욱의 흑역사를 아는 유일한 ‘연결고리’ 인물로 활약한다.

	‘그놈은 흑염룡’은 흑역사에 고통 받는 ‘본부장 킬러’ 팀장 백수정(문가영 분)과
	가슴에 흑염룡을 품은 ‘재벌 3세’ 본부장 반주연(최현욱 분)의 봉인해제 로맨스다.
	동명의 인기 웹툰을 원작으로 한다. 문가영, 최현욱, 임세미, 곽시양 등이 출연한다.
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