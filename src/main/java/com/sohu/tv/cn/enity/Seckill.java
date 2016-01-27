package com.sohu.tv.cn.enity;


import java.sql.Timestamp;

/**
 * Created by misskey on 16-1-18.
 */
public class Seckill {
    private long seckillId;
    private int secknum;
    private String seckseller;
    private String seckinfo;
    private Timestamp startTime;
    private Timestamp endTime;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(short seckillId) {
        this.seckillId = seckillId;
    }

    public int getSecknum() {
        return secknum;
    }

    public void setSecknum(int secknum) {
        this.secknum = secknum;
    }

    public String getSeckseller() {
        return seckseller;
    }

    public void setSeckseller(String seckseller) {
        this.seckseller = seckseller;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getSeckinfo() {
        return seckinfo;
    }

    public void setSeckinfo(String seckinfo) {
        this.seckinfo = seckinfo;
    }

    @Override
    public String toString() {
        return "Seckill{" +
                "seckillId=" + seckillId +
                ", secknum=" + secknum +
                ", seckseller=" + seckseller +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
