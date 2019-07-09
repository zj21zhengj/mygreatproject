package com.jsonp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 返回问题
     * https://www.cnblogs.com/zhoujian43/p/6640804.html
     * @return
     * 测试用例是 和 mybootweb 里的com.springboot.web.controller
     * HelloController联合测试 跨域问题
     */
    @GetMapping("/get1")
    public ResultBean get1(){
        System.out.println("TestController.get1()");
        return new ResultBean("get1 ok");
    }
}
