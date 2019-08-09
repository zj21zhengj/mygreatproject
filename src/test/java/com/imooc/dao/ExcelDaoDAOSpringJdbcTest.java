package com.imooc.dao;

import com.imooc.domain.OrgBalanceDetail;
import com.imooc.domain.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ExcelDaoDAOSpringJdbcTest {
    private ApplicationContext ctx = null;
    private ExcelDao excelDao = null;

    private StudentDAO studentDAO = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans2.xml");
        excelDao = (ExcelDao) ctx.getBean("excelDao");
        //studentDAO = (StudentDAO) ctx.getBean("studentDAO");
        System.out.println("setup");
    }

    @Test
    public void testJdbcTemplate() {
        System.out.println("testJdbcTemplate");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
        System.out.println(jdbcTemplate == null);
        Assert.assertNotNull(jdbcTemplate);

    }

    @Test
    public void testQuery() {
        //不需要new 了交给spring管理 new的话会报null错误
        //StudentDAO studentDAO = new StudentDAOImpl();
        List<OrgBalanceDetail> students = excelDao.queryAll();

        System.out.println(students.size());
    }

    @Test
    public void testQuery2() {
        //不需要new 了交给spring管理 new的话会报null错误
        //StudentDAO studentDAO = new StudentDAOImpl();
        List<OrgBalanceDetail> students = excelDao.query2();

        System.out.println(students.size());
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }
}
