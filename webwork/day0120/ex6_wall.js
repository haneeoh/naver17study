$(function(){
  //벽지 이미지 클릭시 이벤트
  $("ul.list img").click(function(){
    //부모태그인 Li에 active class 추가
    $(this).parent().addClass("active");
    
    //부모의 형제들(li)에게 추가된 active class 제거
    $(this).parent().siblings().removeClass("active");

    //클릭한 이미지의 title 얻기
    let title=$(this).attr("title");
    //title 을 h1.title 에 넣기
    $("h1.title").text(title);
    //이미지 src 넣기
    let imgSrc=$(this).attr("src");
    //이미지 src를 .wall 에 백그라운드 형태로 넣기
    let url=`url(${imgSrc})`;
    $(".wall").css("background-image",url);
  });
});