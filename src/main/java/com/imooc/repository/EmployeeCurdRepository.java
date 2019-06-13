package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCurdRepository extends CrudRepository<Employee,Integer> {
}
