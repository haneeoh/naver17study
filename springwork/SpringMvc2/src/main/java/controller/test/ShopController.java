package controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopController {
//    @GetMapping({"/shop/addform","/shop/updateform"})
//    public String shopform(Model model)
//    {
//        model.addAttribute("message","데이터 추가 또는 수정 폼 작성");
//        return "result1";
//    }

    //url로 경로를 읽어오는 방법
    @GetMapping("bit/shop/{form}")
            public String shopform(@PathVariable ("form") String form, Model model)
    {
        String message;
        if(form.equals("addform")) {
            message = "상품 추가 폼 작성";
            model.addAttribute("photo", "11.png");
        }else {
            message = "상품 수정 폼 작성";
            model.addAttribute("photo", "03.png");
        }
        model.addAttribute("message",message);
        return "result1";
    }

    @GetMapping("bitcamp/{path1}/{path2}")
    public String hello2(@PathVariable ("path1") String path1, @PathVariable ("path2") String path2, Model model)
    {
        String message="";
        if(path1.equals("shop")) {
            if(path2.equals("list")) {
                message = "전체 상품 목록 출력";
                model.addAttribute("photo", "07.png");
            }else{
                message = "장바구니 상품 목록 출력";
                model.addAttribute("photo", "12.png");
            }
        }else{
            if(path2.equals("list")) {
                message = "게시판 목록 출력";
                model.addAttribute("photo", "04.png");
            }
        }

        model.addAttribute("message",message);
        return "result1";
    }
}
