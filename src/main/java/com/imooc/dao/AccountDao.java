package com.imooc.dao;


import com.imooc.domain.AccountFlow;

import java.util.List;

public interface AccountDao {
    List<AccountFlow> queryAll();
}