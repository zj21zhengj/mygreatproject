package com.org.seckill.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.org.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Param;


public interface SeckillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    //如果影响行数>1表示更行行数
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offst") int offset, @Param("limit") int limit);

    void killByProcedure(Map<String,Object> map);
}
