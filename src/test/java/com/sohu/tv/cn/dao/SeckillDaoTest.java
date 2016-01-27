package com.sohu.tv.cn.dao;

import com.sohu.tv.cn.enity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by misskey on 16-1-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {
    Logger logger= LoggerFactory.getLogger(SeckillDaoTest.class);
    @Resource
    SeckillDao seckillDao;

    @Test
    public void testQueryById() throws Exception {
        long id = 1001;
        Seckill seckill=seckillDao.queryById(id);
        System.out.println(seckill +"");
        List<Seckill> seckills=seckillDao.queryAll(1000,10);
        logger.info("seckills={}",seckills.size());
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Seckill> seckills=seckillDao.queryAll(0,10);
        logger.info("seckills={}",seckills.size());
    }

    @Test
    public void testReduceNumber() throws Exception {
        int affectedNum=-1;
         affectedNum=seckillDao.reduceNumber(10010,new Date());
        logger.info("affectedNum={}",affectedNum);
    }
}