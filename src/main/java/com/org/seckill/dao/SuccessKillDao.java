package com.org.seckill.dao;

import com.org.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

public interface SuccessKillDao {


    /**
     * 插入购买明细，可过滤重复
     * 插入的行数
     * @param seckillId
     * @param userPhone
     * @return
     */
    int insertSuccesskilled(@Param("sekillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询skilled 并携带商品对象
     */
    SuccessKilled queryByIdWithSeckill(@Param("sekillId") long seckillId, @Param("userPhone") long userPhone);
}
