package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {}, age = {}", username, age);


        response.getWriter().write("ok");

    }

    //위에 보다 보다 쉽게 사용할 수 있다.

    @ResponseBody //return "ok"를 view 반환하지 않고 문자로 바로 해줌
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("username = {}, age = {}", memberName, memberAge);
        return "ok";
    }


    @ResponseBody //return "ok"를 view 반환하지 않고 문자로 바로 해줌
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) // 위코드처럼 사용하지 않고 생략할 수 있다 다만 요청 파라미터와 맞아야한다.
    {

        log.info("username = {}, age = {}", username, age);
        return "ok";
    }


    @ResponseBody //return "ok"를 view 반환하지 않고 문자로 바로 해줌
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) // 위코드처럼 사용하지 않고 생략할 수 있다 다만 요청 파라미터와 맞아야한다.
    {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    @ResponseBody //return "ok"를 view 반환하지 않고 문자로 바로 해줌
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            //required true 필수적으로 기입해야 한다는 뜻
            //required fales 안넣어도 상관 없음 꼭 유용할 듯
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {
        // int a = null 안됨
        // Integer = null 사용가능
        log.info("username = {}, age = {}", username, age);
        return "ok";


    }




    @ResponseBody //return "ok"를 view 반환하지 않고 문자로 바로 해줌
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            //required true 필수적으로 기입해야 한다는 뜻
            //required fales 안넣어도 상관 없음 꼭 유용할 듯
            //default = 회원이름 없을 뜻 그냥 내가 지정한 걸로 하겠다는 뜻
            //Integer를 int로 사용가능
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age) {
        // int a = null 안됨
        // Integer = null 사용가능
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }


    @ResponseBody //return "ok"를 view 반환하지 않고 문자로 바로 해줌
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            //required true 필수적으로 기입해야 한다는 뜻
            //required fales 안넣어도 상관 없음 꼭 유용할 듯
            //default = 회원이름 없을 뜻 그냥 내가 지정한 걸로 하겠다는 뜻
            //Integer를 int로 사용가능
            @RequestParam Map<String, Object> paramMap){
        // int a = null 안됨
        // Integer = null 사용가능
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        log.info("paramMap = {}", paramMap);
        return "ok";
    }

//    @ResponseBody
//    @RequestMapping("/model-attribute-v1")
//    public String modelAttributeV1(@RequestParam String username,
//                                   @RequestParam int age){
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
//
//        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
//        log.info("helloData={}", helloData);
//        return "ok";
//    }

    //위에 있는부분을 이렇게 수정가능
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){

        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);
        return "ok";
    }

    /**
     * @ModelAttribute 생략 가능
     * String, int 같은 단순 타입 = @RequestParam
     * argument resolver 로 지정해둔 타입 외 = @ModelAttribute
     */
    //위에 있는부분을 이렇게 수정가능
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){

        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);
        return "ok";
    }






}