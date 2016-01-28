package com.sohu.tv.cn.web;

import com.sohu.tv.cn.dto.Result;
import com.sohu.tv.cn.dto.SeckillExpose;
import com.sohu.tv.cn.dto.SeckillResult;
import com.sohu.tv.cn.dto.SeckillStateEnum;
import com.sohu.tv.cn.enity.Seckill;
import com.sohu.tv.cn.exception.RepeatSeckillException;
import com.sohu.tv.cn.exception.SeckillCloseException;
import com.sohu.tv.cn.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by misskey on 16-1-26.
 */
@Controller
@RequestMapping("/seckill")
public class SeckillControl {
    /**
     * 1.暴露接口
     * 2. 秒杀
     * 3.获取系统时间
     * 4.查询所有的秒杀
     * 5.详情页
     */
    /**
     * 查询所有的秒杀
     *
     * @return
     */
    @Autowired
    SeckillService seckillService;

    /**
     * 返回所有秒杀商品的信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getSeckillList(Model model) {
        List<Seckill> mdatas = seckillService.getAllSeckill();
        model.addAttribute("seckills", mdatas);
        return "list";
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "index";
    }

    /**
     * 返回服务器的时间
     *
     * @return
     */
    @RequestMapping(value = "/date", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public Result<Long> getDate() {
        Date date = new Date();
        return new Result<Long>(true, date.getTime());
    }

    /**
     * 暴露秒杀接口
     *
     * @return
     */
    @RequestMapping(value = "/{seckillId}/exposeurl", produces = "application/json;charset=UTF-8",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<SeckillExpose> expose(@PathVariable long seckillId, HttpServletResponse response) {
        System.out.println("result -expose" +seckillId);
        response.setHeader("Access-Control-Allow-Origin", "*");
        Result<SeckillExpose> result;
        SeckillExpose expose = seckillService.exportSeckillUrl(seckillId);
        result = new Result<SeckillExpose>(true, expose);
        return result;
    }

    /**
     * 秒杀 采用的是异步请求
     * 返回的应该是 result 的json数据
     *
     * @param phone
     * @param seckillid
     */
    @RequestMapping(value = "/{seckillId}/{md5}/execute", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    //@RequestBody(name ="application/json,utf-8",required = false)
    @ResponseBody
    public Result<SeckillResult> excuete(@PathVariable long seckillid, @PathVariable String md5, @CookieValue(value = "skillphone", required = false) Long phone) {
        /**
         * 不存在的  -> 表示Cookie 中不存在该值
         *
         */
        Result<SeckillResult> result;
        if (phone == null) {
            result = new Result<SeckillResult>(false, "未登陆账号");
            return result;
        }
        try {
            SeckillResult seckillResult = seckillService.executeSeckill(seckillid, phone, md5);
            result = new Result<SeckillResult>(true, seckillResult);
        } catch (RepeatSeckillException reapex) {
            result = new Result<SeckillResult>(false, SeckillStateEnum.SECKILL_REPEAT.getStateinfo());
        } catch (SeckillCloseException sclo) {
            result = new Result<SeckillResult>(false, SeckillStateEnum.SECKILL_CLOSE.getStateinfo());
        } catch (Exception e) {
            result = new Result<SeckillResult>(false, SeckillStateEnum.SECKILL_FAILURE.getStateinfo());
        }
        return result;
    }

    /**
     * @return
     */
    @RequestMapping(value = "/{seckillId}/detail")
    public String getDetail(@PathVariable long seckillId, Model model) {
        Seckill seckill = seckillService.getSeckillById(seckillId);
        if (seckill == null) {
            return "list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }


}
