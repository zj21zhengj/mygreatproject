package com.imooc.repository;

import com.imooc.dao.StudentDAO;
import com.imooc.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName() {
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println("id:"+employee.getId()+", name" +employee.getName());
    }


    @Test
    public void testGetEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println("id:"+employee.getId()+", name" +employee.getName());
    }

    @Test
    public void testQueryParams() {
        List<Employee> employees = employeeRepository.queryParams1("xxx",33);
        for(Employee employee:employees)
            System.out.println("id:"+employee.getId()+", name" +employee.getName());
    }

    @Test
    public void testQueryParams2() {
        List<Employee> employees = employeeRepository.queryParams2("xxx",33);
        for(Employee employee:employees)
            System.out.println("id:"+employee.getId()+", name" +employee.getName());
    }

    @Test
    public void testQueryLike1() {
        List<Employee> employees = employeeRepository.queryLike1("xx");
        for(Employee employee:employees)
            System.out.println("id:"+employee.getId()+", name" +employee.getName());
    }

    @Test
    public void testQueryLike2() {
        List<Employee> employees = employeeRepository.queryLike2("xx");
        for(Employee employee:employees)
            System.out.println("id:"+employee.getId()+", name" +employee.getName());
    }

    @Test
    public void testGetCount() {
        long l = employeeRepository.getCount();
        System.out.println(l);
    }
}
