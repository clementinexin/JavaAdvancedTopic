package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by daijiajia on 2016/12/12.
 */
@Controller
public class HelloController {


    /*
    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
    */

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/err")
    public String error() throws Exception {
        throw new Exception("error");
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/greet")
    public String greet(@RequestParam String name) {
        return "你好 " + name;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
