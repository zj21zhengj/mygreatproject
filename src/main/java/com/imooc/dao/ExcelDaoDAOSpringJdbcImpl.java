package com.imooc.dao;

import com.imooc.domain.OrgBalanceDetail;
import com.imooc.domain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDaoDAOSpringJdbcImpl implements ExcelDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<OrgBalanceDetail> queryAll() {
        List<Object> argList = new ArrayList<>();
        List<OrgBalanceDetail> detailsall = new ArrayList<>();
        String sql = "select * from t_org_balance_detail";
        try {
            detailsall = jdbcTemplate.query(sql,argList.toArray(),new BeanPropertyRowMapper(OrgBalanceDetail.class));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return detailsall;
    }

    @Override
    public List<OrgBalanceDetail> query2() {
        final List<OrgBalanceDetail> students = new ArrayList<>();
        String sql = "select * from t_org_balance_detail";
        System.out.println(jdbcTemplate);
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                String id = rs.getString("org_code");
                String account_date = rs.getString("account_date");
                BigDecimal adjust_amount = rs.getBigDecimal("adjust_amount");

                OrgBalanceDetail studnet = new OrgBalanceDetail();
                studnet.setOrgCode(id);
                studnet.setAccountDate(account_date);
                studnet.setAdjustAmount(adjust_amount);
                students.add(studnet);
            }
        });
        return students;
    }

/*   有参数时的写法
    @Override
    public List<PayCarOrder> queryPayCarOrder(PayCarOrder payCarOrder) {
        List<Object> argList = new ArrayList<>();
        String sql = "select * from t_pay_car_order t where 1=1 ";
        if (StringUtils.isNotEmpty(payCarOrder.getSettleDate())) {
            sql += " and settle_date=? ";
            argList.add(payCarOrder.getSettleDate());
        }
        List<PayCarOrder> payCarOrderList = null;
        try {
            payCarOrderList = jdbcTemplate.query(sql, argList.toArray(), new BeanPropertyRowMapper(PayCarOrder.class));
        } catch (Exception e) {
            LOGGER.error("查询汽车金融信息异常", e);
        }
        return payCarOrderList;
    }*/


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}