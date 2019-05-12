package com.imooc.dao;

import com.imooc.domain.Student;

import java.util.List;

public interface StudentDAO {
    /**
     * 查询所有学生
     * @return
     */
    List<Student> query();

    void save(Student student);
}
