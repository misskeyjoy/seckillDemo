package com.sohu.tv.cn.dto;

/**
 * 秒杀状态类
 * Created by misskey on 16-1-19.
 */
public enum SeckillStateEnum {
    SECKILL_SUCCESS(1, "秒杀成功"),
    SECKILL_REPEAT(-1, "重复秒杀"),
    SECKILL_FAILURE(-2, "秒杀失败"),
    //md5 值不一致
    SECKILL_BUSY(-5,"系统繁忙"),
    SECKILL_UNFAILUER(-3, "md5值不一致"),
    SEKILL_NOTFUOND(-4,"商品未找到"),
    SECKILL_CLOSE(0, "秒杀结束");
    // 秒杀结束 重复秒杀 秒杀失败
    /**
     * 当前的状态
     */
    private int state;
    /**
     * 信息状态
     */
    private String stateinfo;

    private SeckillStateEnum(int state, String stateinfo) {
        this.state = state;
        this.stateinfo = stateinfo;
    }

    public static SeckillStateEnum getState(int index) {
        for (SeckillStateEnum seckEnum : values()) {
            if (seckEnum.state == index) {
                return seckEnum;
            }
        }
        return null;
    }

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
}
