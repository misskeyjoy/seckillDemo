package com.sohu.tv.cn.exception;

import com.sohu.tv.cn.dto.SeckillStateEnum;

/**
 * 秒杀结束异常
 * Created by misskey on 16-1-19.
 */
public class SeckillCloseException extends  SeckillException {

    public SeckillCloseException() {
        super(SeckillStateEnum.getState(0).getStateinfo());
    }
}
