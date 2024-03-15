package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView modelAndView = new ModelAndView("response/hello")
                .addObject("data", "hello"); // 변수이름, 실제 들어가는 값.
        return modelAndView;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        // 클라이언트에게 응답으로 돌려주는 작업의 처리 결과 데이터를 Model이라 한다.
        // spring이 model 에 데이터를 세팅해서 템플릿에 자동으로 넘겨준다.
        model.addAttribute("data", "hello!!!!");
        return "response/hello";
    }

    // 권장하지 않는 방법.
    // 컨트롤러의 request mapping경로와 템플릿경로가 같으면 바로 템플릿 뷰를 찾아준다.
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello~~~~");
    }
}
