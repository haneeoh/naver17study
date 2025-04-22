package bitcamp.study;

import lombok.test.TestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Vector;

@RestController
public class BitController {
    //@RestController 는 출력시 json
    @GetMapping("/hello")
    public List<TestDto> list(){
        List<TestDto> list=new Vector<>();
        list.add(new TestDto("강호동","서울","010-1111-5555"));
        list.add(new TestDto("이미자","부산","010-1111-5445"));
        list.add(new TestDto("손석구","대구","010-1145-5555"));
        return list;
    }
}
