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
        String sql = "insert into my_temp(flow,type,trans_date,org_code,serial_no,trade_no,oper_acct,last_update_time,amount) values (?,?,?,?,?,?,?,?,?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getFlow());
            preparedStatement.setString(2,person.getType());
            preparedStatement.setString(3,person.getTransDate());
            preparedStatement.setString(4,person.getOrgCode());
            preparedStatement.setString(5,person.getQianZhi());
            preparedStatement.setString(6,person.getDingDan());
            preparedStatement.setString(7,person.getOper());
            preparedStatement.setString(8,person.getUpdateTime());
            preparedStatement.setDouble(9,person.getMoneys());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
    }
}
