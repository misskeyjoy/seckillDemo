package com.sohu.tv.cn.enity;

import java.util.Date;

/*
 * Created by misskey on 16-1-18.
 */
public class SeckillSuccess {
    private short  seckillId;
    private  long usertel;
    private Date createtime;

    /**
     * 商品的 状态
     */
    private  Integer state;
    /**
     * 秒杀到的商品
     */
    private  Seckill seckill;
    public short getSeckillId() {
        return seckillId;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setSeckillId(short seckillId) {
        this.seckillId = seckillId;
    }

    public long getUsertel() {
        return usertel;
    }

    public void setUsertel(long usertel) {
        this.usertel = usertel;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SeckillSuccess{" +
                "seckillId=" + seckillId +
                ", usertel='" + usertel + '\'' +
                ", state=" + state +
                ", seckill=" + seckill +
                '}';
    }
}
