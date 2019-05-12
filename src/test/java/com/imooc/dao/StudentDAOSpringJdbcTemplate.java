package com.imooc.dao;

import com.imooc.domain.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDAOSpringJdbcTemplate {

    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO = (StudentDAO) ctx.getBean("studentDAO");
        System.out.println("setup");
    }


    @Test
    public void testJdbcTemplate() {
        System.out.println("testJdbcTemplate");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);

    }

    @Test
    public void testQuery() {
        //不需要new 了交给spring管理
        //StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();

        for(Student student:students) {
            System.out.println("name "+student.getSname());
        }
    }

    @Test
    public void testSave() {
        Student st = new Student();
        st.setSname("xxxs");
        st.setCid(111);
        studentDAO.save(st);
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

}
