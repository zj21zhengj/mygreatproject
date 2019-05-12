package com.imooc.dao;

import com.imooc.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentDAOImplTest {

    @Test
    public void testQuery() {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();

        for(Student student:students) {
            System.out.println("name "+student.getSname());
        }
    }

    @Test
    public void testSave() {
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setSid(10);
        student.setSname("hhha");
        student.setCid(11);
        studentDAO.save(student);

    }
}
