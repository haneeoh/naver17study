package json.test;

import data.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//컨트롤러는 기본 기능이 포워드 또는 리다이렉트
//json 데이터로 변환하려면 @ResponseBody 를 앞에 표기
@Controller
public class JsonRestController2 {
    @GetMapping("/test")
    @ResponseBody public TestDto test1()
    {
        TestDto dto=new TestDto("이영자","서울시","여성");
        return dto; //json 데이터로 변환
    }
}
