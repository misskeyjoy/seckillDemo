package com.sohu.tv.cn.dao;

import com.sohu.tv.cn.enity.SeckillSuccess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by misskey on 16-1-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillSuccessDaoTest {
    @Resource
    SeckillSuccessDao seckillSuccessDao;
    Logger logger= LoggerFactory.getLogger(SeckillSuccessDaoTest.class);
    @Test
    public void testInsertsucesseckillId() throws Exception {
       int affectedRows= seckillSuccessDao.insertsucesseckillId(1000L,1832269620L,1);
       logger.info("affectedRows={}",affectedRows);
    }

    @Test
    public void testQueryByIdwidthSeckill() throws Exception {
        SeckillSuccess seckSuccess= seckillSuccessDao.queryByIdwidthSeckill(1000L,1832269620L);
        logger.info("seckSuccess={}",seckSuccess);
    }
}