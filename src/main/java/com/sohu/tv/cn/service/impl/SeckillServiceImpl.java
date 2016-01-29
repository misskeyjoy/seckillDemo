package com.sohu.tv.cn.service.impl;

import com.sohu.tv.cn.dao.SeckillSuccessDao;
import com.sohu.tv.cn.dao.SeckillDao;
import com.sohu.tv.cn.dto.SeckillExpose;
import com.sohu.tv.cn.dto.SeckillResult;
import com.sohu.tv.cn.dto.SeckillStateEnum;
import com.sohu.tv.cn.enity.Seckill;
import com.sohu.tv.cn.enity.SeckillSuccess;
import com.sohu.tv.cn.exception.RepeatSeckillException;
import com.sohu.tv.cn.exception.SeckillCloseException;
import com.sohu.tv.cn.exception.SeckillException;
import com.sohu.tv.cn.service.SeckillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 实现SeckillService
 * Created by misskey on 16-1-19.
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    @Resource
    private SeckillDao seckillDao;
    @Resource
    private SeckillSuccessDao seckillSuccessDao;
    /**
     * md5盐值 随机生成没有规律
     */
    private static String indexmd5 = "&&&#$#$$%TFJFKLLDKOE99792#$$";

    public List<Seckill> getAllSeckill() {
        List<Seckill> mSeckills = seckillDao.queryAll(0, 10);
        return mSeckills;
    }

    public Seckill getSeckillById(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        return seckill;
    }

    /**
     * 暴露接口
     *
     * @param seckillId
     */
    public SeckillExpose exportSeckillUrl(long seckillId) {
        /**
         *
         *  获取当前的日期 来判断是否暴露秒杀接口
         */
        Date date = new Date();
        Seckill seckill = seckillDao.queryById(seckillId);
        /**
         * 在正确的时间进行秒杀
         */
        SeckillExpose seckillExpose = null;
        System.out.println("seckillId"+seckillId);
        if (date.getTime() >= seckill.getStartTime().getTime() && date.getTime() < seckill.getEndTime().getTime()) {
            String md5value = getMd5(seckillId);
            seckillExpose = new SeckillExpose(true, md5value,new Date(seckill.getEndTime().getTime()), new Date(seckill.getStartTime().getTime()));
        } else {
            seckillExpose = new SeckillExpose(false, new Date(seckill.getEndTime().getTime()), new Date(seckill.getStartTime().getTime()));
        }
        return seckillExpose;

    }

    /**
     * 秒杀核心方法
     *
     * @param secillId
     * @param userphone
     * @param md5
     * @throws RepeatSeckillException
     * @throws SeckillCloseException
     * @throws SeckillException
     */
    @Transactional
    public SeckillResult executeSeckill(long secillId, long userphone, String md5) throws RepeatSeckillException, SeckillCloseException, SeckillException {
        Date currentDate = new Date();
        try {
            //判断md5是否符合标准
            if (md5 == null || !getMd5(secillId).equals(md5)) {
                throw new SeckillException(SeckillStateEnum.getState(-3).toString());
            }
            //返回结果
            SeckillResult result = new SeckillResult();

            /**
             * 影响的行数
             */
            int affectedRows = seckillDao.reduceNumber(secillId, currentDate);
            /**
             * 插入失败
             */
            if (affectedRows <= 0) {
                throw new SeckillCloseException();
            } else {
                /**
                 * 秒杀成功
                 */
                int successaffedrows = seckillSuccessDao.insertsucesseckillId(secillId, userphone, 0);
                /**
                 * 判断插入success是否成功
                 * 插入不成功 分析 ：@ 以前秒杀成功 @mysql 比较繁忙
                 */
                //TODO 插入成功后但是插入信息失败时会导致秒杀失败
                if (successaffedrows > 0) {
                    try {
                        SeckillSuccess seckillSuccess = seckillSuccessDao.queryByIdwidthSeckill(secillId, userphone);
                        result.setSeckillSuccess(seckillSuccess);
                        result.setState(SeckillStateEnum.SECKILL_SUCCESS.getState());
                        result.setStateinfo(SeckillStateEnum.SECKILL_SUCCESS.getStateinfo());
                    } catch (Exception e) {
                        result.setState(SeckillStateEnum.SECKILL_SUCCESS.getState());
                        result.setStateinfo(SeckillStateEnum.SECKILL_BUSY.getStateinfo());
                    }
                    return result;
                } else {
                    throw new RepeatSeckillException();
                }
            }
        } catch (RepeatSeckillException repeateseckill) {
            throw repeateseckill;
        } catch (SeckillException sekillexception) {
            throw sekillexception;
        } catch (Exception e) {
            //e.printStackTrace();
            throw new SeckillException(e.getMessage());
        }
    }

    private String getMd5(long seckId) {
        String md5 = seckId + "/" + indexmd5;
        return new String(DigestUtils.md5DigestAsHex(md5.getBytes()));
    }
}
