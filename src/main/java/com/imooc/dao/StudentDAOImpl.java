package com.imooc.dao;

import com.imooc.domain.Student;
import com.imooc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO访问接口实现类，通过最原始的JDBC的方式访问
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> query() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select sid,sname,cid from students";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("sid");
                String name = resultSet.getString("sname");
                int cid = resultSet.getInt("cid");
                student = new Student();
                student.setSid(id);
                student.setSname(name);
                student.setCid(cid);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           JDBCUtil.release(resultSet,preparedStatement,connection);
        }
        return students;
    }

    @Override
    public void save(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into students values (?,?,?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,student.getSid());
            preparedStatement.setString(2,student.getSname());
            preparedStatement.setInt(3,student.getCid());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
    }
}
