package com.imooc;

import com.imooc.dao.StudentDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataTest {

    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        //studentDAO = (StudentDAO) ctx.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testEnityFactory() {

    }

}
