package member.controller;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

//@AllArgsConstructor
//final 붙인 멤버변수만 자동주입
@RequiredArgsConstructor

@Controller
@RequestMapping("/member")
public class MemberListController {
//    @Autowired
    final MemberService memberService;

    //버켓이름
    private String bucketName="bitcamp-bucket-119";

//    @Autowired
    final NcpObjectStorageService storageService;

    @GetMapping("/list")
    public String memberList(Model model) {
        //총 인원수
        int totalCount = memberService.getTotalCount();
        //전체 리스트
        List<MemberDto> list=memberService.getAllMember();

        for(int i=0;i<list.size();i++){
            MemberDto memberDto=list.get(i);
        }

        model.addAttribute("list", list);
        model.addAttribute("totalCount", totalCount);
//        model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/bitcamp-bucket-119");
        model.addAttribute("fronturl", "https://vklc97wn8729.edge.naverncp.com/0MUXH8T8uE");
        model.addAttribute("backurl", "?type=f&w=30&h=30&faceopt=true&ttype=jpg");
        return "member/memberlist";
    }

    @GetMapping("/delete")
    public String deleteMember(@RequestParam int num)
    {
        memberService.deleteMember(num);
        return "redirect:./list";
    }

    @GetMapping("/mypagedel")
    public void mypageDelete(@RequestParam int num,HttpSession session)
    {
        memberService.deleteMember(num);
        //모든 세션 제거
        session.removeAttribute("loginstatus");
        session.removeAttribute("loginid");
        session.removeAttribute("loginphoto");
    }

    @GetMapping("/checkdel")
    @ResponseBody //ajax 호출
    public void checkDeleteMember(@RequestParam String nums)
    {
        //삭제할 num들을 배열로
        String [] num=nums.split(",");
        for(String str:num)
        {
            int n=Integer.parseInt(str);
            memberService.deleteMember(n);
        }
    }

    @GetMapping("/mypage")
    public String goMypage(HttpSession session, Model model)
    {
        //세션으로부터 아이디를 얻는다
        String myid=(String)session.getAttribute("loginid");
        //아이디에 해당하는 dto 얻기
        MemberDto dto=memberService.getSelectByMyid(myid);
        //모델에 dto 저장
        model.addAttribute("dto", dto);
        model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/bitcamp-bucket-119");
        return "member/mypage";
    }

    @PostMapping("/changephoto")
    @ResponseBody
    public void changePhoto(
            HttpServletRequest request,
            @RequestParam("upload")MultipartFile upload,
            @RequestParam("num") int num,
            HttpSession session
            ){
//        //save 경로
//        String uploadFolder=request.getSession().getServletContext().getRealPath("/save");
//        //기존파일명 얻기
//        String oldFilename=memberService.getSelectByNum(num).getMphoto();
//        //기존파일 삭제
//        File oldFile=new File(uploadFolder+"/"+oldFilename);
//        if(oldFile.exists())
//            oldFile.delete();
//        //업로드할 파일명
//        String uploadFileName= UUID.randomUUID()+"."+upload.getOriginalFilename().split("\\.")[1];
//        //업로드
//        try {
//            upload.transferTo(new File(uploadFolder+"/"+uploadFileName));
//            //session도 변경
//            session.setAttribute("loginphoto",uploadFileName);
//
//            //db도 사진변경
//            memberService.changePhoto(num, uploadFileName);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //사진 수정시 db에 저장된 파일명을 받아서 스토리지에서 삭제 후 추가할 것
        String oldFilename=memberService.getSelectByNum(num).getMphoto();
        storageService.deleteFile(bucketName,"member",oldFilename);

        //네이버 스토리지에 업로드
        String uploadFilename=storageService.uploadFile(bucketName,"member",upload);
        //db에서도 수정
        memberService.changePhoto(num,uploadFilename);
        //세션도 변경
        session.setAttribute("loginphoto",uploadFilename);
    }

    @PostMapping("/update")
    @ResponseBody
    public void update(@ModelAttribute MemberDto dto) {
        System.out.println(dto.getNum());

        memberService.updateMember(dto);
    }
}
