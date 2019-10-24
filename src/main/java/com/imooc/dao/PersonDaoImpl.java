package com.imooc.dao;

import com.imooc.domain.Person;
import com.imooc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void save1(Person person) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into t_report_download_stat2(download_code,download_time,type,ip) values (?,?,?,?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getQianZhi());
            preparedStatement.setString(2,person.getUpdateTime());
            preparedStatement.setString(3,person.getOper());
            preparedStatement.setString(4,person.getFlow());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
    }
}
