package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
//@Controller
//@ResponseBody
@RestController
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("OK");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() throws IOException {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() throws IOException {
        return "OK";
    }

//    @PostMapping(value = "/testtest", produces = "text/html")
//    public String mappingProduces() {
//        log.info("mappingProduces");
//        return "ok";
//    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() throws IOException {
        return new ResponseEntity<>(HelloData.builder().age(11).username("애옹").build(),HttpStatus.OK);
    }

    // @ResponseStatus 애노테이션을 없애면 ResponseEntity중 body에 들어가는 값만 전달된다.
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public ResponseEntity<HelloData> responseBodyJsonV2() throws IOException {
        return new ResponseEntity<>(HelloData.builder().age(11).username("애옹").build(),HttpStatus.BAD_REQUEST);
    }
}
