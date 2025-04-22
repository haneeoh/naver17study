package member.controller;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/member")//Mapping 의 board 로 시작되는부분을 미리 저장해서 생략해준다
public class MemberAddController {

    @Autowired
    MemberService memberService;

    //버켓이름
    private String bucketName="bitcamp-bucket-119";//자기 버켓 이름

    @Autowired
    NcpObjectStorageService storageService;

    @GetMapping("/form")
    public String form() {
        return "member/memberform";
    }

    //아이디가 존재하면 result 에 fail 를, 존재하지 않으면 success 를 json 보내기
    @GetMapping("/idcheck")
    @ResponseBody
    public Map<String, String> idCheck(@RequestParam String myid)
    {
        Map<String, String> map = new HashMap<>();
        if(memberService.isMyidCheck(myid))
            map.put("result","fail");
        else
            map.put("result","success");
        return map;
    }

    @PostMapping("/insert")
    public String insert(HttpServletRequest request,
                         @ModelAttribute MemberDto dto,
                         @RequestParam("upload")MultipartFile upload
    )
    {
        //업로드할 save 경로 구하기
//        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
//
//        //사진 선택을 하지 않았을 경우 upload 의 파일명 확인 후
//        //사진 선택을 하지 않았다면 upload 하지말고(transferTo 실행X) mphoto에 "no"저장
//        String mphoto="";
//
//        String uploadFilename = UUID.randomUUID()+"."+(upload.getOriginalFilename().split("\\.")[1]);
//        if(upload.getOriginalFilename()==""||upload.getOriginalFilename()==null){
//            mphoto="no";
//        }else{
//            try {
//                upload.transferTo(new File(uploadFolder+"/"+uploadFilename));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        mphoto=uploadFilename;
//        dto.setMphoto(mphoto);
//        memberService.insertMember(dto);

        System.out.println("filename:"+upload.getOriginalFilename());

        if(upload.getOriginalFilename().equals("")) {
            dto.setMphoto("no");
        }else {
            //네이버 스토리지에 사진 저장하기
            //네이버 오브젝트스토리지에 사진을 업로드 후 업로드한 파일명을 변환
            String uploeFilename = storageService.uploadFile(bucketName, "member", upload);
            dto.setMphoto(uploeFilename);
        }

        memberService.insertMember(dto);

        return "redirect:../";//일단은 main 으로 이동
    }

}
