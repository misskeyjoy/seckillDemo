package com.sohu.tv.cn.service.impl;

import com.sohu.tv.cn.dto.SeckillExpose;
import com.sohu.tv.cn.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by misskey on 16-1-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {
    Logger logger= LoggerFactory.getLogger(SeckillServiceImplTest.class);
    @Resource
    SeckillService seckillService;
    @Test
    public void testExportSeckillUrl() throws Exception {
      SeckillExpose seckillExpose= seckillService.exportSeckillUrl(1000);
      logger.info("seckillExpose={}",seckillExpose);
    }

    @Test
    public void testExecuteSeckill() throws Exception {

    }
}