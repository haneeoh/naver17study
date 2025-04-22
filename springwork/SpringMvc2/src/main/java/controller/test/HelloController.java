package controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class HelloController {

    @GetMapping("/")
//    public ModelAndView hello1()
//    {
//        ModelAndView mview=new ModelAndView();
//        mview.addObject("message","오늘은 월요일입니다");//request 에 저장
//        mview.setViewName("hello"); //WEB-INF/hello.jsp 중간 경로가 있다면 hello 앞에 쓰면됨
//        return mview;
//    }
    public String hello(Model model) //방법2
    {
        model.addAttribute("message", "오늘은 월요일입니다.");
        model.addAttribute("today", new Date());
        return "hello";
    }
}
