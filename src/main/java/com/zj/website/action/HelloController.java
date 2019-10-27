package com.zj.website.action;

import com.imooc.dao.AccountDao;
import com.imooc.domain.AccountFlow;
import com.imooc.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController{

    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AccountDao accountDao;

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
    public String printHello4() {
        return "bankAccount";
    }

    @RequestMapping(value="/getFlow",method = RequestMethod.GET)
    @ResponseBody
    public  List<AccountFlow> printHello3(Model model) {
        System.out.println("xxxxx");
        List<AccountFlow> fl = accountDao.queryAll();
        System.out.println(fl.size());
        return fl;
    }

/*
    @ResponseBody
    @RequestMapping(value="/getFlow",method = RequestMethod.GET)
    public List<Accountflow> getFlow() {
        List<Accountflow> list = accountDao.queryAll();
        return list;
    }
*/

}