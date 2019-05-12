package com.imooc.domain;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;


/**
 * 1 Repository是空接口，标记接口 没有声明方法
 * 2如果不继承 Repository 运行时会报错 可以添加注解
 * @RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
 *
 * 按照方法名有弊端：
 *  方法名比较长，约定大于配置
 *  对于一些复杂的查询，是很难实现的
 */
public interface EmployeeRepository extends Repository<Employee,Integer> {

    public Employee findByName(String name);

    //以什么开始并且年龄小于
    List<Employee> findByNameStartingWithAndAgeLessThan(String name,Integer age);

    //name in 或者 age小于
    List<Employee> findByNameInAndAgeLessThan(List<String> names,Integer age);

 }
