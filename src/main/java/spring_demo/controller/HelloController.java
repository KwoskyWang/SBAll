package spring_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring_demo.service.AsyncService;

/**
 * Created by moooke on 2020/4/18.
 */
@Controller
public class HelloController {

    @Value("${demo.hello}")
    String plus;

    @Autowired
    AsyncService asyncService;

    @ResponseBody
    @RequestMapping("/hello")
    public String Hello(){
        for (int i=1; i<20; i++){
            asyncService.batchAdd();
        }
        return "hello..." + plus;
    }
}
