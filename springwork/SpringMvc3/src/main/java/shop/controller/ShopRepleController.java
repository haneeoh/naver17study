package shop.controller;

import data.dto.ShopRepleDto;
import data.service.ShopRepleService;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController//포워드 리다이렉트 안되고 데이터처리만 가능. ResponsBody 안붙여도 되고 에이젝스로 처리
public class ShopRepleController {
    @Autowired
    ShopRepleService repleService;

    private String bucketName="bitcamp-bucket-119";

    @Autowired
    NcpObjectStorageService storageService;

    @PostMapping("/shop/addreple")
    public void insertReple(
            HttpServletRequest request,
            @RequestParam int num,
            @RequestParam String message,
            @RequestParam("upload") MultipartFile upload
            )
    {
        System.out.println(upload.getOriginalFilename()+","+message);
//        //save 의 실제경로 구하기
//        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
//        //업로드할 파일명 구하기 : UUID.확장자
//        String uploadFileName = UUID.randomUUID()+"."+upload.getOriginalFilename().split("\\.")[1];
//        //사진업로드
//        try {
//            upload.transferTo(new File(uploadFolder+"/"+uploadFileName));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //네이버스토리지에 업로드
        String uploadFileName=storageService.uploadFile(bucketName,"shop",upload);

        //dto생성 num message file명
        ShopRepleDto dto = new ShopRepleDto();
        dto.setNum(num);
        dto.setMessage(message);
        dto.setPhoto(uploadFileName);

        //db insert
        repleService.insertShopReple(dto);
    }

    @GetMapping("/shop/replelist")
    public List<ShopRepleDto> repleList(@RequestParam int num)
    {
        List<ShopRepleDto> list=null;
        list=repleService.getRepleByNum(num);

        return list;
    }

    @GetMapping("/shop/repledelete")
    public  void deleteReple(@RequestParam int idx,@RequestParam String rphoto,
    HttpServletRequest request)
    {
//        //삭제할 save 경로 구하기
//        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
//        File file=new File(uploadFolder+"/"+rphoto);
//        if(file.exists())
//            file.delete();

        String photo=repleService.getPhoto(idx);
        storageService.deleteFile(bucketName,"shop",photo);

        repleService.deleteShopReple(idx);
    }

    @GetMapping("/shop/likes")
    public Map<String, Integer> getLikes(@RequestParam int idx)
    {
        //likes 1 증가
        repleService.updateLikes(idx);
        //최종 likes 받기
        int likes=repleService.getLikes(idx);
        //Map
        Map<String, Integer> map=new HashMap<>();
        map.put("likes",likes);
        return map;
    }

}
