package com.imooc.dao;

import com.imooc.domain.AccountFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AccountFlow> queryAll() {
        List<Object> argList = new ArrayList<>();
        List<AccountFlow> detailsall = new ArrayList<>();
        String sql = "SELECT * FROM ACCOUNT_FLOW  " +
                " where ID  not in (SELECT ID FROM ACCOUNT_FLOW WHERE TRANS_AMOUNT_IN =0 and  TRANS_AMOUNT_OUT = 0 and BALANCE =0) order by DATE desc  ";
        try {
            detailsall = jdbcTemplate.query(sql,argList.toArray(),new BeanPropertyRowMapper(AccountFlow.class));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return detailsall;
    }

}