package controller.test;

import data.dto.MyPropDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@AllArgsConstructor //이걸 사용하면 모든 멤버변수에 자동주입
public class MyPropController {
    @Autowired //이것만 해도되고
    MyPropDto propDto;

    //dto 통하지않고 바로 읽어오기
    @Value("${server.port}")
    int port;
    @Value("${emp.addr}")
    String addr;

    @GetMapping("/prop1")
    public String prop1(Model model) {
        model.addAttribute("addr", propDto.getAddr());
        model.addAttribute("hp", propDto.getHp());
        model.addAttribute("msg", "서버 포트는 "+port+" 이고 지역은 "+addr+" 입니다.");
        return "result3";
    }
}
