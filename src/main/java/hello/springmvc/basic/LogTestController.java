package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//로그 관련 컨트롤러


@Slf4j
@RestController
public class LogTestController {
   //private final Logger log = LoggerFactory.getLogger(getClass()); = @Slf4j 이 역할이다.


    @GetMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        //System.out.println("name = " + name); //얘는 필요없음

        //로그의 올바른 사용 법
        log.trace("trace log={}", name);
        log.debug("debug log={}", name); //개발 서버할 때 보는거야
        log.info("info log={}", name); //중요한 정보야 비즈니스 정보구나 운영시스템에서 봐야하는 정보
        log.warn("warn log={}", name); //경고 위험
        log.error("error log={}", name); //이건 에러야 빨리 확인해야 돼

        return "ok";
    }

}
