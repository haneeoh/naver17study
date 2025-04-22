package data.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//properties 설정파일에서 emp로 시작하는 값을 읽어온다
@Configuration //[자동] 설정파일로 bean 을 등록해주는 기능
//@PropertySource("classpath:/application.properties") //이 프로젝트에서는 이게 기본값이라 생략가능
@ConfigurationProperties(prefix = "emp")
@Data
public class MyPropDto {
    private String addr;
    private String hp;
}
