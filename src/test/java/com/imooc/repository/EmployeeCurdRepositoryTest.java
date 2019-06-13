package com.imooc.repository;

import com.imooc.domain.Employee;
import com.imooc.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCurdRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeService employeeService = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testSave() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = null;
        for(int i=0;i<100;i++){
            employee = new Employee();
            employee.setId(i);
            employee.setAge(100 - i);
            employee.setName("test"+i);
            employeeList.add(employee);
        }
        employeeService.save(employeeList);
    }


}
