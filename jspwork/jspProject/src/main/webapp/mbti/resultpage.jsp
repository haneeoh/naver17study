<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
	<%
    // URL 파라미터 값 추출
    String name = request.getParameter("name");
    String a = request.getParameter("a");
    String b = request.getParameter("b");
    String c = request.getParameter("c");
    String d = request.getParameter("d");
    
	%>
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
<script>
	const name = "<%= name %>";
    const a = parseInt("<%= a %>");
    const b = parseInt("<%= b %>");
    const c = parseInt("<%= c %>");
    const d = parseInt("<%= d %>");
/*     console.log("a",a);
    console.log("b",b);
    console.log("c",c);
    console.log("d",d);
     */
    let aa="";
    let bb="";
    let cc="";
    let dd="";
    
    if (a>0){
    	aa="I";
    }else{
    	aa="E";
    }
    
    if (b>0){
    	bb="N";
    }else{
    	bb="S";
    }
    
    if (c>0){
    	cc="F";
    }else{
    	cc="T";
    }
    
    if (d>0){
    	dd="P";
    }else{
    	dd="J";
    }
    
    let result=aa+bb+cc+dd;
/*      console.log("aaa",result);  */
    
    $(document).ready(function(){
    	$(".image").html(`
    		<b class="title" style="color: #ccdae5;font-size: 60px;position: absolute; font-family: 'Micro 5'; left:175px;top:25px;">\${result}</b><br>
            <img src= "./mbtiimg/\${result}.png">
    `);
    		list();
    });
    
    $(function(){
    	//저장버튼
    	$("#btnsave").click(function(){
    		let message=$("#message").val();
    		
    		$.ajax({
    			type:"get",
    			dataType:"xml",
    			data:{"message":message},
    			url:"./r_insert.jsp",
    			success:function(res){
    				alert($(res).find("result").text());

 					$("#message").val("");
 					
 					//목록 다시 출력
 					list();
    			}
    		});
    	});
    	
    	//삭제버튼
    	$(document).on("click",".del",function(){
			let ans=confirm("현재 댓글을 삭제하시겠습니까?");
			let idx=$(this).attr("idx");
			
			if(ans){
				$.ajax({
					type:"get",
					dataType:"html", //json, xml이 내용에 없으면 html만 보내야함
					data:{"idx":idx},
					url:"./r_delete.jsp",
					success:function(){
						//삭제 후 목록 다시 출력
						list();
					}
				});
			}
			
		});
    	
    });
    
    function list(){
    	$.ajax({
 			type: "get",
 			dataType: "json",
 			url: "./r_list.jsp",
 			success:function(res)
 			{
 				writedata(res);
 			}
 		});
    }
    
    function writedata(res)
    {
    	let s="";
    	s=`<b>총 \${res.length} 개의 댓글이 있습니다.</b><br><br>`;
		//반복문
		
		$.each(res,function(idx,ele){
	    	s+=`
				<span class="rename">\${name}&nbsp;</span>
				<span class="rembti">\${result}&nbsp;</span>
				<span class="rewriteday">\${ele.writeday}</span><br>
				<span>\${ele.message}</span>
				<span style="float:right;">
				<i class="bi bi-trash del" style="cursor:pointer;" idx=\${ele.idx}></i>
				</span>
				<hr>
			`;
		});
		
		$(".memolist").html(s);
    }
    
	</script>
	<div class="box2">
		<div class="image"></div>
			<div class="memobox" style="position: absolute;top:550px;left:20px;color:#ccdae5;">
				<div class="input-group">
					<input type="text" id="message" class="form-control"
					placeholder="메세지 입력" style="width:350px;">
					&nbsp;&nbsp;
					<button type="button" class="btn btn-sm btn-success"
					id="btnsave">저장</button>
				</div><br>
				<div class="memolist"></div>
			</div>
	</div>
	
</body>
</html>