package cn.ukar.controller;

import com.ukar.dao.DemoDao;
import com.ukar.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jyou on 2017/8/17.
 * 测试controller
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("test.do")
    @ResponseBody
    public String test(){
        return "SUCCESS";
    }

}
