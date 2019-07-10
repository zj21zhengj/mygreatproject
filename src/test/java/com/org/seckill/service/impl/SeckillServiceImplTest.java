package com.org.seckill.service.impl;

import com.org.seckill.dto.Exposer;
import com.org.seckill.dto.SeckillExecution;
import com.org.seckill.entity.Seckill;
import com.org.seckill.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/applicationContext.xml",
        "classpath:spring/applicationContext-service.xml"
})
public class SeckillServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void exportSeckillUrl() {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
        //md5=3a3805686be0724a93600e2a3cc143a3
    }

    @Test
    public void executeSeckill() {
        long id = 1000;
        long phone = 13801920804L;
        String md5 = "3a3805686be0724a93600e2a3cc143a3";
        SeckillExecution seckillExecution = seckillService.executeSeckill(id,phone,md5);
        logger.info("executeSeckill={}",seckillExecution);
    }

    @Test
    public void executeSeckillProcedure() {
    }
}