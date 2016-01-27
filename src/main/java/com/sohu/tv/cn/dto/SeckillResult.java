package com.sohu.tv.cn.dto;

import com.sohu.tv.cn.enity.SeckillSuccess;

/**
 * Created by misskey on 16-1-20.
 */
public class SeckillResult {
    //state stateinfo successkill
    private int state;
    /**
     *  秒杀的状态
     */
    private String  stateinfo;
    /**
     * 秒杀成功
     */
    private SeckillSuccess seckillSuccess;

    public String getStateinfo() {
        return stateinfo;
    }

    public void setStateinfo(String stateinfo) {
        this.stateinfo = stateinfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public SeckillSuccess getSeckillSuccess() {
        return seckillSuccess;
    }

    public void setSeckillSuccess(SeckillSuccess seckillSuccess) {
        this.seckillSuccess = seckillSuccess;
    }

    @Override
    public String toString() {
        return "SeckillResult{" +
                "state=" + state +
                ", stateinfo='" + stateinfo + '\'' +
                ", seckillSuccess=" + seckillSuccess +
                '}';
    }
}
