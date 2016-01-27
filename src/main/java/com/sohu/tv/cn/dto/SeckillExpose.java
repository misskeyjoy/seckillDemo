package com.sohu.tv.cn.dto;

import java.util.Date;

/**
 * Created by misskey on 16-1-20.
 */
public class SeckillExpose {
    /**
     *是否开启秒杀
     */
    private boolean isExpose;
    /**
     * 秒杀的md5值
     */
    private String md5;
    /**
     * 开启时间
     */
    private Date  startTime;
    /**
     * 结束时间
     */
    private Date   endTime;

    public SeckillExpose(boolean isExpose, String md5, Date endTime,Date startTime) {
        this.isExpose = isExpose;
        this.md5 = md5;
        this.endTime=endTime;
        this.startTime=startTime;
    }

    public SeckillExpose(boolean isExpose, Date endTime, Date startTime) {
        this.isExpose = isExpose;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public boolean isExpose() {
        return isExpose;
    }

    public void setExpose(boolean expose) {
        isExpose = expose;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "SeckillExpose{" +
                "isExpose=" + isExpose +
                ", md5='" + md5 + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
