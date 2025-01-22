$(function(){
  //h1.title 을 클릭시 .music-list 를 slidedown 효과 적용
  $("h1.title").click(function(){
    $("ul.music-list").slideToggle();
  });
  //노래 제목 클릭시 이벤트
  $("ul.music-list li").click(function(){
    //노래 제목 얻기
    let title=$(this).text();
    //h1.title 에 넣기
    $("h1.title").text(title);
    //클릭한 곳의 class 얻기
    let selectClass=$(this).attr("class");
    //cd effect 효과(cd 바꾸기)
    $("#cd").animate({width:'0'},'slow',function(){
      //cd 변경하기
      $("#cd").attr("class",selectClass);
      //너비를 다시 300으로
      $(this).animate({width:'300'},'slow');
    });
    //마지막에 노래목록 slideup
    $("ul.music-list").slideUp();
  });
})