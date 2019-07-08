package com.org.seckill.dao;


import com.org.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
//告诉junit spring配置文件
public class SeckillDaoTest {
    @Resource
    private SeckillDao seckillDao;
    @Test
    public void testQueryById() {
        long id = 1002L;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill);
    }


    @Test
    public void testQueryAll() {
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for(Seckill seckill:seckills) {
            System.out.println(seckill);
        }
    }
}
