package com.zj.website.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController{

    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String printHello(Model model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "wiki/wiki";
    }

    @RequestMapping(value="/hello2",method = RequestMethod.GET)
    public String printHello2(Model model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "article/article_form";
    }

    @RequestMapping(value="/hello3",method = RequestMethod.GET)
    public String printHello3(Model model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "index";
    }

}