package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    // 지금 RestController 가 아닌 뷰 반환하는 Controller 라서 @ResponseBody 애노테이션 추가.
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String username,
                               @RequestParam("age") int age) throws IOException {
        log.info("username={}, age={}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age) throws IOException {
        log.info("username={}, age={}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username,
                                 int age) throws IOException {
        log.info("username={}, age={}", username, age);
        return "OK";
    }

    // 필수 여부 설정가능. (근데 기본값이 required = true이다.)
    // int 형에는 null이 들어갈 수 없기 때문에 Ingeter 형식으로 파라미터를 받아야 한다.
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true, defaultValue = "something") String username,
                                 @RequestParam(required = false, defaultValue = "-1") Integer age) throws IOException {
        log.info("username={}, age={}", username, age);
        return "OK";
    }

    // multiValueMap으로 파라미터 조회 가능.
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam MultiValueMap<String, Object> map) throws IOException {
        log.info("username={}, age={}", map.get("username"), map.get("age"));
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        return "OK";
    }

    // @ModelAttribute 애노테이션 생략가능.
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        return "OK";
    }
}
