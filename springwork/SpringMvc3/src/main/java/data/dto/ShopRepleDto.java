package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("ShopRepleDto")//패키지 안넣어도되기때문에 사용하는것!
public class ShopRepleDto {
    private int idx;
    private int num;
    private int likes;
    private String message;
    private String photo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp writetime;
}
