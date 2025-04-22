package test.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.data.FoodDto;

import java.util.Date;
import java.util.List;
import java.util.Vector;

@Controller
public class TestController {

    @GetMapping("/")
    public String home() {
        return "food/home";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Have a nice day");
        model.addAttribute("myfood", "bottle03.jpg");
        return "food/hello";
    }

    @GetMapping("/hello2")
    public String hello2(Model model, @RequestParam String name, @RequestParam int age) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "food/hello2";
    }

    @GetMapping("/hello3")
    public String hello3(Model model) {
        FoodDto dto = FoodDto.builder()
                .foodName("망고빙수")
                .foodPhoto("10.jpg")
                .foodPrice(15000)
                .build();
        model.addAttribute("dto", dto);
        model.addAttribute("bgcolor", "#00ff7f");
        model.addAttribute("today", new Date());
        return "food/hello3";
    }

    @GetMapping("/hello4")
    public String hello4(Model model) {
        List<FoodDto> list = new Vector<>();
        list.add(new FoodDto("야채샌드위치", 12000, "1.jpg"));
        list.add(new FoodDto("망고빙수", 15000, "5.jpg"));
        list.add(new FoodDto("햄마요덮밥", 8000, "10.jpg"));
        list.add(new FoodDto("순두부라면", 9000, "3.jpg"));
        list.add(new FoodDto("김치볶음밥", 14000, "6.jpg"));

        model.addAttribute("list", list);
        return "food/hello4";
    }

    @GetMapping("/hello5")
    public String hello5(Model model, @RequestParam String myid, HttpSession session) {
        session.setAttribute("loginid", myid);

        return "food/hello5";
    }

}












