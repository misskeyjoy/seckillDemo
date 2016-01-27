package com.sohu.tv.cn.dao;

import com.sohu.tv.cn.enity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by misskey on 16-1-18.
 */
public interface SeckillDao {
    /**
     * 通过seckillid 来查找秒杀活动
     *
     * @param seckillid
     */
    public Seckill queryById(long seckillid);
    /**
     * 查询秒杀活动
     *
     * @param start
     * @param offset
     * @return
     */
    public List<Seckill> queryAll(@Param("start") int start, @Param("offset") int offset);
    /**
     * 秒杀活动开启
     * 使用Param 来确保参数正确
     * @param seckillid
     * @return 1表示更改1行 0表示没有修改
     */
    public int reduceNumber(@Param("seckillid") long seckillid,@Param("seckilltime") Date seckilltime);
}
