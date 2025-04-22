package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("BoardFileDto")
public class BoardFileDto {
    private int num;
    private int idx;
    private String filename;
}
