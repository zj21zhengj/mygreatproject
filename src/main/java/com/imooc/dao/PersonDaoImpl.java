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
        String sql = "insert into ACCOUNT_FLOW(DATE,TIME,CURRENCY,TRANS_AMOUNT_IN,TRANS_AMOUNT_OUT,BALANCE,TRANS_TYPE,TRANS_REMARK) values (?,?,?,?,?,?,?,?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getDingDan());
            preparedStatement.setString(2,person.getUpdateTime());
            preparedStatement.setString(3,person.getOrgCode());
            preparedStatement.setLong(4,person.getMoneyin());
            preparedStatement.setLong(5,person.getMoneyout());
            preparedStatement.setLong(6,person.getMoney());
            preparedStatement.setString(7,person.getFlow());
            preparedStatement.setString(8,person.getOper());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
    }
}
