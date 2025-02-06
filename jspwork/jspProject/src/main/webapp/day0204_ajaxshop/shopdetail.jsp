<%@page import="java.text.SimpleDateFormat"%>
<%@page import="shop.data.shopDto"%>
<%@page import="shop.data.shopDao"%>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <%
	//1. num 읽기
	int num=Integer.parseInt(request.getParameter("num"));
	//2. dao 선언
	shopDao dao=new shopDao();	
	//3. num 에 해당하는 dto 얻기 (dao 에 메서드 추가해야함 : getSangpum(int num))
	shopDto dto=dao.getSangpum(num);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	%>
    <style>
        body *{
          font-family: 'Jua';
        }
        .tabdetail {
        	margin: 30px;
        	width: 500px;
        	font-size: 15px;
        	
        }
        .tabdetail img{
        	width: 200px;
        	height: 250px;
        	text-align: center;
        }
        .day{
        	font-size: 12px;
        	color: gray;
        }
        .all{
        	font-size:1.2em;
        	margin-left: 30px;
        	cursor: pointer
        }
        .exit{
        	cursor: pointer;
        	color : red;
        	font-size: 0.7em;
        }
        .msg{
        	font-size:1.2em;
        }
    </style>
</head>


<body>
	<!-- table 을 이용해서 상세페이지 만들기 -->
	<table class="table table-bordered tabdetail">
		<tr>
			<td rowspan="7" style="width: 220px;">
				<img src="<%=dto.getSphoto() %>">
			</td>
		</tr>
		<tr>
			<td>상품명 : <%=dto.getSangpum() %></td>
		</tr>
		<tr>
			<td>
				<span style="background-color: <%=dto.getScolor() %>">
					color : <%=dto.getScolor() %>
				</span>
			</td>
		</tr>
		<tr>
			<td>수량 : <%=dto.getScnt() %></td>
		</tr>
		<tr>
			<td>단가 : <%=dto.getSprice() %></td>
		</tr>
		<tr>
			<td>입고일 : <%=dto.getIpgoday() %></td>
		</tr>
		<tr>
			<td>작성일 : <%=dto.getWriteday() %></td>
		</tr>
		<!-- 하단에 수정, 삭제, 목록 버튼 넣기(목록은 연결해놓기) -->
		<tr>
			<td colspan="2" style="text-align: center;">
			<button type="button" class="btn btn-success bnt-sm"
			id="btnupdate" data-bs-toggle="modal" data-bs-target="#shopModal">
			수정
			</button>
			<button type="button" class="btn btn-success bnt-sm"
			id="btndelete">삭제</button>
			<button type="button" class="btn btn-success bnt-sm"
			onclick="location.href='./shopmain.html'">목록</button>
			</td>
		</tr>
	</table>
	
	<!-- 상품등록 다이얼로그 -->
	<div class="modal" id="shopModal">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	
	      <!-- 제목 -->
	      <div class="modal-header">
	        <h4 class="modal-title">상품 수정</h4><hr>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	      <!-- Modal body -->
	      <div class="modal-body">
	
	      <!-- 폼으로 수정해보자 -->
	      
	      <form id="shopfrm">
       	  	<input type="hidden" name="num" id="num">
			<table class="table table-bordered">
			<tr>
				<td width="100" style="background-color: lightgray;">상품사진</td>
				<td>
					<select id="sphoto" name="sphoto" class="form-select">
						  <script>
						  	for(let i=1;i<=34;i++){
						  		let s=`<option value='../image/photo2/\${i}.\${i==24?"gif":"jpg"}'>상품 \${i}</option>`;
						  		document.write(s);
						  	}
						  </script>
					 </select>
					 <br>
					<img src="" class="shopphoto" width="100">
					
					<script type="text/javascript">
						$(".shopphoto").attr("src",$("#sphoto").val());
						
						//이벤트
						$("#sphoto").change(function(){
							$(".shopphoto").attr("src",$(this).val());
						});
					</script>
			 </td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품명</td>
				<td>
					<input type="text" name="sangpum" id="sangpum"
				class="form-control">
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품색상</td>
				<td>
					<input type="color" name="scolor" id="scolor">
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품가격</td>
				<td>
					<input type="text" name="sprice" id="sprice" 
					  class="form-control">
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품갯수</td>
				<td>
					<input type="number" name="scnt" id="scnt" 
					  class="form-control" min="1" max="10">
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">입고일</td>
				<td>
					<input type="date" name="ipgoday" id="ipgoday" 
					  class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit"  data-bs-dismiss="modal" style="width: 120px;"
					class="btn btn-sm btn-success">수정하기</button>
				</td>
			</tr>			
		</table>
       </form>
       </div>
     </div>
   </div>
   </div>
   <div class="replelist">
	   		<h6	style="margin-left: 30px;"><b>상품평을 등록해주세요</b></h6>
	   		<div class="input-group" style="width:600px; margin-left: 30px;">
	   			<span>평점 : </span>&nbsp;&nbsp;
	   			<select id="selstar">
	   				<option value="1">⭐</option>
	   				<option value="2">⭐⭐️</option>
	   				<option value="3">⭐⭐️⭐️</option>
	   				<option value="4">⭐⭐️⭐️⭐️</option>
	   				<option value="5">⭐⭐️⭐️⭐️⭐️</option>
	   			</select>&nbsp;&nbsp;
	   			<input type="text" id="message" class="form=control"
	   			style="width:280px" placeholder="메세지 입력">&nbsp;&nbsp;
	   			<button type="button" class="btn btn-sm btn-success"
				id="btnok">OK</button><br>
	   		</div>
	</div>
   		
       <!-- 출력위치 -->
       <br>
       <div class="all">aa</div>
       <div class="replelistall alert alert-warning"
       style="margin: 30px;width: 500px;">
       111
       </div>
       <script type="text/javascript">
       $(function(){
    	   list(); //처음 로딩시 전체 댓글 출력
    	   
    	   //OK 버튼 이벤트
    	   $("#btnok").click(function(){
    		   let num=<%=num%>;
    		   let star=$("#selstar").val();
    		   let message=$("#message").val();
    		   
    		   $.ajax({
    			  type:"get",
    			  dataType:"html",
    			  data:{"num":num,"star":star,"message":message},
    			  url:"./insertreple.jsp",
    			  success:function(res){
    				  alert($(res).find("result").text());
    				  list();
    				  
    				  $("#selstar").val("5");
    				  $("#message").val("");
    			  }
    		   });
    	   });
       });
       
       function list()
       {
    	   $.ajax({
    		  type: "get",
    		  dataType: "json",
    		  data:{"num":<%=num%>},
    		  url: "./listreple.jsp",
    		  success:function(res)
    		  {
    			  let n=$(res).length;
    			  $(".all").text("총 "+n+"개의 상품평이 있습니다.");
    			  let s="";
    	    	   //반복문
    	    	   $.each(res,function(idx,ele){
							for(let i=1;i<=ele.star;i++){
								s+=`⭐`;
							}
							s+=`<span class="day">\${ele.writeday}</span>`;
							s+="<br>";
							s+=`<span class="msg" style="margin-top: 10px;">\${ele.message}</span>`;
							s+=`<span idx="\${ele.idx}">&nbsp;&nbsp;</span>`;
							s+=`<span class="exit" idx="\${ele.idx}"><i class="bi bi-x-square"></i></span><br>`;
							s+="<hr>";
    	    	   });
    	    	   $(".replelistall").html(s);
    		  }
    	   });
       }
       //상품평 삭제이벤트
       	$(document).on("click","span.exit",function(){
       		let idx=$(this).attr("idx");
       		if(confirm("상품평을 삭제하시겠습니까?")){
       			$.ajax({
       				type:"get",
       				dataType:"html",
       				data:{"idx":idx},
       				url:"./deletereple.jsp",
       				success:function(){
       					list();
       				}
       			});
       		}
       	});
       //상품평 나타내기 숨기기
       $(".all").click(function(){
    	   $(".replelistall").slideToggle('fast');
       });
       
		$("#btndelete").click(function(){
			//confirm 으로 물어보고 [확인]누르면 삭제
			let ans=confirm("상품 정보를 삭제하시겠습니까?");
			//data로 num을 보낸다
			//ajax 함수 이용해서 한다
			if(ans){
				$.ajax({
					type:"get",
					dataType:"html",
					data:{"num":<%=num%>},
					url:"./deleteshop.jsp",
					//success 에서 목록으로 이동
					success:function(){
						location.href="./shopmain.html";
					}
				});
			}

		});
		
		$("#btnupdate").click(function(){
			//수정 다이얼로그가 뜨면 데이터 수정 후 (ajax)
			//현재 디테일 페이지 새로고침(location.reload())
			$.ajax({
				type:"get",
				dataType:"json",
				data:{"num":<%=num%>},
				url:"./getdatajson.jsp",
				success:function(res){
					$("#num").val(res.num);
					
					$("#sphoto").val(res.sphoto);
					$(".shopphoto").attr("src",res.sphoto);
					
					$("#sangpum").val(res.sangpum);
					
					$("#scolor").val(res.scolor);

					
					$("#sprice").val(res.sprice);
					
					$("#scnt").val(res.scnt);
					
					$("#ipgoday").val(res.ipgoday);
				}
			});
			
		});
		
		//submit 이벤트
		$("#shopfrm").submit(function(e){
			//alert("submit");
			e.preventDefault();
			
			//form 의 value를 get으로 가져온다
			let d=$(this).serialize();
			//alert(d);
			$.ajax({
				type:"get",
				dataType:"html",
				data:d,
				url:"./updateshop.jsp",
				success:function(){
					location.reload();
				}
			});
		});
     	
	</script>
</body>
</html>