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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@Controller
public class UploadMunjeController {
    @GetMapping("/munjeupload1")
    public String munje1() {
        return "uploadmunje/uploadform1";
    }

    @PostMapping("/munjeprocess1")
    @ResponseBody
    public Map<String, String> upload1(
            HttpServletRequest request,
            @RequestParam String title,
            @RequestParam("upload") MultipartFile upload
    ) {
        Map<String, String> map = new HashMap<>();
        //업로드할경우
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        //업로드할 파일명
        String uploadFileName = FilenameChange.getDateChangeFilename(upload.getOriginalFilename());
        //업로드
        try {
            upload.transferTo(new File(uploadPath + "/" + uploadFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        map.put("title", title);
        map.put("photo", uploadFileName);

        return map;
    }

    @GetMapping("/munjeupload2")
    public String munje2() {
        return "uploadmunje/munjeuploadform";
    }

    @PostMapping("/munjeprocess2")
    public String multimunje2(
            HttpServletRequest request,
            @RequestParam String title,
            @RequestParam ("upload")List<MultipartFile> uploadList,
            Model model
            ){
        model.addAttribute("title", title);
        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
        List<String> list= new Vector<>();
        for(MultipartFile multiFile : uploadList)
        {
            String uploadFileName = FilenameChange.getDateChangeFilename(multiFile.getOriginalFilename());

            try {
                multiFile.transferTo(new File(uploadFolder+"/"+uploadFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            list.add(uploadFileName);
        }
        model.addAttribute("list", list);
        return "uploadmunje/munjeresultview";
    }
}