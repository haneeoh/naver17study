package bitcamp.study;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component  //mycar 라는 이름으로 등록(첫글자 소문자)
@Data
public class Mycar {
    @Value("아우디 A6")
    private String mycarName;
    @Value("진주색")
    private String mycarColor;
}
