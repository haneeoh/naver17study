package shop.controller;

import data.dto.ShopDto;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ShopDetailDeleteController {
    @Autowired
    ShopService shopService;

    private String bucketName="bitcamp-bucket-119";

    @Autowired
    NcpObjectStorageService storageService;

    @GetMapping("/shop/detail")
    public String shopDetail(@RequestParam int num, Model model)
    {
        ShopDto dto=shopService.getSangpum(num);
        String mainPhoto=dto.getSphoto().split(",")[0];
        dto.setMainPhoto(mainPhoto);

        model.addAttribute("dto", dto);
        model.addAttribute("naverurl","https://kr.object.ncloudstorage.com/bitcamp-bucket-119");
        model.addAttribute("fronturl", "https://vklc97wn8729.edge.naverncp.com/0MUXH8T8uE");
        model.addAttribute("backurl", "?type=f&w=80&h=80&faceopt=true&ttype=jpg");
        return "shop/detail";
    }
    
    @GetMapping("/shop/delete")
    public String delete(@RequestParam int num,
                        HttpServletRequest request
    )
    {
//        //삭제할 save 경로 구하기
//        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
//        //파일 가져오기
//        ShopDto dto=shopService.getSangpum(num);
//
////        System.out.println(dto.getSphoto());
//
//        String[] list = dto.getSphoto().split(",");
//
//        for(int i=0;i<list.length;i++)
//        {
//            File file=new File(uploadFolder+"/"+list[i]);
//            file.delete();
//        }
//        shopService.deleteShop(num);

        //사진 명 얻기
        String photos=shopService.getSangpum(num).getSphoto();
        //,로 분리
        String []photo = photos.split(",");
        //네이버스토리지의 사진 삭제
        for(String f:photo)
        {
            storageService.deleteFile(bucketName,"shop",f);
        }

        shopService.deleteShop(num);
        return "redirect:./list";
    }

    @GetMapping("/shop/photos")
    public String shopPhotos(@RequestParam int num, Model model)
    {
        //num에 해당하는 사진 얻기
        String sphoto=shopService.getSangpum(num).getSphoto();
        model.addAttribute("num", num);
        model.addAttribute("sphoto", sphoto);
        model.addAttribute("fronturl", "https://vklc97wn8729.edge.naverncp.com/0MUXH8T8uE");
        model.addAttribute("backurl", "?type=f&w=120&h=120&faceopt=true");
        return "shop/photos";
    }

    @GetMapping("/shop/delphoto")
    @ResponseBody
    public void deletePhoto(@RequestParam int num,@RequestParam String pname,HttpServletRequest request)
    {
//        //삭제할 save 경로 구하기
//        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
//        //스토리지 사진 삭제
//        File file=new File(uploadFolder+"/"+pname);
//        if(file.exists())
//            file.delete();

        storageService.deleteFile(bucketName,"shop",pname);

        //num에 해당하는 sphoto를 db에서 얻는다
        String sphoto=shopService.getSangpum(num).getSphoto();
        //sphoto 에서 pname 부분을 삭제하는데 중간일 경우 뒤에 컴마도 삭제
        String changephoto="";
        if(sphoto.endsWith(pname))
            changephoto=sphoto.replace(pname,"");
        else
            changephoto=sphoto.replace(pname+",","");
        //변경된 changephoto를 updatePhoto를 통해 보낸다

        shopService.updatePhoto(num,changephoto);
    }

    @PostMapping("/shop/addphoto")
    @ResponseBody
    public void addPhoto(@RequestParam int num,
                         @RequestParam("upload") List<MultipartFile> uploadList,
    HttpServletRequest request)
    {
//        //업로드 경로 구하기
//        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
//        //새로 업로드할 파일명 구할 변수
//        String photos="";
//        for(MultipartFile file:uploadList)
//        {
//            //업로드할 파일명
//            String uploadFilename= UUID.randomUUID()+"."+file.getOriginalFilename().split("\\.")[1];
//            photos+= uploadFilename+",";
//            //업로드
//            try {
//                file.transferTo(new File(uploadFolder+"/"+uploadFilename));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        String photos="";
        for(MultipartFile file:uploadList)
        {
            String uploadFilename=storageService.uploadFile(bucketName,"shop",file);
            photos+=uploadFilename+",";
        }
        //마지막 컴마 제거
        photos=photos.substring(0,photos.length()-1);
        //db에서 sphoto 얻기
        String sphoto=shopService.getSangpum(num).getSphoto();
        //sphoto 값이 없을 경우 photos 를 대입하고, 이미 있을경우 ","를 추가하고 photos 추가
        if(sphoto.length()==0)
            sphoto=photos;
        else
            sphoto=sphoto+","+photos;
        //db 에서 sphoto 수정
        shopService.updatePhoto(num,sphoto);
    }

}
