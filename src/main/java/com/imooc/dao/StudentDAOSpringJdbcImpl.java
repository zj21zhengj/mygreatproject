package com.imooc.dao;

import com.imooc.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO访问接口实现类，通过spring JDBC的方式访问
 */
public class StudentDAOSpringJdbcImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> query() {
        final List<Student> students = new ArrayList<>();
        String sql = "select sid,sname,cid from students";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                int id = rs.getInt("sid");
                String name = rs.getString("sname");
                int cid = rs.getInt("cid");

                Student studnet = new Student();
                studnet.setSid(id);
                studnet.setSname(name);
                studnet.setCid(cid);
                students.add(studnet);
            }
        });
        return students;
    }

    @Override
    public void save(Student student) {
        String sql = "insert into students(sname,cid) values (?,?)";
        jdbcTemplate.update(sql,new Object[]{student.getSname(),student.getCid()});
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
