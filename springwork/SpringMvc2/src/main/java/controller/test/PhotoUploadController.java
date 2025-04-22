package controller.test;

import data.dto.FilenameChange;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class PhotoUploadController {
    @GetMapping("/uploadform")
    public String upload()
    {
        return "upload/uploadform";
    }
    @PostMapping("/uploadprocess")
    public String uploadPhoto(
            HttpServletRequest request,
            @RequestParam String title,
            @RequestParam("upload") MultipartFile upload,
            Model model)
    {
        //업로드할 프로젝트 내의 위치를 지정(webapp/save)
        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
        System.out.println(uploadFolder);

        //업로드할 파일명

        //원래 파일명으로 저장할 경우 같은 이름 업로드시 덮어써지는 문제 발생
        //String uploadFile = upload.getOriginalFilename();

        String uploadFileName = FilenameChange.getDateChangeFilename(upload.getOriginalFilename());

        //업로드
        try {
            upload.transferTo(new File(uploadFolder+"/"+uploadFileName));
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("title", title);
        model.addAttribute("photo", uploadFileName);

        return "upload/uploadresult";
    }
    //파일 여러개 업로드
    @GetMapping("/multiform")
    public String multi()
    {
        return "upload/uploadformmulti";
    }
    @PostMapping("/multiprocess")
    public String multiUpload(
            HttpServletRequest request,
            @RequestParam String title,
            @RequestParam("upload") List<MultipartFile> uploadList,
            Model model
            )
    {
        //제목부터 모델에 저장
        model.addAttribute("title", title);

        //업로드할 프로젝트내의 위치를 지정 (webapp/save)
        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");

        //업로드된 파일명을 저장할 리스트 변수
        List<String> list= new Vector<>();

        //여러개의 파일들을 업로드(파일명은 뒤에 날짜붙여서 업로드)
        for(MultipartFile multiFile : uploadList)
        {
            //업로드할 파일명 구하기
            String uploadFileName = FilenameChange.getRandomChangeFileName(multiFile.getOriginalFilename());

            try {
                multiFile.transferTo(new File(uploadFolder+"/"+uploadFileName));
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            //업로드된 파일명 list 에 추가
            list.add(uploadFileName);
        }
        //list를 모델에 저장
        model.addAttribute("list", list);

        return "upload/uploadresultmulti";
    }

    //ajax
    @GetMapping("/ajaxupload")
    public String ajaxForm()
    {
        return "upload/ajaxphotoupload";
    }

    //사진 업로드 후 json 형태로 파일명 변환
    //ajax 함수를 통해서 호출되는 메서드
    @PostMapping("/oneupload")
    @ResponseBody //일반 컨트롤러기때문에 붙여줘야함
    public Map<String, String> photoUpload(
            HttpServletRequest request,
            @RequestParam("upload") MultipartFile upload
     )
    {
        //업로드할 경우
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        //업로드할 파일명
        String uploadFileName = FilenameChange.getDateChangeFilename(upload.getOriginalFilename());
        //업로드
        try {
            upload.transferTo(new File(uploadPath+"/"+uploadFileName));
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        Map<String,String> map = new HashMap<>();
        map.put("photo", uploadFileName);
        return map;
    }
    //ajax-multi upload
    @GetMapping ("/multiajaxupload")
    public String ajaxmultiform()
    {
        return "upload/ajaxmultiuploadform";
    }

    @PostMapping("/multiupload")
    @ResponseBody
    public List<Map<String,String>> ajaxMultiUpload(
            HttpServletRequest request,
            @RequestParam("upload") List<MultipartFile> uploadList
    )
    {
        List<Map<String,String>> list= new Vector<>();

        //업로드할 프로젝트내의 위치를 지정 (webapp/save)
        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");

        //여러개의 파일들을 업로드(파일명은 UUID로 업로드)
        for(MultipartFile multiFile : uploadList)
        {
            //업로드할 파일명 구하기
            String uploadFileName = FilenameChange.getRandomChangeFileName(multiFile.getOriginalFilename());

            try {
                multiFile.transferTo(new File(uploadFolder+"/"+uploadFileName));
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            //업로드된 파일명 list 에 추가
            Map<String,String> map = new HashMap<>();
            map.put("photo", uploadFileName);
            list.add(map);
        }
        return list;
    }
}
