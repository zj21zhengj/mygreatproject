package com.imooc.domain;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * 1 Repository是空接口，标记接口 没有声明方法
 * 2如果不继承 Repository 运行时会报错 可以添加注解
 * @RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
 *
 * 按照方法名有弊端：
 *  方法名比较长，约定大于配置
 *  对于一些复杂的查询，是很难实现的
 *
 *
 * @Query
 * 事务在spring data中的使用
 * 1） 事务一般是在Service层
 * 2）@Query @Modifying @Transitional 的综合使用
 */
public interface EmployeeRepository extends Repository<Employee,Integer> {

    public Employee findByName(String name);

    //以什么开始并且年龄小于
    List<Employee> findByNameStartingWithAndAgeLessThan(String name,Integer age);

    //name in 或者 age小于
    List<Employee> findByNameInAndAgeLessThan(List<String> names,Integer age);

    /**
     * 注意是from bean 不是表名，表要用原生的
     * @return
     */
    @Query("select o from Employee o where id=(select max(id) from Employee t1)")
    Employee getEmployeeByMaxId();

    @Query("select o from Employee o where o.name = ?1 and o.age = ?2")
    List<Employee> queryParams1(String name,Integer age);

    @Query("select o from Employee o where o.name = :name2 and o.age = :age2")
    List<Employee> queryParams2(@Param("name2")String name, @Param("age2")Integer age);

    @Query("select o from Employee o where o.name like %?1%")
    List<Employee> queryLike1(String name);

    @Query(nativeQuery = true,value ="select o.* from employee o where o.name like %:name2%")
    List<Employee> queryLike2(@Param("name2") String name);

    @Query(nativeQuery = true,value = "select count(1) from employee")
    long getCount();

    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    void update(@Param("id")Integer id,@Param("age")Integer age);
 }
