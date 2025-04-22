package controller.test;

import data.dto.MyCloudProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyCloudController {
    @Autowired
    MyCloudProps myCloudProps;
    @GetMapping("/prop2")
    public String prop2(Model model) {
        model.addAttribute("db", myCloudProps.getDb());
        model.addAttribute("username", myCloudProps.getUsername());
        model.addAttribute("password", myCloudProps.getPassword());
        return "result4";
    }
}
