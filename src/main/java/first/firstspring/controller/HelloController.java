package first.firstspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello-spring!");
        return "hello"; // 여기의 리턴값이 templates/<리턴값>.html 파일을 찾음
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http프로토콜의 body에 직접 넣어주겠다는 뜻.
    public String helloString(@RequestParam("name") String name)
    {
        return "hello "+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //json 방식(기본적으로 json방식으로 이용 XML 잘 이용안함)
    }
    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name)
        {
            this.name = name;
        }

    }
}
