package com.imooc.dao;

import com.imooc.domain.OrgBalanceDetail;
import com.imooc.domain.Student;

import java.util.List;

public interface ExcelDao {
    /**
     * 查询所有学生
     * @return
     */
    List<OrgBalanceDetail> queryAll();

    List<OrgBalanceDetail> query2();
}
