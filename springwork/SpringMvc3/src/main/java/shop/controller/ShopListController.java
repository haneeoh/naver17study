package shop.controller;

import data.dto.ShopDto;
import data.service.ShopRepleService;
import data.service.ShopService;
import naver.storage.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShopListController {
    @Autowired
    ShopService shopService;

    @Autowired
    ShopRepleService repleService;

    String bucketName="bitcamp-bucket-119";

    @Autowired
    NcpObjectStorageService storageService;

    @GetMapping("/shop/list")
    public String shopList(Model model)
    {
        //총 상품 갯수
        int totalCount = shopService.getTotalCount();
        //전체상품
        List<ShopDto> list=shopService.getAllSangpum();
        //메인사진 등록
//        for(ShopDto dto:list)
//        {
//            String mainPhoto = dto.getSphoto().split(",")[0];//,로 연결된 사진 중 첫번째 사진
//        }
        for(int i=0;i<list.size();i++)
        {
            ShopDto shopDto=list.get(i);
            String mainPhoto= shopDto.getSphoto().split(",")[0];
            shopDto.setMainPhoto(mainPhoto);

            //댓글수 저장
            int replecount=repleService.getRepleByNum(shopDto.getNum()).size();
            shopDto.setReplecount(replecount);
        }
        //모델에 저장
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("list", list);
        model.addAttribute("naverurl","https://kr.object.ncloudstorage.com/bitcamp-bucket-119");
        model.addAttribute("fronturl", "https://vklc97wn8729.edge.naverncp.com/0MUXH8T8uE");
        model.addAttribute("backurl", "?type=f&w=80&h=80&faceopt=true&ttype=jpg");
        //포워드
        return "shop/shoplist";
    }
}
