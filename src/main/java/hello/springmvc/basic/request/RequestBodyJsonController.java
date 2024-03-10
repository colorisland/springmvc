package hello.springmvc.basic.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * {"username":"hello", "age":20}
 * content-type: application/json
 */
@Slf4j
@Controller
public class RequestBodyJsonController {

    @PostMapping("/request-body-json-v2")
    @ResponseBody
    public String requestBodyJsonV2(@RequestBody String messageBody) throws JsonProcessingException {
        ObjectMapper objectMapper= new ObjectMapper();
        HelloData data = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        return "OK";
    }

    @PostMapping("/request-body-json-v3")
    @ResponseBody
    public HelloData requestBodyJsonV3(@RequestBody HelloData helloData) {
        log.info("requestBody : {}", helloData.getUsername());
        // request 뿐만 아니라 response에도 HttpMessageConverter 가 적용된다.
        return helloData;
    }
}
