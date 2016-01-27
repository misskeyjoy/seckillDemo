package com.sohu.tv.cn.exception;

import com.sohu.tv.cn.dto.SeckillStateEnum;
import com.sohu.tv.cn.enity.Seckill;

/**
 * Created by misskey on 16-1-19.
 */
public class RepeatSeckillException extends  SeckillException {
    public RepeatSeckillException() {
        super(SeckillStateEnum.getState(-1).getStateinfo());
    }
}
