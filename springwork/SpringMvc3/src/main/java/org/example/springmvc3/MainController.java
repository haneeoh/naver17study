package org.example.springmvc3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String goMain()
    {
        return "main/mainpage";
    }
}
