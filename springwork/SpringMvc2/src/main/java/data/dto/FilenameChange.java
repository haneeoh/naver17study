package data.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FilenameChange {
    static public String getDateChangeFilename(String originalName)
    {
        //파일명에 날짜를 붙여서 업로드해보자
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        //예)a.jpg => a_20250218104123.jps
        // . 을 기준으로 파일명 확장자 나누기
        String fileName=originalName.split("\\.")[0];
        String exName=originalName.split("\\.")[1];

        System.out.println(exName);//확장자만 나오는지 확인
        System.out.println(fileName);//파일명만 나오는지 확인

        //최종 업로드할 파일명
        String uploadFileName = fileName+"_"+sdf.format(new Date())+"."+exName;
        System.out.println(uploadFileName);

        return uploadFileName;
    }

static public String getRandomChangeFileName(String originalName)
{
    //확장자만 구하기
    String exName=originalName.split("\\.")[1];

    //최종 업로드할 파일명
    String uploadFileName = UUID.randomUUID()+"."+exName;
    System.out.println(uploadFileName);

    return uploadFileName;
}
}
