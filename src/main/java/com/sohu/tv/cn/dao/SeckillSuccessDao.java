package com.sohu.tv.cn.dao;

import com.sohu.tv.cn.enity.SeckillSuccess;
import org.apache.ibatis.annotations.Param;

/**
 * Created by misskey on 16-1-18.
 */
public interface SeckillSuccessDao {
    /**
     * 记录秒杀信息
     *
     * @param seckid 秒杀成功的id
     *               * @param userphone
     * @return
     */
    public int insertsucesseckillId(@Param("seckid") long seckid, @Param("userphone") long userphone, @Param("state") int state);

    /**
     * 通过秒杀id来 查找信息
     *
     * @param seckillId
     * @return
     */
    public SeckillSuccess queryByIdwidthSeckill(@Param("seckillId") long seckillId, @Param("userphone") long userphone);


}
