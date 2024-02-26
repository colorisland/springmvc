package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    // slf4j 의 로그 라이브러리를 사용하고 파라미터로 현재 클래스를 넣어준다. Slf4j 애노테이션 설정하면 생략가능.
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "String";
        log.trace("trace log:{}, {}",name,name);
        log.info("info log:{}, {}",name,name);
        log.warn("warn log:{}, {}",name,name);
        log.error("error log:{}, {}",name,name);
        return "Ok";
    }
}
