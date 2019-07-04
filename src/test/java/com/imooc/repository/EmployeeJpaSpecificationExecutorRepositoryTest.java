package com.imooc.repository;

import com.imooc.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJpaSpecificationExecutorRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    /**
     * 分页
     * 排序
     * 查询条件  年龄大于50
     */
    @Test
    public void testQuery() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0,5,sort);


        /**
         * root就是要查询的类型 就是 Employee
         * query添加查询条件
         * cb 构建Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                //root(employee (age))
                /*
                Path path = root.get("age");
                return cb.gt(path,50);
                */
                List<Predicate> list = new ArrayList<>();
                list.add(cb.equal(root.get("name").as(String.class), "张三"));
                list.add(cb.gt(root.<Number>get("age"),20));
                Predicate[] p = new Predicate[list.size()];
                return  cb.and(list.toArray(p));
            }
        };

        //Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(pageable);

        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);

        System.out.println("查询的总页数:"+page.getTotalPages());
        System.out.println("查询的总记录是:"+page.getTotalElements());
        System.out.println("查询当前第几页:"+page.getNumber());
        System.out.println("查询的当前页面的集合:"+page.getContent());
        System.out.println("查询的当前页面的记录是:"+page.getNumberOfElements());
    }


}
