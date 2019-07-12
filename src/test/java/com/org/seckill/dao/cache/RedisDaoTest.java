package com.org.seckill.dao.cache;

import com.org.seckill.dao.SeckillDao;
import com.org.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class RedisDaoTest {


    private long seckillId = 1001;
    @Autowired
    private RedisDao redisDao;
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void testGetSeckill() {
        //get and put
        Seckill seckill = redisDao.getSeckill(seckillId);
        if(seckill == null) {
            seckill = seckillDao.queryById(seckillId);
            if(seckill != null) {
                String result = redisDao.putSeckill(seckill);
                System.out.println(result);
                seckill = redisDao.getSeckill(seckillId);
                System.out.println(result);
            }
        }
    }
}