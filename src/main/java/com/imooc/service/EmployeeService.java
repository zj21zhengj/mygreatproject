package com.imooc.service;


import com.imooc.domain.Employee;
import com.imooc.repository.EmployeeCurdRepository;
import com.imooc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCurdRepository employeeCurdRepository;

    @Transactional
    public void update(Integer id,Integer age) {
        employeeRepository.update(id,age);
    }

    @Transactional
    public void save(List<Employee> employees){
        employeeCurdRepository.save(employees);
    }
}
