package com.sohu.tv.cn.service;

import com.sohu.tv.cn.dto.SeckillExpose;
import com.sohu.tv.cn.dto.SeckillResult;
import com.sohu.tv.cn.enity.Seckill;
import com.sohu.tv.cn.exception.RepeatSeckillException;
import com.sohu.tv.cn.exception.SeckillCloseException;
import com.sohu.tv.cn.exception.SeckillException;

import java.util.Date;
import java.util.List;

/**
 * Created by misskey on 16-1-19.
 */
public interface SeckillService {
    /**
     * 获得所有的秒杀活动
     * @return
     */
   public List<Seckill> getAllSeckill();

    /**
     * 通过id 来查找秒杀活动
     * @param seckillId
     * @return
     */
   public Seckill getSeckillById(long seckillId);

    /**
     * 暴露接口
     * @param seckillId
     */
    public SeckillExpose exportSeckillUrl(long seckillId);


    /**
     * 执行秒杀活动
     * @param userphone
     *
     */
    public SeckillResult executeSeckill(long secillId, long userphone, String md5)
            throws RepeatSeckillException,SeckillCloseException,SeckillException;
}
