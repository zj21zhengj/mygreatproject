package com.imooc.domain;

import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends Repository<Employee,Integer> {

    public Employee findByName(String name);
}
